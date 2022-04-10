package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0012\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0016H\u0007J\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\nH\u0007J\u001a\u0010$\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0016H\u0007J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0016H\u0007J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0016H\u0007J\u001a\u0010,\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\nH\u0007J\u001a\u00100\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u00102\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u00103\u001a\u000204H\u0007J\u001a\u00105\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u00107\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0016H\u0007J\u0018\u00109\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0016H\u0007¨\u0006<"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfigViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "()V", "addView", "", "parent", "child", "Landroid/view/View;", "index", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "getChildCount", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "needsCustomLayoutForChildren", "", "onAfterUpdateTransaction", "onDropViewInstance", "view", "removeAllViews", "removeViewAt", "setBackButtonInCustomView", "config", "backButtonInCustomView", "setBackgroundColor", "backgroundColor", "(Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;Ljava/lang/Integer;)V", "setColor", "color", "setDirection", "direction", "setHidden", "hidden", "setHideBackButton", "hideBackButton", "setHideShadow", "hideShadow", "setTitle", "title", "setTitleColor", "titleColor", "setTitleFontFamily", "titleFontFamily", "setTitleFontSize", "titleFontSize", "", "setTitleFontWeight", "titleFontWeight", "setTopInsetEnabled", "topInsetEnabled", "setTranslucent", "translucent", "Companion", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
@ReactModule(name = "RNSScreenStackHeaderConfig")
/* compiled from: ScreenStackHeaderConfigViewManager.kt */
public final class ScreenStackHeaderConfigViewManager extends ViewGroupManager<ScreenStackHeaderConfig> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderConfig";

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ScreenStackHeaderConfig createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new ScreenStackHeaderConfig(themedReactContext);
    }

    public void addView(ScreenStackHeaderConfig screenStackHeaderConfig, View view, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        Intrinsics.checkNotNullParameter(view, "child");
        if (view instanceof ScreenStackHeaderSubview) {
            screenStackHeaderConfig.addConfigSubview((ScreenStackHeaderSubview) view, i);
            return;
        }
        throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
    }

    public void onDropViewInstance(@Nonnull ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "view");
        screenStackHeaderConfig.destroy();
    }

    public void removeAllViews(ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        screenStackHeaderConfig.removeAllConfigSubviews();
    }

    public void removeViewAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        screenStackHeaderConfig.removeConfigSubview(i);
    }

    public int getChildCount(ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        return screenStackHeaderConfig.getConfigSubviewsCount();
    }

    public View getChildAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        return screenStackHeaderConfig.getConfigSubview(i);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        super.onAfterUpdateTransaction(screenStackHeaderConfig);
        screenStackHeaderConfig.onUpdate();
    }

    @ReactProp(name = "title")
    public final void setTitle(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitle(str);
    }

    @ReactProp(name = "titleFontFamily")
    public final void setTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontFamily(str);
    }

    @ReactProp(name = "titleFontSize")
    public final void setTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, float f) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontSize(f);
    }

    @ReactProp(name = "titleFontWeight")
    public final void setTitleFontWeight(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontWeight(str);
    }

    @ReactProp(customType = "Color", name = "titleColor")
    public final void setTitleColor(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleColor(i);
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public final void setBackgroundColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setBackgroundColor(num);
    }

    @ReactProp(name = "hideShadow")
    public final void setHideShadow(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHideShadow(z);
    }

    @ReactProp(name = "hideBackButton")
    public final void setHideBackButton(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHideBackButton(z);
    }

    @ReactProp(name = "topInsetEnabled")
    public final void setTopInsetEnabled(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTopInsetEnabled(z);
    }

    @ReactProp(customType = "Color", name = "color")
    public final void setColor(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTintColor(i);
    }

    @ReactProp(name = "hidden")
    public final void setHidden(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHidden(z);
    }

    @ReactProp(name = "translucent")
    public final void setTranslucent(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTranslucent(z);
    }

    @ReactProp(name = "backButtonInCustomView")
    public final void setBackButtonInCustomView(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setBackButtonInCustomView(z);
    }

    @ReactProp(name = "direction")
    public final void setDirection(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setDirection(str);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onAttached", MapBuilder.m123of("registrationName", "onAttached")).put("onDetached", MapBuilder.m123of("registrationName", "onDetached")).build();
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfigViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenStackHeaderConfigViewManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
