package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.reactcommunity.rndatetimepicker.RNConstants;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

class NativeAnimatedNodesManager implements EventDispatcherListener {
    private static final String TAG = "NativeAnimatedNodesManager";
    private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    private int mAnimatedGraphBFSColor = 0;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    private final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
    /* access modifiers changed from: private */
    public boolean mEventListenerInitializedForFabric = false;
    /* access modifiers changed from: private */
    public boolean mEventListenerInitializedForNonFabric = false;
    /* access modifiers changed from: private */
    public final ReactApplicationContext mReactApplicationContext;
    private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();
    private boolean mWarnedAboutGraphTraversal = false;

    public NativeAnimatedNodesManager(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    public void initializeEventListenerForUIManagerType(final int i) {
        if (i == 2 && this.mEventListenerInitializedForFabric) {
            return;
        }
        if (i != 1 || !this.mEventListenerInitializedForNonFabric) {
            this.mReactApplicationContext.runOnUiQueueThread(new Runnable() {
                public void run() {
                    UIManager uIManager = UIManagerHelper.getUIManager(NativeAnimatedNodesManager.this.mReactApplicationContext, i);
                    if (uIManager != null) {
                        ((EventDispatcher) uIManager.getEventDispatcher()).addListener(this);
                        if (i == 2) {
                            boolean unused = NativeAnimatedNodesManager.this.mEventListenerInitializedForFabric = true;
                        } else {
                            boolean unused2 = NativeAnimatedNodesManager.this.mEventListenerInitializedForNonFabric = true;
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public AnimatedNode getNodeById(int i) {
        return this.mAnimatedNodes.get(i);
    }

    public boolean hasActiveAnimations() {
        return this.mActiveAnimations.size() > 0 || this.mUpdatedNodes.size() > 0;
    }

    public void createAnimatedNode(int i, ReadableMap readableMap) {
        AnimatedNode animatedNode;
        if (this.mAnimatedNodes.get(i) == null) {
            String string = readableMap.getString(NotificationsService.EVENT_TYPE_KEY);
            if ("style".equals(string)) {
                animatedNode = new StyleAnimatedNode(readableMap, this);
            } else if (RNConstants.ARG_VALUE.equals(string)) {
                animatedNode = new ValueAnimatedNode(readableMap);
            } else if ("props".equals(string)) {
                animatedNode = new PropsAnimatedNode(readableMap, this);
            } else if ("interpolation".equals(string)) {
                animatedNode = new InterpolationAnimatedNode(readableMap);
            } else if ("addition".equals(string)) {
                animatedNode = new AdditionAnimatedNode(readableMap, this);
            } else if ("subtraction".equals(string)) {
                animatedNode = new SubtractionAnimatedNode(readableMap, this);
            } else if ("division".equals(string)) {
                animatedNode = new DivisionAnimatedNode(readableMap, this);
            } else if ("multiplication".equals(string)) {
                animatedNode = new MultiplicationAnimatedNode(readableMap, this);
            } else if ("modulus".equals(string)) {
                animatedNode = new ModulusAnimatedNode(readableMap, this);
            } else if ("diffclamp".equals(string)) {
                animatedNode = new DiffClampAnimatedNode(readableMap, this);
            } else if (ViewProps.TRANSFORM.equals(string)) {
                animatedNode = new TransformAnimatedNode(readableMap, this);
            } else if ("tracking".equals(string)) {
                animatedNode = new TrackingAnimatedNode(readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            animatedNode.mTag = i;
            this.mAnimatedNodes.put(i, animatedNode);
            this.mUpdatedNodes.put(i, animatedNode);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " already exists");
    }

    public void dropAnimatedNode(int i) {
        this.mAnimatedNodes.remove(i);
        this.mUpdatedNodes.remove(i);
    }

    public void startListeningToAnimatedNodeValue(int i, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
    }

    public void stopListeningToAnimatedNodeValue(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener((AnimatedNodeValueListener) null);
    }

    public void setAnimatedNodeValue(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        stopAnimationsForNode(animatedNode);
        ((ValueAnimatedNode) animatedNode).mValue = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void setAnimatedNodeOffset(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).mOffset = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void flattenAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).flattenOffset();
    }

    public void extractAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).extractOffset();
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimationDriver animationDriver;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exist");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            AnimationDriver animationDriver2 = this.mActiveAnimations.get(i);
            if (animationDriver2 != null) {
                animationDriver2.resetConfig(readableMap);
                return;
            }
            String string = readableMap.getString(NotificationsService.EVENT_TYPE_KEY);
            if ("frames".equals(string)) {
                animationDriver = new FrameBasedAnimationDriver(readableMap);
            } else if ("spring".equals(string)) {
                animationDriver = new SpringAnimation(readableMap);
            } else if ("decay".equals(string)) {
                animationDriver = new DecayAnimation(readableMap);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported animation type: " + string);
            }
            animationDriver.mId = i;
            animationDriver.mEndCallback = callback;
            animationDriver.mAnimatedValue = (ValueAnimatedNode) animatedNode;
            this.mActiveAnimations.put(i, animationDriver);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node should be of type " + ValueAnimatedNode.class.getName());
        }
    }

    private void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(valueAt.mAnimatedValue)) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
    }

    public void stopAnimation(int i) {
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            if (valueAt.mId == i) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i2);
                return;
            }
        }
    }

    public void connectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.addChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
    }

