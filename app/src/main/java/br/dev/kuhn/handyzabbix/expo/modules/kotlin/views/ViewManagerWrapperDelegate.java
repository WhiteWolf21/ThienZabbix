package br.dev.kuhn.handyzabbix.expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.ModuleHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo24974d2 = {"Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "(Lexpo/modules/kotlin/ModuleHolder;)V", "definition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getDefinition", "()Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getModuleHolder$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "setModuleHolder$expo_modules_core_release", "name", "", "getName", "()Ljava/lang/String;", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "setProxiedProperties", "", "view", "proxiedProperties", "Lcom/facebook/react/bridge/ReadableMap;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ViewManagerWrapperDelegate.kt */
public final class ViewManagerWrapperDelegate {
    private ModuleHolder moduleHolder;

    public ViewManagerWrapperDelegate(ModuleHolder moduleHolder2) {
        Intrinsics.checkNotNullParameter(moduleHolder2, "moduleHolder");
        this.moduleHolder = moduleHolder2;
    }

    public final ModuleHolder getModuleHolder$expo_modules_core_release() {
        return this.moduleHolder;
    }

    public final void setModuleHolder$expo_modules_core_release(ModuleHolder moduleHolder2) {
        Intrinsics.checkNotNullParameter(moduleHolder2, "<set-?>");
        this.moduleHolder = moduleHolder2;
    }

    private final ViewManagerDefinition getDefinition() {
        ViewManagerDefinition viewManagerDefinition = this.moduleHolder.getDefinition().getViewManagerDefinition();
        if (viewManagerDefinition != null) {
            return viewManagerDefinition;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String getName() {
        return this.moduleHolder.getName();
    }

    public final View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getDefinition().createView(context);
    }

    public final void setProxiedProperties(View view, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(readableMap, "proxiedProperties");
        getDefinition().setProps(readableMap, view);
    }
}
