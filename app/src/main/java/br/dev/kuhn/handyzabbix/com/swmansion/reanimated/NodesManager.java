package com.swmansion.reanimated;

import android.util.SparseArray;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.github.mikephil.charting.utils.Utils;
import com.reactcommunity.rndatetimepicker.RNConstants;
import com.swmansion.reanimated.layoutReanimation.AnimationsManager;
import com.swmansion.reanimated.nodes.AlwaysNode;
import com.swmansion.reanimated.nodes.BezierNode;
import com.swmansion.reanimated.nodes.BlockNode;
import com.swmansion.reanimated.nodes.CallFuncNode;
import com.swmansion.reanimated.nodes.ClockNode;
import com.swmansion.reanimated.nodes.ClockOpNode;
import com.swmansion.reanimated.nodes.ConcatNode;
import com.swmansion.reanimated.nodes.CondNode;
import com.swmansion.reanimated.nodes.DebugNode;
import com.swmansion.reanimated.nodes.EventNode;
import com.swmansion.reanimated.nodes.FunctionNode;
import com.swmansion.reanimated.nodes.JSCallNode;
import com.swmansion.reanimated.nodes.Node;
import com.swmansion.reanimated.nodes.NoopNode;
import com.swmansion.reanimated.nodes.OperatorNode;
import com.swmansion.reanimated.nodes.ParamNode;
import com.swmansion.reanimated.nodes.PropsNode;
import com.swmansion.reanimated.nodes.SetNode;
import com.swmansion.reanimated.nodes.StyleNode;
import com.swmansion.reanimated.nodes.TransformNode;
import com.swmansion.reanimated.nodes.ValueNode;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class NodesManager implements EventDispatcherListener {
    private static final Double ZERO = Double.valueOf(Utils.DOUBLE_EPSILON);
    public double currentFrameTimeMs;
    private final SparseArray<Node> mAnimatedNodes = new SparseArray<>();
    private AnimationsManager mAnimationManager = null;
    private final AtomicBoolean mCallbackPosted = new AtomicBoolean();
    private final GuardedFrameCallback mChoreographerCallback;
    private final ReactContext mContext;
    private RCTEventEmitter mCustomEventHandler;
    protected final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter mEventEmitter;
    private final Map<String, EventNode> mEventMapping = new HashMap();
    private ConcurrentLinkedQueue<CopiedEvent> mEventQueue = new ConcurrentLinkedQueue<>();
    private List<OnAnimationFrame> mFrameCallbacks = new ArrayList();
    private NativeProxy mNativeProxy;
    private final NoopNode mNoopNode;
    private Queue<NativeUpdateOperation> mOperationsInBatch = new LinkedList();
    private final ReactChoreographer mReactChoreographer;
    private boolean mTryRunBatchUpdatesSynchronously = false;
    /* access modifiers changed from: private */
    public final UIImplementation mUIImplementation;
    /* access modifiers changed from: private */
    public final UIManagerModule mUIManager;
    private boolean mWantRunUpdates;
    public Set<String> nativeProps = Collections.emptySet();
    public Set<String> uiProps = Collections.emptySet();
    public final UpdateContext updateContext;

    public interface OnAnimationFrame {
        void onAnimationFrame(double d);
    }

    public void scrollTo(int i, double d, double d2, boolean z) {
        try {
            NativeMethodsHelper.scrollTo(this.mUIManager.resolveView(i), d, d2, z);
        } catch (IllegalViewOperationException e) {
            e.printStackTrace();
        }
    }

    public float[] measure(int i) {
        try {
            return NativeMethodsHelper.measure(this.mUIManager.resolveView(i));
        } catch (IllegalViewOperationException e) {
            e.printStackTrace();
            return new float[0];
        }
    }

    public NativeProxy getNativeProxy() {
        return this.mNativeProxy;
    }

    public AnimationsManager getAnimationsManager() {
        return this.mAnimationManager;
    }

    public void onCatalystInstanceDestroy() {
        AnimationsManager animationsManager = this.mAnimationManager;
        if (animationsManager != null) {
            animationsManager.onCatalystInstanceDestroy();
        }
        NativeProxy nativeProxy = this.mNativeProxy;
        if (nativeProxy != null) {
            nativeProxy.onCatalystInstanceDestroy();
            this.mNativeProxy = null;
        }
    }

    public void initWithContext(ReactApplicationContext reactApplicationContext) {
        this.mNativeProxy = new NativeProxy(reactApplicationContext);
        this.mAnimationManager.setScheduler(getNativeProxy().getScheduler());
    }

    private final class NativeUpdateOperation {
        public WritableMap mNativeProps;
        public int mViewTag;

        public NativeUpdateOperation(int i, WritableMap writableMap) {
            this.mViewTag = i;
            this.mNativeProps = writableMap;
        }
    }

    public NodesManager(ReactContext reactContext) {
        this.mContext = reactContext;
        UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.mUIManager = uIManagerModule;
        this.updateContext = new UpdateContext();
        UIImplementation uIImplementation = uIManagerModule.getUIImplementation();
        this.mUIImplementation = uIImplementation;
        this.mCustomEventNamesResolver = uIManagerModule.getDirectEventNamesResolver();
        this.mEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        this.mReactChoreographer = ReactChoreographer.getInstance();
        this.mChoreographerCallback = new GuardedFrameCallback(reactContext) {
            /* access modifiers changed from: protected */
            public void doFrameGuarded(long j) {
                NodesManager.this.onAnimationFrame(j);
            }
        };
        this.mNoopNode = new NoopNode(this);
        uIManagerModule.getEventDispatcher().addListener(this);
        this.mAnimationManager = new AnimationsManager(reactContext, uIImplementation, uIManagerModule);
    }

    public void onHostPause() {
        if (this.mCallbackPosted.get()) {
            stopUpdatingOnAnimationFrame();
            this.mCallbackPosted.set(true);
        }
    }

    public void onHostResume() {
        if (this.mCallbackPosted.getAndSet(false)) {
            startUpdatingOnAnimationFrame();
        }
    }

    public void startUpdatingOnAnimationFrame() {
        if (!this.mCallbackPosted.getAndSet(true)) {
            this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    private void stopUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(false)) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|6|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x002f A[LOOP:0: B:4:0x002f->B:5:?, LOOP_START, SYNTHETIC, Splitter:B:4:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void performOperations() {
        /*
            r10 = this;
            java.util.Queue<com.swmansion.reanimated.NodesManager$NativeUpdateOperation> r0 = r10.mOperationsInBatch
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0032
            java.util.Queue<com.swmansion.reanimated.NodesManager$NativeUpdateOperation> r6 = r10.mOperationsInBatch
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r10.mOperationsInBatch = r0
            boolean r0 = r10.mTryRunBatchUpdatesSynchronously
            r1 = 0
            r10.mTryRunBatchUpdatesSynchronously = r1
            java.util.concurrent.Semaphore r7 = new java.util.concurrent.Semaphore
            r7.<init>(r1)
            com.facebook.react.bridge.ReactContext r8 = r10.mContext
            com.swmansion.reanimated.NodesManager$2 r9 = new com.swmansion.reanimated.NodesManager$2
            com.facebook.react.bridge.NativeModuleCallExceptionHandler r3 = r8.getExceptionHandler()
            r1 = r9
            r2 = r10
            r4 = r0
            r5 = r7
            r1.<init>(r3, r4, r5, r6)
            r8.runOnNativeModulesQueueThread(r9)
            if (r0 == 0) goto L_0x0032
        L_0x002f:
            r7.acquire()     // Catch:{ InterruptedException -> 0x002f }
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.NodesManager.performOperations():void");
    }

    /* access modifiers changed from: private */
    public void onAnimationFrame(long j) {
        this.currentFrameTimeMs = ((double) j) / 1000000.0d;
        while (!this.mEventQueue.isEmpty()) {
            CopiedEvent poll = this.mEventQueue.poll();
            handleEvent(poll.getTargetTag(), poll.getEventName(), poll.getPayload());
        }
        if (!this.mFrameCallbacks.isEmpty()) {
            List<OnAnimationFrame> list = this.mFrameCallbacks;
            this.mFrameCallbacks = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).onAnimationFrame(this.currentFrameTimeMs);
            }
        }
        if (this.mWantRunUpdates) {
            Node.runUpdates(this.updateContext);
        }
        performOperations();
        this.mCallbackPosted.set(false);
        this.mWantRunUpdates = false;
        if (!this.mFrameCallbacks.isEmpty() || !this.mEventQueue.isEmpty()) {
            startUpdatingOnAnimationFrame();
        }
    }

    public Object getNodeValue(int i) {
        Node node = this.mAnimatedNodes.get(i);
        if (node != null) {
            return node.value();
        }
        return ZERO;
    }

    public <T extends Node> T findNodeById(int i, Class<T> cls) {
        T t = (Node) this.mAnimatedNodes.get(i);
        if (t == null) {
            if (cls == Node.class || cls == ValueNode.class) {
                return this.mNoopNode;
            }
            throw new IllegalArgumentException("Requested node with id " + i + " of type " + cls + " cannot be found");
        } else if (cls.isInstance(t)) {
            return t;
        } else {
            throw new IllegalArgumentException("Node with id " + i + " is of incompatible type " + t.getClass() + ", requested type was " + cls);
        }
    }

    public void createNode(int i, ReadableMap readableMap) {
        Object obj;
        if (this.mAnimatedNodes.get(i) == null) {
            String string = readableMap.getString(NotificationsService.EVENT_TYPE_KEY);
            if ("props".equals(string)) {
                obj = new PropsNode(i, readableMap, this, this.mUIImplementation);
            } else if ("style".equals(string)) {
                obj = new StyleNode(i, readableMap, this);
            } else if (ViewProps.TRANSFORM.equals(string)) {
                obj = new TransformNode(i, readableMap, this);
            } else if (RNConstants.ARG_VALUE.equals(string)) {
                obj = new ValueNode(i, readableMap, this);
            } else if ("block".equals(string)) {
                obj = new BlockNode(i, readableMap, this);
            } else if ("cond".equals(string)) {
                obj = new CondNode(i, readableMap, this);
            } else if ("op".equals(string)) {
                obj = new OperatorNode(i, readableMap, this);
            } else if ("set".equals(string)) {
                obj = new SetNode(i, readableMap, this);
            } else if (BuildConfig.BUILD_TYPE.equals(string)) {
                obj = new DebugNode(i, readableMap, this);
            } else if ("clock".equals(string)) {
                obj = new ClockNode(i, readableMap, this);
            } else if ("clockStart".equals(string)) {
                obj = new ClockOpNode.ClockStartNode(i, readableMap, this);
            } else if ("clockStop".equals(string)) {
                obj = new ClockOpNode.ClockStopNode(i, readableMap, this);
            } else if ("clockTest".equals(string)) {
                obj = new ClockOpNode.ClockTestNode(i, readableMap, this);
            } else if (NotificationCompat.CATEGORY_CALL.equals(string)) {
                obj = new JSCallNode(i, readableMap, this);
            } else if ("bezier".equals(string)) {
                obj = new BezierNode(i, readableMap, this);
            } else if ("event".equals(string)) {
                obj = new EventNode(i, readableMap, this);
            } else if ("always".equals(string)) {
                obj = new AlwaysNode(i, readableMap, this);
            } else if ("concat".equals(string)) {
                obj = new ConcatNode(i, readableMap, this);
            } else if ("param".equals(string)) {
                obj = new ParamNode(i, readableMap, this);
            } else if ("func".equals(string)) {
                obj = new FunctionNode(i, readableMap, this);
            } else if ("callfunc".equals(string)) {
                obj = new CallFuncNode(i, readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            this.mAnimatedNodes.put(i, obj);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " already exists");
    }

    public void dropNode(int i) {
        Node node = this.mAnimatedNodes.get(i);
        if (node != null) {
            node.onDrop();
        }
        this.mAnimatedNodes.remove(i);
    }

    public void connectNodes(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        Node node2 = this.mAnimatedNodes.get(i2);
        if (node2 != null) {
            node.addChild(node2);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
    }

    public void disconnectNodes(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        Node node2 = this.mAnimatedNodes.get(i2);
        if (node2 != null) {
            node.removeChild(node2);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
    }

    public void connectNodeToView(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        if (node == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
        } else if (node instanceof PropsNode) {
            ((PropsNode) node).connectToView(i2);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsNode.class.getName());
        }
    }

    public void disconnectNodeFromView(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        if (node == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
        } else if (node instanceof PropsNode) {
            ((PropsNode) node).disconnectFromView(i2);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsNode.class.getName());
        }
    }

    public void enqueueUpdateViewOnNativeThread(int i, WritableMap writableMap, boolean z) {
        if (z) {
            this.mTryRunBatchUpdatesSynchronously = true;
        }
        this.mOperationsInBatch.add(new NativeUpdateOperation(i, writableMap));
    }

    public void attachEvent(int i, String str, int i2) {
        String str2 = i + str;
        EventNode eventNode = (EventNode) this.mAnimatedNodes.get(i2);
        if (eventNode == null) {
            throw new JSApplicationIllegalArgumentException("Event node " + i2 + " does not exists");
        } else if (!this.mEventMapping.containsKey(str2)) {
            this.mEventMapping.put(str2, eventNode);
        } else {
            throw new JSApplicationIllegalArgumentException("Event handler already set for the given view and event type");
        }
    }

    public void detachEvent(int i, String str, int i2) {
        this.mEventMapping.remove(i + str);
    }

    public void configureProps(Set<String> set, Set<String> set2) {
        this.nativeProps = set;
        this.uiProps = set2;
    }

    public void getValue(int i, Callback callback) {
        callback.invoke(this.mAnimatedNodes.get(i).value());
    }

    public void postRunUpdatesAfterAnimation() {
        this.mWantRunUpdates = true;
        startUpdatingOnAnimationFrame();
    }

    public void postOnAnimation(OnAnimationFrame onAnimationFrame) {
        this.mFrameCallbacks.add(onAnimationFrame);
        startUpdatingOnAnimationFrame();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
        r1 = r3.mNativeProxy;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventDispatch(com.facebook.react.uimanager.events.Event r4) {
        /*
            r3 = this;
            boolean r0 = com.facebook.react.bridge.UiThreadUtil.isOnUiThread()
            if (r0 == 0) goto L_0x000d
            r3.handleEvent(r4)
            r3.performOperations()
            goto L_0x004c
        L_0x000d:
            com.facebook.react.uimanager.UIManagerModule$CustomEventNamesResolver r0 = r3.mCustomEventNamesResolver
            java.lang.String r1 = r4.getEventName()
            java.lang.String r0 = r0.resolveCustomEventName(r1)
            int r1 = r4.getViewTag()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.facebook.react.uimanager.events.RCTEventEmitter r1 = r3.mCustomEventHandler
            r2 = 0
            if (r1 == 0) goto L_0x003b
            com.swmansion.reanimated.NativeProxy r1 = r3.mNativeProxy
            if (r1 == 0) goto L_0x003b
            boolean r0 = r1.isAnyHandlerWaitingForEvent(r0)
            if (r0 == 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            r0 = r0 | r2
            if (r0 == 0) goto L_0x0049
            java.util.concurrent.ConcurrentLinkedQueue<com.swmansion.reanimated.CopiedEvent> r0 = r3.mEventQueue
            com.swmansion.reanimated.CopiedEvent r1 = new com.swmansion.reanimated.CopiedEvent
            r1.<init>(r4)
            r0.offer(r1)
        L_0x0049:
            r3.startUpdatingOnAnimationFrame()
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.NodesManager.onEventDispatch(com.facebook.react.uimanager.events.Event):void");
    }

    private void handleEvent(Event event) {
        EventNode eventNode;
        String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.getEventName());
        String str = event.getViewTag() + resolveCustomEventName;
        RCTEventEmitter rCTEventEmitter = this.mCustomEventHandler;
        if (rCTEventEmitter != null) {
            event.dispatch(rCTEventEmitter);
        }
        if (!this.mEventMapping.isEmpty() && (eventNode = this.mEventMapping.get(str)) != null) {
            event.dispatch(eventNode);
        }
    }

    private void handleEvent(int i, String str, @Nullable WritableMap writableMap) {
        EventNode eventNode;
        RCTEventEmitter rCTEventEmitter = this.mCustomEventHandler;
        if (rCTEventEmitter != null) {
            rCTEventEmitter.receiveEvent(i, str, writableMap);
        }
        String str2 = i + str;
        if (!this.mEventMapping.isEmpty() && (eventNode = this.mEventMapping.get(str2)) != null) {
            eventNode.receiveEvent(i, str, writableMap);
        }
    }

    public UIManagerModule.CustomEventNamesResolver getEventNameResolver() {
        return this.mCustomEventNamesResolver;
    }

    public void registerEventHandler(RCTEventEmitter rCTEventEmitter) {
        this.mCustomEventHandler = rCTEventEmitter;
    }

    public void sendEvent(String str, WritableMap writableMap) {
        this.mEventEmitter.emit(str, writableMap);
    }

    public void setValue(int i, Double d) {
        Node node = this.mAnimatedNodes.get(i);
        if (node != null) {
            ((ValueNode) node).setValue(d);
        }
    }

    public void updateProps(int i, Map<String, Object> map) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (this.uiProps.contains(str)) {
                addProp(javaOnlyMap, str, value);
                z = true;
            } else if (this.nativeProps.contains(str)) {
                addProp(createMap2, str, value);
                z2 = true;
            } else {
                addProp(createMap, str, value);
                z3 = true;
            }
        }
        if (i != -1) {
            if (z) {
                this.mUIImplementation.synchronouslyUpdateViewOnUIThread(i, new ReactStylesDiffMap(javaOnlyMap));
            }
            if (z2) {
                enqueueUpdateViewOnNativeThread(i, createMap2, true);
            }
            if (z3) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putInt("viewTag", i);
                createMap3.putMap("props", createMap);
                sendEvent("onReanimatedPropsChange", createMap3);
            }
        }
    }

    public String obtainProp(int i, String str) {
        View resolveView = this.mUIManager.resolveView(i);
        String str2 = "error: unknown propName " + str + ", currently supported: opacity, zIndex";
        if (str.equals(ViewProps.OPACITY)) {
            return Float.toString(Float.valueOf(resolveView.getAlpha()).floatValue());
        }
        return str.equals(ViewProps.Z_INDEX) ? Float.toString(Float.valueOf(resolveView.getElevation()).floatValue()) : str2;
    }

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof ReadableArray) {
            writableMap.putArray(str, (ReadableArray) obj);
        } else if (obj instanceof ReadableMap) {
            writableMap.putMap(str, (ReadableMap) obj);
        } else {
            throw new IllegalStateException("Unknown type of animated value");
        }
    }
}
