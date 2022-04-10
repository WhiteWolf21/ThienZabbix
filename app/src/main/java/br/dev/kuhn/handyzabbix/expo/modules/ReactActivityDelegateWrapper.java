package br.dev.kuhn.handyzabbix.expo.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.collection.ArrayMap;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.PermissionListener;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactActivityHandler;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u001b\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0002\u0010 JA\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010!2\u0006\u0010\u001f\u001a\u00020\b2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0002¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0014J\"\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u00104\u001a\u00020(H\u0014J\u001a\u00105\u001a\u0002012\u0006\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u00109\u001a\u0002012\u0006\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010:\u001a\u0002012\u0006\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010;\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010/H\u0016J\b\u0010=\u001a\u00020(H\u0014J1\u0010>\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0010\u0010?\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010#2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020(H\u0014J\u0010\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u000201H\u0016J1\u0010F\u001a\u00020(2\u0010\u0010?\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010#2\u0006\u0010+\u001a\u00020,2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0002\u0010IR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000f0\u000f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, mo24974d2 = {"Lexpo/modules/ReactActivityDelegateWrapper;", "Lcom/facebook/react/ReactActivityDelegate;", "activity", "Lcom/facebook/react/ReactActivity;", "delegate", "(Lcom/facebook/react/ReactActivity;Lcom/facebook/react/ReactActivityDelegate;)V", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "reactActivityHandlers", "", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "kotlin.jvm.PlatformType", "reactActivityLifecycleListeners", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "createRootView", "Lcom/facebook/react/ReactRootView;", "getContext", "Landroid/content/Context;", "getLaunchOptions", "Landroid/os/Bundle;", "getMainComponentName", "getPlainActivity", "Landroid/app/Activity;", "getReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getReactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "invokeDelegateMethod", "T", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "A", "argTypes", "", "Ljava/lang/Class;", "args", "(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "loadApp", "", "appKey", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onCreate", "savedInstanceState", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "requestPermissions", "listener", "Lcom/facebook/react/modules/core/PermissionListener;", "([Ljava/lang/String;ILcom/facebook/react/modules/core/PermissionListener;)V", "expo_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ReactActivityDelegateWrapper.kt */
public final class ReactActivityDelegateWrapper extends ReactActivityDelegate {
    /* access modifiers changed from: private */
    public final ReactActivity activity;
    private final ReactActivityDelegate delegate;
    private final ArrayMap<String, Method> methodMap;
    private final List<ReactActivityHandler> reactActivityHandlers;
    private final List<ReactActivityLifecycleListener> reactActivityLifecycleListeners;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactActivityDelegateWrapper(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
        super(reactActivity, (String) null);
        Intrinsics.checkNotNullParameter(reactActivity, "activity");
        Intrinsics.checkNotNullParameter(reactActivityDelegate, "delegate");
        this.activity = reactActivity;
        this.delegate = reactActivityDelegate;
        Collection arrayList = new ArrayList();
        for (Package createReactActivityLifecycleListeners : ExpoModulesPackage.Companion.getPackageList()) {
            CollectionsKt.addAll(arrayList, createReactActivityLifecycleListeners.createReactActivityLifecycleListeners(this.activity));
        }
        this.reactActivityLifecycleListeners = (List) arrayList;
        Collection arrayList2 = new ArrayList();
        for (Package createReactActivityHandlers : ExpoModulesPackage.Companion.getPackageList()) {
            CollectionsKt.addAll(arrayList2, createReactActivityHandlers.createReactActivityHandlers(this.activity));
        }
        this.reactActivityHandlers = (List) arrayList2;
        this.methodMap = new ArrayMap<>();
    }

    /* access modifiers changed from: protected */
    public Bundle getLaunchOptions() {
        return (Bundle) invokeDelegateMethod("getLaunchOptions");
    }

