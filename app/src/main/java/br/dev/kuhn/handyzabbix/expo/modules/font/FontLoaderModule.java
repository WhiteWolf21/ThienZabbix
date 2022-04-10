package br.dev.kuhn.handyzabbix.expo.modules.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.constants.ConstantsInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.font.FontManagerInterface;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u0001H\u0014H\u00140\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u0001H\bJ\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo24974d2 = {"Lexpo/modules/font/FontLoaderModule;", "Lexpo/modules/core/ExportedModule;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isScoped", "", "()Z", "moduleRegistryDelegate", "Lexpo/modules/core/ModuleRegistryDelegate;", "getName", "", "loadAsync", "", "fontFamilyName", "localUri", "promise", "Lexpo/modules/core/Promise;", "moduleRegistry", "Lkotlin/Lazy;", "T", "kotlin.jvm.PlatformType", "onCreate", "Lexpo/modules/core/ModuleRegistry;", "expo-font_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: FontLoaderModule.kt */
public final class FontLoaderModule extends ExportedModule {
    /* access modifiers changed from: private */
    public final ModuleRegistryDelegate moduleRegistryDelegate = new ModuleRegistryDelegate();

    public String getName() {
        return "ExpoFontLoader";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontLoaderModule(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final /* synthetic */ <T> Lazy<T> moduleRegistry() {
        ModuleRegistryDelegate access$getModuleRegistryDelegate$p = this.moduleRegistryDelegate;
        Intrinsics.needClassReification();
        return LazyKt.lazy(new FontLoaderModule$moduleRegistry$$inlined$getFromModuleRegistry$1(access$getModuleRegistryDelegate$p));
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistryDelegate.onCreate(moduleRegistry);
    }

    @ExpoMethod
    public final void loadAsync(String str, String str2, Promise promise) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(str, "fontFamilyName");
        Intrinsics.checkNotNullParameter(str2, "localUri");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            String str3 = isScoped() ? "ExpoFont-" : "";
            if (StringsKt.startsWith$default(str2, "asset://", false, 2, (Object) null)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                AssetManager assets = context.getAssets();
                String substring = str2.substring(9);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                typeface = Typeface.createFromAsset(assets, substring);
                Intrinsics.checkNotNullExpressionValue(typeface, "Typeface.createFromAsset…EME.length + 1)\n        )");
            } else {
                Uri parse = Uri.parse(str2);
                Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(localUri)");
                typeface = Typeface.createFromFile(new File(parse.getPath()));
                Intrinsics.checkNotNullExpressionValue(typeface, "Typeface.createFromFile(…ri.parse(localUri).path))");
            }
            Lazy lazy = LazyKt.lazy(new FontLoaderModule$loadAsync$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
            if (lazy.getValue() == null) {
                promise.reject("E_NO_FONT_MANAGER", "There is no FontManager in module registry. Are you sure all the dependencies of expo-font are installed and linked?");
                return;
            }
            FontManagerInterface fontManagerInterface = (FontManagerInterface) lazy.getValue();
            Intrinsics.checkNotNull(fontManagerInterface);
            fontManagerInterface.setTypeface(str3 + str, 0, typeface);
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject("E_UNEXPECTED", "Font.loadAsync unexpected exception: " + e.getMessage(), e);
        }
    }

    private final boolean isScoped() {
        Lazy lazy = LazyKt.lazy(new FontLoaderModule$isScoped$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
        if (lazy.getValue() != null) {
            ConstantsInterface constantsInterface = (ConstantsInterface) lazy.getValue();
            Intrinsics.checkNotNull(constantsInterface);
            if (Intrinsics.areEqual((Object) "expo", (Object) constantsInterface.getAppOwnership())) {
                return true;
            }
        }
        return false;
    }
}
