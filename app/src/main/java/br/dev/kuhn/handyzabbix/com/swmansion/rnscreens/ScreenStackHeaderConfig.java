package com.swmansion.rnscreens;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u0001jB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0006J\u0006\u0010=\u001a\u00020:J\u000e\u0010>\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0006J\b\u0010?\u001a\u00020:H\u0002J\b\u0010@\u001a\u00020:H\u0014J\b\u0010A\u001a\u00020:H\u0014J0\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0006H\u0014J\b\u0010H\u001a\u00020:H\u0007J\u0006\u0010I\u001a\u00020:J\u000e\u0010J\u001a\u00020:2\u0006\u0010<\u001a\u00020\u0006J\u001a\u0010K\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00172\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\u000e\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020\nJ\u0015\u0010Q\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010SJ\u0010\u0010T\u001a\u00020:2\b\u0010U\u001a\u0004\u0018\u00010\u0017J\u000e\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u00020\nJ\u000e\u0010X\u001a\u00020:2\u0006\u0010Y\u001a\u00020\nJ\u000e\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u00020\nJ\u000e\u0010\\\u001a\u00020:2\u0006\u0010R\u001a\u00020\u0006J\u0010\u0010]\u001a\u00020:2\b\u0010^\u001a\u0004\u0018\u00010\u0017J\u000e\u0010_\u001a\u00020:2\u0006\u0010R\u001a\u00020\u0006J\u0010\u0010`\u001a\u00020:2\b\u0010a\u001a\u0004\u0018\u00010\u0017J\u000e\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020#J\u0010\u0010d\u001a\u00020:2\b\u0010e\u001a\u0004\u0018\u00010\u0017J\u000e\u0010f\u001a\u00020:2\u0006\u0010g\u001a\u00020\nJ\u000e\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020\nR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u0004\u0018\u00010&8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010.8BX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00101\u001a\u0004\u0018\u0001028BX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006k"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configSubviewsCount", "", "getConfigSubviewsCount", "()I", "mBackButtonInCustomView", "", "mBackClickListener", "Landroid/view/View$OnClickListener;", "mBackgroundColor", "Ljava/lang/Integer;", "mConfigSubviews", "Ljava/util/ArrayList;", "Lcom/swmansion/rnscreens/ScreenStackHeaderSubview;", "Lkotlin/collections/ArrayList;", "mDefaultStartInset", "mDefaultStartInsetWithNavigation", "mDestroyed", "mDirection", "", "mIsAttachedToWindow", "mIsBackButtonHidden", "mIsHidden", "mIsShadowHidden", "mIsTopInsetEnabled", "mIsTranslucent", "mTintColor", "mTitle", "mTitleColor", "mTitleFontFamily", "mTitleFontSize", "", "mTitleFontWeight", "screen", "Lcom/swmansion/rnscreens/Screen;", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "screenFragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "getScreenFragment", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "screenStack", "Lcom/swmansion/rnscreens/ScreenStack;", "getScreenStack", "()Lcom/swmansion/rnscreens/ScreenStack;", "titleTextView", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "toolbar", "Lcom/swmansion/rnscreens/CustomToolbar;", "getToolbar", "()Lcom/swmansion/rnscreens/CustomToolbar;", "addConfigSubview", "", "child", "index", "destroy", "getConfigSubview", "maybeUpdate", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onUpdate", "removeAllConfigSubviews", "removeConfigSubview", "sendEvent", "eventName", "eventContent", "Lcom/facebook/react/bridge/WritableMap;", "setBackButtonInCustomView", "backButtonInCustomView", "setBackgroundColor", "color", "(Ljava/lang/Integer;)V", "setDirection", "direction", "setHidden", "hidden", "setHideBackButton", "hideBackButton", "setHideShadow", "hideShadow", "setTintColor", "setTitle", "title", "setTitleColor", "setTitleFontFamily", "titleFontFamily", "setTitleFontSize", "titleFontSize", "setTitleFontWeight", "fontWeightString", "setTopInsetEnabled", "topInsetEnabled", "setTranslucent", "translucent", "DebugMenuToolbar", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
/* compiled from: ScreenStackHeaderConfig.kt */
public final class ScreenStackHeaderConfig extends ViewGroup {
    private boolean mBackButtonInCustomView;
    private final View.OnClickListener mBackClickListener = new ScreenStackHeaderConfig$mBackClickListener$1(this);
    private Integer mBackgroundColor;
    private final ArrayList<ScreenStackHeaderSubview> mConfigSubviews = new ArrayList<>(3);
    private final int mDefaultStartInset;
    private final int mDefaultStartInsetWithNavigation;
    private boolean mDestroyed;
    private String mDirection;
    private boolean mIsAttachedToWindow;
    private boolean mIsBackButtonHidden;
    private boolean mIsHidden;
    private boolean mIsShadowHidden;
    private boolean mIsTopInsetEnabled = true;
    private boolean mIsTranslucent;
    private int mTintColor;
    private String mTitle;
    private int mTitleColor;
    private String mTitleFontFamily;
    private float mTitleFontSize;
    private int mTitleFontWeight;
    private final CustomToolbar toolbar;

    @Metadata(mo24972bv = {1, 0, 3}, mo24975k = 3, mo24976mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenStackHeaderSubview.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ScreenStackHeaderSubview.Type.LEFT.ordinal()] = 1;
            iArr[ScreenStackHeaderSubview.Type.RIGHT.ordinal()] = 2;
            iArr[ScreenStackHeaderSubview.Type.CENTER.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenStackHeaderConfig(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        CustomToolbar customToolbar = new CustomToolbar(context, this);
        this.toolbar = customToolbar;
        this.mDefaultStartInset = customToolbar.getContentInsetStart();
        this.mDefaultStartInsetWithNavigation = customToolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C1661R.attr.colorPrimary, typedValue, true)) {
            customToolbar.setBackgroundColor(typedValue.data);
        }
        customToolbar.setClipChildren(false);
    }

    public final CustomToolbar getToolbar() {
        return this.toolbar;
    }

    private final void sendEvent(String str, WritableMap writableMap) {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        RCTEventEmitter rCTEventEmitter = (RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class);
        if (rCTEventEmitter != null) {
            rCTEventEmitter.receiveEvent(getId(), str, writableMap);
        }
    }

    public final void destroy() {
        this.mDestroyed = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        sendEvent("onAttached", (WritableMap) null);
        onUpdate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
        sendEvent("onDetached", (WritableMap) null);
    }

    private final Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final ScreenStack getScreenStack() {
        Screen screen = getScreen();
        if (screen == null) {
            return null;
        }
        ScreenContainer<?> container = screen.getContainer();
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    public final ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        Fragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof ScreenStackFragment) {
            return (ScreenStackFragment) fragment;
        }
        return null;
    }

    public final void onUpdate() {
        Drawable navigationIcon;
        ScreenStackFragment screenFragment;
        ScreenStackFragment screenFragment2;
        ReactContext reactContext;
        String str;
        ScreenStack screenStack = getScreenStack();
        boolean z = screenStack == null || Intrinsics.areEqual((Object) screenStack.getTopScreen(), (Object) getParent());
        if (this.mIsAttachedToWindow && z && !this.mDestroyed) {
            ScreenStackFragment screenFragment3 = getScreenFragment();
            AppCompatActivity appCompatActivity = (AppCompatActivity) (screenFragment3 != null ? screenFragment3.getActivity() : null);
            if (appCompatActivity != null) {
                if (Build.VERSION.SDK_INT >= 17 && (str = this.mDirection) != null) {
                    if (Intrinsics.areEqual((Object) str, (Object) "rtl")) {
                        this.toolbar.setLayoutDirection(1);
                    } else if (Intrinsics.areEqual((Object) this.mDirection, (Object) "ltr")) {
                        this.toolbar.setLayoutDirection(0);
                    }
                }
                Screen screen = getScreen();
                if (screen != null) {
                    if (getContext() instanceof ReactContext) {
                        Context context = getContext();
                        Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                        reactContext = (ReactContext) context;
                    } else {
                        ScreenFragment fragment = screen.getFragment();
                        reactContext = fragment != null ? fragment.tryGetContext() : null;
                    }
                    ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(screen, appCompatActivity, reactContext);
                }
                if (!this.mIsHidden) {
                    if (this.toolbar.getParent() == null && (screenFragment = getScreenFragment()) != null) {
                        screenFragment.setToolbar(this.toolbar);
                    }
                    if (this.mIsTopInsetEnabled) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            CustomToolbar customToolbar = this.toolbar;
                            WindowInsets rootWindowInsets = getRootWindowInsets();
                            Intrinsics.checkNotNullExpressionValue(rootWindowInsets, "rootWindowInsets");
                            customToolbar.setPadding(0, rootWindowInsets.getSystemWindowInsetTop(), 0, 0);
                        } else {
                            CustomToolbar customToolbar2 = this.toolbar;
                            Resources resources = getResources();
                            Intrinsics.checkNotNullExpressionValue(resources, "resources");
                            customToolbar2.setPadding(0, (int) (((float) 25) * resources.getDisplayMetrics().density), 0, 0);
                        }
                    } else if (this.toolbar.getPaddingTop() > 0) {
                        this.toolbar.setPadding(0, 0, 0, 0);
                    }
                    appCompatActivity.setSupportActionBar(this.toolbar);
                    ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                    if (supportActionBar != null) {
                        this.toolbar.setContentInsetStartWithNavigation(this.mDefaultStartInsetWithNavigation);
                        CustomToolbar customToolbar3 = this.toolbar;
                        int i = this.mDefaultStartInset;
                        customToolbar3.setContentInsetsRelative(i, i);
                        ScreenStackFragment screenFragment4 = getScreenFragment();
                        supportActionBar.setDisplayHomeAsUpEnabled(screenFragment4 != null && screenFragment4.canNavigateBack() && !this.mIsBackButtonHidden);
                        this.toolbar.setNavigationOnClickListener(this.mBackClickListener);
                        ScreenStackFragment screenFragment5 = getScreenFragment();
                        if (screenFragment5 != null) {
                            screenFragment5.setToolbarShadowHidden(this.mIsShadowHidden);
                        }
                        ScreenStackFragment screenFragment6 = getScreenFragment();
                        if (screenFragment6 != null) {
                            screenFragment6.setToolbarTranslucent(this.mIsTranslucent);
                        }
                        supportActionBar.setTitle((CharSequence) this.mTitle);
                        if (TextUtils.isEmpty(this.mTitle)) {
                            this.toolbar.setContentInsetStartWithNavigation(0);
                        }
                        TextView titleTextView = getTitleTextView();
                        int i2 = this.mTitleColor;
                        if (i2 != 0) {
                            this.toolbar.setTitleTextColor(i2);
                        }
                        if (titleTextView != null) {
                            String str2 = this.mTitleFontFamily;
                            if (str2 != null || this.mTitleFontWeight > 0) {
                                int i3 = this.mTitleFontWeight;
                                Context context2 = getContext();
                                Intrinsics.checkNotNullExpressionValue(context2, "context");
                                titleTextView.setTypeface(ReactTypefaceUtils.applyStyles((Typeface) null, 0, i3, str2, context2.getAssets()));
                            }
                            float f = this.mTitleFontSize;
                            if (f > ((float) 0)) {
                                titleTextView.setTextSize(f);
                            }
                        }
                        Integer num = this.mBackgroundColor;
                        if (num != null) {
                            this.toolbar.setBackgroundColor(num.intValue());
                        }
                        if (!(this.mTintColor == 0 || (navigationIcon = this.toolbar.getNavigationIcon()) == null)) {
                            navigationIcon.setColorFilter(this.mTintColor, PorterDuff.Mode.SRC_ATOP);
                        }
                        for (int childCount = this.toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                            if (this.toolbar.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                                this.toolbar.removeViewAt(childCount);
                            }
                        }
                        int size = this.mConfigSubviews.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            ScreenStackHeaderSubview screenStackHeaderSubview = this.mConfigSubviews.get(i4);
                            Intrinsics.checkNotNullExpressionValue(screenStackHeaderSubview, "mConfigSubviews[i]");
                            ScreenStackHeaderSubview screenStackHeaderSubview2 = screenStackHeaderSubview;
                            ScreenStackHeaderSubview.Type type = screenStackHeaderSubview2.getType();
                            if (type == ScreenStackHeaderSubview.Type.BACK) {
                                View childAt = screenStackHeaderSubview2.getChildAt(0);
                                if (!(childAt instanceof ImageView)) {
                                    childAt = null;
                                }
                                ImageView imageView = (ImageView) childAt;
                                if (imageView != null) {
                                    supportActionBar.setHomeAsUpIndicator(imageView.getDrawable());
                                } else {
                                    throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                                }
                            } else {
                                Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -1);
                                int i5 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                                if (i5 == 1) {
                                    if (!this.mBackButtonInCustomView) {
                                        this.toolbar.setNavigationIcon((Drawable) null);
                                    }
                                    this.toolbar.setTitle((CharSequence) null);
                                    layoutParams.gravity = GravityCompat.START;
                                } else if (i5 == 2) {
                                    layoutParams.gravity = GravityCompat.END;
                                } else if (i5 == 3) {
                                    layoutParams.width = -1;
                                    layoutParams.gravity = 1;
                                    this.toolbar.setTitle((CharSequence) null);
                                }
                                screenStackHeaderSubview2.setLayoutParams(layoutParams);
                                this.toolbar.addView(screenStackHeaderSubview2);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                } else if (this.toolbar.getParent() != null && (screenFragment2 = getScreenFragment()) != null) {
                    screenFragment2.removeToolbar();
                }
            }
        }
    }

    private final void maybeUpdate() {
        if (getParent() != null && !this.mDestroyed) {
            onUpdate();
        }
    }

    public final ScreenStackHeaderSubview getConfigSubview(int i) {
        ScreenStackHeaderSubview screenStackHeaderSubview = this.mConfigSubviews.get(i);
        Intrinsics.checkNotNullExpressionValue(screenStackHeaderSubview, "mConfigSubviews[index]");
        return screenStackHeaderSubview;
    }

    public final int getConfigSubviewsCount() {
        return this.mConfigSubviews.size();
    }

    public final void removeConfigSubview(int i) {
        this.mConfigSubviews.remove(i);
        maybeUpdate();
    }

    public final void removeAllConfigSubviews() {
        this.mConfigSubviews.clear();
        maybeUpdate();
    }

    public final void addConfigSubview(ScreenStackHeaderSubview screenStackHeaderSubview, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderSubview, "child");
        this.mConfigSubviews.add(i, screenStackHeaderSubview);
        maybeUpdate();
    }

    private final TextView getTitleTextView() {
        int childCount = this.toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.toolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (Intrinsics.areEqual((Object) textView.getText(), (Object) this.toolbar.getTitle())) {
                    return textView;
                }
            }
        }
        return null;
    }

    public final void setTitle(String str) {
        this.mTitle = str;
    }

    public final void setTitleFontFamily(String str) {
        this.mTitleFontFamily = str;
    }

    public final void setTitleFontWeight(String str) {
        this.mTitleFontWeight = ReactTypefaceUtils.parseFontWeight(str);
    }

    public final void setTitleFontSize(float f) {
        this.mTitleFontSize = f;
    }

    public final void setTitleColor(int i) {
        this.mTitleColor = i;
    }

    public final void setTintColor(int i) {
        this.mTintColor = i;
    }

    public final void setTopInsetEnabled(boolean z) {
        this.mIsTopInsetEnabled = z;
    }

    public final void setBackgroundColor(Integer num) {
        this.mBackgroundColor = num;
    }

    public final void setHideShadow(boolean z) {
        this.mIsShadowHidden = z;
    }

    public final void setHideBackButton(boolean z) {
        this.mIsBackButtonHidden = z;
    }

    public final void setHidden(boolean z) {
        this.mIsHidden = z;
    }

    public final void setTranslucent(boolean z) {
        this.mIsTranslucent = z;
    }

    public final void setBackButtonInCustomView(boolean z) {
        this.mBackButtonInCustomView = z;
    }

    public final void setDirection(String str) {
        this.mDirection = str;
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfig$DebugMenuToolbar;", "Lcom/swmansion/rnscreens/CustomToolbar;", "context", "Landroid/content/Context;", "config", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;)V", "showOverflowMenu", "", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenStackHeaderConfig.kt */
    private static final class DebugMenuToolbar extends CustomToolbar {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DebugMenuToolbar(Context context, ScreenStackHeaderConfig screenStackHeaderConfig) {
            super(context, screenStackHeaderConfig);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        }

        public boolean showOverflowMenu() {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Context applicationContext = context.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            ReactNativeHost reactNativeHost = ((ReactApplication) applicationContext).getReactNativeHost();
            Intrinsics.checkNotNullExpressionValue(reactNativeHost, "(context.applicationCont…         .reactNativeHost");
            reactNativeHost.getReactInstanceManager().showDevOptionsDialog();
            return true;
        }
    }
}
