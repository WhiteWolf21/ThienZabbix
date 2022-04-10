package com.facebook.react.fabric;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSIModuleProvider;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.CreateMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchIntCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchStringCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveDeleteMultiMountItem;
import com.facebook.react.fabric.mounting.mountitems.SendAccessibilityEvent;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePaddingMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateStateMountItem;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.BatchEventDispatchedListener;
import com.facebook.systrace.Systrace;

public class FabricJSIModuleProvider implements JSIModuleProvider<UIManager> {
    private final ComponentFactory mComponentFactory;
    private final ReactNativeConfig mConfig;
    private final ReactApplicationContext mReactApplicationContext;

    public FabricJSIModuleProvider(ReactApplicationContext reactApplicationContext, ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mComponentFactory = componentFactory;
        this.mConfig = reactNativeConfig;
    }

    public UIManager get() {
        EventBeatManager eventBeatManager = new EventBeatManager(this.mReactApplicationContext);
        FabricUIManager createUIManager = createUIManager(eventBeatManager);
        Systrace.beginSection(0, "FabricJSIModuleProvider.registerBinding");
        Binding binding = new Binding();
        loadClasses();
        FabricUIManager fabricUIManager = createUIManager;
        binding.register(this.mReactApplicationContext.getCatalystInstance().getRuntimeExecutor(), fabricUIManager, eventBeatManager, this.mReactApplicationContext.getCatalystInstance().getReactQueueConfiguration().getJSQueueThread(), this.mComponentFactory, this.mConfig);
        Systrace.endSection(0);
        return createUIManager;
    }

    private FabricUIManager createUIManager(EventBeatManager eventBeatManager) {
        Systrace.beginSection(0, "FabricJSIModuleProvider.createUIManager");
        UIManagerModule uIManagerModule = (UIManagerModule) Assertions.assertNotNull(this.mReactApplicationContext.getNativeModule(UIManagerModule.class));
        FabricUIManager fabricUIManager = new FabricUIManager(this.mReactApplicationContext, uIManagerModule.getViewManagerRegistry_DO_NOT_USE(), uIManagerModule.getEventDispatcher(), eventBeatManager);
        Systrace.endSection(0);
        return fabricUIManager;
    }

    private static void loadClasses() {
        Class<EventBeatManager> cls = EventBeatManager.class;
        Class<EventEmitterWrapper> cls2 = EventEmitterWrapper.class;
        Class<FabricEventEmitter> cls3 = FabricEventEmitter.class;
        Class<BatchMountItem> cls4 = BatchMountItem.class;
        Class<CreateMountItem> cls5 = CreateMountItem.class;
        Class<DispatchCommandMountItem> cls6 = DispatchCommandMountItem.class;
        Class<DispatchIntCommandMountItem> cls7 = DispatchIntCommandMountItem.class;
        Class<DispatchStringCommandMountItem> cls8 = DispatchStringCommandMountItem.class;
        Class<InsertMountItem> cls9 = InsertMountItem.class;
        Class<MountItem> cls10 = MountItem.class;
        Class<PreAllocateViewMountItem> cls11 = PreAllocateViewMountItem.class;
        Class<RemoveDeleteMultiMountItem> cls12 = RemoveDeleteMultiMountItem.class;
        Class<SendAccessibilityEvent> cls13 = SendAccessibilityEvent.class;
        Class<UpdateEventEmitterMountItem> cls14 = UpdateEventEmitterMountItem.class;
        Class<UpdateLayoutMountItem> cls15 = UpdateLayoutMountItem.class;
        Class<UpdatePaddingMountItem> cls16 = UpdatePaddingMountItem.class;
        Class<UpdatePropsMountItem> cls17 = UpdatePropsMountItem.class;
        Class<UpdateStateMountItem> cls18 = UpdateStateMountItem.class;
        Class<LayoutMetricsConversions> cls19 = LayoutMetricsConversions.class;
        Class<MountingManager> cls20 = MountingManager.class;
        Class<Binding> cls21 = Binding.class;
        Class<ComponentFactory> cls22 = ComponentFactory.class;
        Class<FabricComponents> cls23 = FabricComponents.class;
        Class<FabricSoLoader> cls24 = FabricSoLoader.class;
        Class<FabricUIManager> cls25 = FabricUIManager.class;
        Class<GuardedFrameCallback> cls26 = GuardedFrameCallback.class;
        Class<StateWrapper> cls27 = StateWrapper.class;
        Class<StateWrapperImpl> cls28 = StateWrapperImpl.class;
        Class<BatchEventDispatchedListener> cls29 = BatchEventDispatchedListener.class;
        Class<ReactNativeConfig> cls30 = ReactNativeConfig.class;
    }
}