    /* access modifiers changed from: protected */
    public ReactRootView createRootView() {
        ReactRootView reactRootView = (ReactRootView) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new ReactActivityDelegateWrapper$createRootView$1(this)));
        return reactRootView != null ? reactRootView : (ReactRootView) invokeDelegateMethod("createRootView");
    }

    /* access modifiers changed from: protected */
    public ReactNativeHost getReactNativeHost() {
        return (ReactNativeHost) invokeDelegateMethod("getReactNativeHost");
    }

    public ReactInstanceManager getReactInstanceManager() {
        ReactInstanceManager reactInstanceManager = this.delegate.getReactInstanceManager();
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "delegate.reactInstanceManager");
        return reactInstanceManager;
    }

    public String getMainComponentName() {
        return this.delegate.getMainComponentName();
    }

    /* access modifiers changed from: protected */
    public void loadApp(String str) {
        invokeDelegateMethod("loadApp", new Class[]{String.class}, new String[]{str});
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ReactActivityDelegateWrapper$onCreate$reactDelegate$1 reactActivityDelegateWrapper$onCreate$reactDelegate$1 = new ReactActivityDelegateWrapper$onCreate$reactDelegate$1(this, getPlainActivity(), getReactNativeHost(), getMainComponentName(), getLaunchOptions());
        Field declaredField = ReactActivityDelegate.class.getDeclaredField("mReactDelegate");
        Intrinsics.checkNotNullExpressionValue(declaredField, "mReactDelegate");
        declaredField.setAccessible(true);
        declaredField.set(this.delegate, reactActivityDelegateWrapper$onCreate$reactDelegate$1);
        if (getMainComponentName() != null) {
            loadApp(getMainComponentName());
        }
        for (ReactActivityLifecycleListener onCreate : this.reactActivityLifecycleListeners) {
            onCreate.onCreate(this.activity, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        invokeDelegateMethod("onResume");
        for (ReactActivityLifecycleListener onResume : this.reactActivityLifecycleListeners) {
            onResume.onResume(this.activity);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        for (ReactActivityLifecycleListener onPause : this.reactActivityLifecycleListeners) {
            onPause.onPause(this.activity);
        }
        invokeDelegateMethod("onPause");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        for (ReactActivityLifecycleListener onDestroy : this.reactActivityLifecycleListeners) {
            onDestroy.onDestroy(this.activity);
        }
        invokeDelegateMethod("onDestroy");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.delegate.onActivityResult(i, i2, intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.delegate.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.delegate.onKeyUp(i, keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.delegate.onKeyLongPress(i, keyEvent);
    }

    public boolean onBackPressed() {
        boolean z;
        Iterable<ReactActivityLifecycleListener> iterable = this.reactActivityLifecycleListeners;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReactActivityLifecycleListener onBackPressed : iterable) {
            arrayList.add(Boolean.valueOf(onBackPressed.onBackPressed()));
        }
        Iterator it = ((List) arrayList).iterator();
        loop1:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop1;
                }
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (z || booleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onBackPressed();
    }

    public boolean onNewIntent(Intent intent) {
        boolean z;
        Iterable<ReactActivityLifecycleListener> iterable = this.reactActivityLifecycleListeners;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReactActivityLifecycleListener onNewIntent : iterable) {
            arrayList.add(Boolean.valueOf(onNewIntent.onNewIntent(intent)));
        }
        Iterator it = ((List) arrayList).iterator();
        loop1:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop1;
                }
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (z || booleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onNewIntent(intent);
    }

    public void onWindowFocusChanged(boolean z) {
        this.delegate.onWindowFocusChanged(z);
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.delegate.requestPermissions(strArr, i, permissionListener);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.delegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return (Context) invokeDelegateMethod("getContext");
    }

    /* access modifiers changed from: protected */
    public Activity getPlainActivity() {
        return (Activity) invokeDelegateMethod("getPlainActivity");
    }

    private final <T> T invokeDelegateMethod(String str) {
        Method method = this.methodMap.get(str);
        if (method == null) {
            method = ReactActivityDelegate.class.getDeclaredMethod(str, new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            method.setAccessible(true);
            this.methodMap.put(str, method);
        }
        return method.invoke(this.delegate, new Object[0]);
    }

    private final <T, A> T invokeDelegateMethod(String str, Class<?>[] clsArr, A[] aArr) {
        Method method = this.methodMap.get(str);
        if (method == null) {
            method = ReactActivityDelegate.class.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            Intrinsics.checkNotNullExpressionValue(method, "method");
            method.setAccessible(true);
            this.methodMap.put(str, method);
        }
        return method.invoke(this.delegate, Arrays.copyOf(aArr, aArr.length));
    }
}
