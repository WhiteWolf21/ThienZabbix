package com.swmansion.reanimated;

import android.os.SystemClock;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.layoutReanimation.AnimationsManager;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class NativeProxy {
    private final GestureHandlerStateManager gestureHandlerStateManager;
    private final WeakReference<ReactApplicationContext> mContext;
    private final HybridData mHybridData;
    private NodesManager mNodesManager;
    private Scheduler mScheduler = null;

    private native HybridData initHybrid(long j, CallInvokerHolderImpl callInvokerHolderImpl, Scheduler scheduler, LayoutAnimations layoutAnimations);

    private native void installJSIBindings();

    public native boolean isAnyHandlerWaitingForEvent(String str);

    static {
        System.loadLibrary("reanimated");
    }

    public static class AnimationFrameCallback implements NodesManager.OnAnimationFrame {
        private final HybridData mHybridData;

        public native void onAnimationFrame(double d);

        private AnimationFrameCallback(HybridData hybridData) {
            this.mHybridData = hybridData;
        }
    }

    public static class EventHandler implements RCTEventEmitter {
        /* access modifiers changed from: private */
        public UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
        private final HybridData mHybridData;

        public native void receiveEvent(String str, WritableMap writableMap);

        public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        }

        private EventHandler(HybridData hybridData) {
            this.mHybridData = hybridData;
        }

        public void receiveEvent(int i, String str, WritableMap writableMap) {
            String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(str);
            receiveEvent(i + resolveCustomEventName, writableMap);
        }
    }

    public NativeProxy(ReactApplicationContext reactApplicationContext) {
        GestureHandlerStateManager gestureHandlerStateManager2 = null;
        LayoutAnimations layoutAnimations = new LayoutAnimations(reactApplicationContext);
        this.mScheduler = new Scheduler(reactApplicationContext);
        this.mHybridData = initHybrid(reactApplicationContext.getJavaScriptContextHolder().get(), (CallInvokerHolderImpl) reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder(), this.mScheduler, layoutAnimations);
        this.mContext = new WeakReference<>(reactApplicationContext);
        prepare(layoutAnimations);
        try {
            gestureHandlerStateManager2 = (GestureHandlerStateManager) reactApplicationContext.getNativeModule(Class.forName("com.swmansion.gesturehandler.react.RNGestureHandlerModule"));
        } catch (ClassCastException | ClassNotFoundException unused) {
        }
        this.gestureHandlerStateManager = gestureHandlerStateManager2;
    }

    public Scheduler getScheduler() {
        return this.mScheduler;
    }

    private void requestRender(AnimationFrameCallback animationFrameCallback) {
        this.mNodesManager.postOnAnimation(animationFrameCallback);
    }

    private void updateProps(int i, Map<String, Object> map) {
        this.mNodesManager.updateProps(i, map);
    }

    private String obtainProp(int i, String str) {
        return this.mNodesManager.obtainProp(i, str);
    }

    private void scrollTo(int i, double d, double d2, boolean z) {
        this.mNodesManager.scrollTo(i, d, d2, z);
    }

    private void setGestureState(int i, int i2) {
        GestureHandlerStateManager gestureHandlerStateManager2 = this.gestureHandlerStateManager;
        if (gestureHandlerStateManager2 != null) {
            gestureHandlerStateManager2.setGestureHandlerState(i, i2);
        }
    }

    private String getUpTime() {
        return Long.toString(SystemClock.uptimeMillis());
    }

    private float[] measure(int i) {
        return this.mNodesManager.measure(i);
    }

    private void registerEventHandler(EventHandler eventHandler) {
        UIManagerModule.CustomEventNamesResolver unused = eventHandler.mCustomEventNamesResolver = this.mNodesManager.getEventNameResolver();
        this.mNodesManager.registerEventHandler(eventHandler);
    }

    public void onCatalystInstanceDestroy() {
        this.mScheduler.deactivate();
        this.mHybridData.resetNative();
    }

    public void prepare(final LayoutAnimations layoutAnimations) {
        this.mNodesManager = ((ReanimatedModule) ((ReactApplicationContext) this.mContext.get()).getNativeModule(ReanimatedModule.class)).getNodesManager();
        installJSIBindings();
        AnimationsManager animationsManager = ((ReanimatedModule) ((ReactApplicationContext) this.mContext.get()).getNativeModule(ReanimatedModule.class)).getNodesManager().getAnimationsManager();
        final WeakReference weakReference = new WeakReference(layoutAnimations);
        animationsManager.setNativeMethods(new NativeMethodsHolder() {
            public void startAnimationForTag(int i, String str, HashMap<String, Float> hashMap) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    HashMap hashMap2 = new HashMap();
                    for (String next : hashMap.keySet()) {
                        hashMap2.put(next, hashMap.get(next).toString());
                    }
                    layoutAnimations.startAnimationForTag(i, str, hashMap2);
                }
            }

            public void removeConfigForTag(int i) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.removeConfigForTag(i);
                }
            }

            public boolean isLayoutAnimationEnabled() {
                return layoutAnimations.isLayoutAnimationEnabled();
            }
        });
    }
}
