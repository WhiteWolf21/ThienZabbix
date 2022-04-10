package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.services.EventEmitter;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.camera.CameraViewInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.constants.ConstantsInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.font.FontManagerInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.imageloader.ImageLoaderInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.permissions.Permissions;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.sensors.SensorServiceInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.KEventEmitterWrapper;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.modules.Module;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AJ\u0018\u0010B\u001a\u0004\u0018\u0001HC\"\u0006\b\u0000\u0010C\u0018\u0001H\b¢\u0006\u0002\u0010DJ(\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020J2\b\u0010L\u001a\u0004\u0018\u00010MJ\u0006\u0010N\u001a\u00020FJ\u0006\u0010O\u001a\u00020FJ\u0006\u0010P\u001a\u00020FJ\u0006\u0010Q\u001a\u00020FJ\u0010\u0010R\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010MR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u0001078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u00010;8F¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006T"}, mo24974d2 = {"Lexpo/modules/kotlin/AppContext;", "", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "getActivityProvider", "()Lexpo/modules/core/interfaces/ActivityProvider;", "barcodeScanner", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "getBarcodeScanner", "()Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "camera", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "getCamera", "()Lexpo/modules/interfaces/camera/CameraViewInterface;", "constants", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "getConstants", "()Lexpo/modules/interfaces/constants/ConstantsInterface;", "filePermission", "Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "getFilePermission", "()Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "font", "Lexpo/modules/interfaces/font/FontManagerInterface;", "getFont", "()Lexpo/modules/interfaces/font/FontManagerInterface;", "imageLoader", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "getImageLoader", "()Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "getLegacyModuleRegistry", "()Lexpo/modules/core/ModuleRegistry;", "permissions", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissions", "()Lexpo/modules/interfaces/permissions/Permissions;", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "reactLifecycleDelegate", "Lexpo/modules/kotlin/ReactLifecycleDelegate;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "sensor", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "getSensor", "()Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "taskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "eventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "module", "Lexpo/modules/kotlin/modules/Module;", "legacyModule", "Module", "()Ljava/lang/Object;", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onHostDestroy", "onHostPause", "onHostResume", "onNewIntent", "intent", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: AppContext.kt */
public final class AppContext {
    private final ModuleRegistry legacyModuleRegistry;
    private final WeakReference<ReactApplicationContext> reactContextHolder;
    private final ReactLifecycleDelegate reactLifecycleDelegate;
    private final ModuleRegistry registry;

    public AppContext(ModulesProvider modulesProvider, ModuleRegistry moduleRegistry, WeakReference<ReactApplicationContext> weakReference) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(moduleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(weakReference, "reactContextHolder");
        this.legacyModuleRegistry = moduleRegistry;
        this.reactContextHolder = weakReference;
        this.registry = new ModuleRegistry(new WeakReference(this)).register(modulesProvider);
        ReactLifecycleDelegate reactLifecycleDelegate2 = new ReactLifecycleDelegate(this);
        this.reactLifecycleDelegate = reactLifecycleDelegate2;
        Object obj = weakReference.get();
        if (obj != null) {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) obj;
            reactApplicationContext.addLifecycleEventListener(reactLifecycleDelegate2);
            reactApplicationContext.addActivityEventListener(reactLifecycleDelegate2);
            return;
        }
        throw new IllegalArgumentException("The app context should be created with valid react context.".toString());
    }

    public final ModuleRegistry getLegacyModuleRegistry() {
        return this.legacyModuleRegistry;
    }

    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    public final /* synthetic */ <Module> Module legacyModule() {
        try {
            ModuleRegistry legacyModuleRegistry2 = getLegacyModuleRegistry();
            Intrinsics.reifiedOperationMarker(4, "Module");
            return legacyModuleRegistry2.getModule(Object.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Context getReactContext() {
        return (Context) this.reactContextHolder.get();
    }

    public final void onDestroy() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            reactApplicationContext.removeLifecycleEventListener(this.reactLifecycleDelegate);
        }
        this.registry.post(EventName.MODULE_DESTROY);
    }

    public final void onHostResume() {
        this.registry.post(EventName.ACTIVITY_ENTERS_FOREGROUND);
    }

    public final void onHostPause() {
        this.registry.post(EventName.ACTIVITY_ENTERS_BACKGROUND);
    }

    public final void onHostDestroy() {
        this.registry.post(EventName.ACTIVITY_DESTROYS);
    }

    public final void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.registry.post(EventName.ON_ACTIVITY_RESULT, activity, new OnActivityResultPayload(i, i2, intent));
    }

    public final void onNewIntent(Intent intent) {
        this.registry.post(EventName.ON_NEW_INTENT, intent);
    }

    public final ConstantsInterface getConstants() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ConstantsInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ConstantsInterface) obj;
    }

    public final FilePermissionModuleInterface getFilePermission() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(FilePermissionModuleInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (FilePermissionModuleInterface) obj;
    }

    public final Permissions getPermissions() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(Permissions.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (Permissions) obj;
    }

    public final ImageLoaderInterface getImageLoader() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ImageLoaderInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ImageLoaderInterface) obj;
    }

    public final BarCodeScannerInterface getBarcodeScanner() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(BarCodeScannerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (BarCodeScannerInterface) obj;
    }

    public final CameraViewInterface getCamera() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(CameraViewInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (CameraViewInterface) obj;
    }

    public final FontManagerInterface getFont() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(FontManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (FontManagerInterface) obj;
    }

    public final SensorServiceInterface getSensor() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(SensorServiceInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (SensorServiceInterface) obj;
    }

    public final TaskManagerInterface getTaskManager() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (TaskManagerInterface) obj;
    }

    public final ActivityProvider getActivityProvider() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ActivityProvider.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ActivityProvider) obj;
    }

    public final EventEmitter eventEmitter(Module module) {
        Object obj;
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            obj = getLegacyModuleRegistry().getModule(EventEmitter.class);
        } catch (Exception unused) {
            obj = null;
        }
        EventEmitter eventEmitter = (EventEmitter) obj;
        if (eventEmitter == null) {
            return null;
        }
        ModuleHolder moduleHolder = this.registry.getModuleHolder(module);
        if (moduleHolder != null) {
            return new KEventEmitterWrapper(moduleHolder, eventEmitter);
        }
        throw new IllegalArgumentException("Cannot create an event emitter for the module that isn't present in the module registry.".toString());
    }
}