    public void disconnectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.removeChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
    }

    public void connectAnimatedNodeToView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
        } else if (animatedNode instanceof PropsAnimatedNode) {
            ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
            if (reactApplicationContext != null) {
                UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i2);
                if (uIManagerForReactTag == null) {
                    ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException("Animated node could not be connected to UIManager - uiManager disappeared for tag: " + i2));
                    return;
                }
                ((PropsAnimatedNode) animatedNode).connectToView(i2, uIManagerForReactTag);
                this.mUpdatedNodes.put(i, animatedNode);
                return;
            }
            throw new IllegalStateException("Animated node could not be connected, no ReactApplicationContext: " + i2);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        }
    }

    public void disconnectAnimatedNodeFromView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
        } else if (animatedNode instanceof PropsAnimatedNode) {
            ((PropsAnimatedNode) animatedNode).disconnectFromView(i2);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        }
    }

    public void getValue(int i, Callback callback) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists or is not a 'value' node");
        }
        callback.invoke(Double.valueOf(((ValueAnimatedNode) animatedNode).getValue()));
    }

    public void restoreDefaultValues(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            if (animatedNode instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        }
    }

    public void addAnimatedEventToView(int i, String str, ReadableMap readableMap) {
        int i2 = readableMap.getInt("animatedValueTag");
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            ReadableArray array = readableMap.getArray("nativeEventPath");
            ArrayList arrayList = new ArrayList(array.size());
            for (int i3 = 0; i3 < array.size(); i3++) {
                arrayList.add(array.getString(i3));
            }
            EventAnimationDriver eventAnimationDriver = new EventAnimationDriver(arrayList, (ValueAnimatedNode) animatedNode);
            String str2 = i + str;
            if (this.mEventDrivers.containsKey(str2)) {
                this.mEventDrivers.get(str2).add(eventAnimationDriver);
                return;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(eventAnimationDriver);
            this.mEventDrivers.put(str2, arrayList2);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node connected to event should beof type " + ValueAnimatedNode.class.getName());
        }
    }

    public void removeAnimatedEventFromView(int i, String str, int i2) {
        String str2 = i + str;
        if (this.mEventDrivers.containsKey(str2)) {
            List list = this.mEventDrivers.get(str2);
            if (list.size() == 1) {
                this.mEventDrivers.remove(i + str);
                return;
            }
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (((EventAnimationDriver) listIterator.next()).mValueNode.mTag == i2) {
                    listIterator.remove();
                    return;
                }
            }
        }
    }

    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleEvent(Event event) {
        ReactApplicationContext reactApplicationContext;
        UIManager uIManagerForReactTag;
        if (!this.mEventDrivers.isEmpty() && (reactApplicationContext = this.mReactApplicationContext) != null && (uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, event.getViewTag())) != null) {
            String resolveCustomDirectEventName = uIManagerForReactTag.resolveCustomDirectEventName(event.getEventName());
            if (resolveCustomDirectEventName == null) {
                resolveCustomDirectEventName = "";
            }
            Map<String, List<EventAnimationDriver>> map = this.mEventDrivers;
            List<EventAnimationDriver> list = map.get(event.getViewTag() + resolveCustomDirectEventName);
            if (list != null) {
                for (EventAnimationDriver eventAnimationDriver : list) {
                    stopAnimationsForNode(eventAnimationDriver.mValueNode);
                    event.dispatch(eventAnimationDriver);
                    this.mRunUpdateNodeList.add(eventAnimationDriver.mValueNode);
                }
                updateNodes(this.mRunUpdateNodeList);
                this.mRunUpdateNodeList.clear();
            }
        }
    }

    public void runUpdates(long j) {
        UiThreadUtil.assertOnUiThread();
        for (int i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        boolean z = false;
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            valueAt.runAnimationStep(j);
            this.mRunUpdateNodeList.add(valueAt.mAnimatedValue);
            if (valueAt.mHasFinished) {
                z = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z) {
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver valueAt2 = this.mActiveAnimations.valueAt(size);
                if (valueAt2.mHasFinished) {
                    if (valueAt2.mEndCallback != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.mEndCallback.invoke(createMap);
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
        }
    }

    private void updateNodes(List<AnimatedNode> list) {
        String str;
        int i;
        int i2 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i2;
        if (i2 == 0) {
            this.mAnimatedGraphBFSColor = i2 + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = 0;
        for (AnimatedNode next : list) {
            int i4 = next.mBFSColor;
            int i5 = this.mAnimatedGraphBFSColor;
            if (i4 != i5) {
                next.mBFSColor = i5;
                i3++;
                arrayDeque.add(next);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode = (AnimatedNode) arrayDeque.poll();
            if (animatedNode.mChildren != null) {
                for (int i6 = 0; i6 < animatedNode.mChildren.size(); i6++) {
                    AnimatedNode animatedNode2 = animatedNode.mChildren.get(i6);
                    animatedNode2.mActiveIncomingNodes++;
                    int i7 = animatedNode2.mBFSColor;
                    int i8 = this.mAnimatedGraphBFSColor;
                    if (i7 != i8) {
                        animatedNode2.mBFSColor = i8;
                        i3++;
                        arrayDeque.add(animatedNode2);
                    }
                }
            }
        }
        int i9 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i9;
        if (i9 == 0) {
            this.mAnimatedGraphBFSColor = i9 + 1;
        }
        int i10 = 0;
        for (AnimatedNode next2 : list) {
            if (next2.mActiveIncomingNodes == 0 && next2.mBFSColor != (i = this.mAnimatedGraphBFSColor)) {
                next2.mBFSColor = i;
                i10++;
                arrayDeque.add(next2);
            }
        }
        int i11 = 0;
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode3 = (AnimatedNode) arrayDeque.poll();
            try {
                animatedNode3.update();
                if (animatedNode3 instanceof PropsAnimatedNode) {
                    ((PropsAnimatedNode) animatedNode3).updateView();
                }
            } catch (JSApplicationCausedNativeException e) {
                FLog.m49e(TAG, "Native animation workaround, frame lost as result of race condition", (Throwable) e);
            }
            if (animatedNode3 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode3).onValueUpdate();
            }
            if (animatedNode3.mChildren != null) {
                for (int i12 = 0; i12 < animatedNode3.mChildren.size(); i12++) {
                    AnimatedNode animatedNode4 = animatedNode3.mChildren.get(i12);
                    animatedNode4.mActiveIncomingNodes--;
                    if (animatedNode4.mBFSColor != this.mAnimatedGraphBFSColor && animatedNode4.mActiveIncomingNodes == 0) {
                        animatedNode4.mBFSColor = this.mAnimatedGraphBFSColor;
                        i10++;
                        arrayDeque.add(animatedNode4);
                    } else if (animatedNode4.mBFSColor == this.mAnimatedGraphBFSColor) {
                        i11++;
                    }
                }
            }
        }
        if (i3 == i10) {
            this.mWarnedAboutGraphTraversal = false;
        } else if (!this.mWarnedAboutGraphTraversal) {
            this.mWarnedAboutGraphTraversal = true;
            FLog.m48e(TAG, "Detected animation cycle or disconnected graph. ");
            for (AnimatedNode prettyPrintWithChildren : list) {
                FLog.m48e(TAG, prettyPrintWithChildren.prettyPrintWithChildren());
            }
            if (i11 > 0) {
                str = "cycles (" + i11 + ")";
            } else {
                str = "disconnected regions";
            }
            IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + str + ", there are " + i3 + " but toposort visited only " + i10);
            boolean z = this.mEventListenerInitializedForFabric;
            if (z && i11 == 0) {
                ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else if (z) {
                ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else {
                throw illegalStateException;
            }
        }
    }
}
