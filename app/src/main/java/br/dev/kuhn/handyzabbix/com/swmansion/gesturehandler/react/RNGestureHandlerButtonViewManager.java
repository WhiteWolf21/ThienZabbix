package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.gesturehandler.NativeViewGestureHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(mo24973d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0007J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0011H\u0007J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010\u001b¨\u0006\u001f"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "()V", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "onAfterUpdateTransaction", "", "view", "setBorderRadius", "borderRadius", "", "setBorderless", "useBorderlessDrawable", "", "setEnabled", "enabled", "setExclusive", "exclusive", "setForeground", "useDrawableOnForeground", "setRippleColor", "rippleColor", "", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;Ljava/lang/Integer;)V", "setRippleRadius", "rippleRadius", "ButtonViewGroup", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: RNGestureHandlerButtonViewManager.kt */
public final class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> {
    public String getName() {
        return "RNGestureHandlerButton";
    }

    public ButtonViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new ButtonViewGroup(themedReactContext);
    }

    @ReactProp(name = "foreground")
    public final void setForeground(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setUseDrawableOnForeground(z);
    }

    @ReactProp(name = "borderless")
    public final void setBorderless(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setUseBorderlessDrawable(z);
    }

    @ReactProp(name = "enabled")
    public final void setEnabled(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setEnabled(z);
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setBorderRadius(f);
    }

    @ReactProp(name = "rippleColor")
    public final void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setRippleColor(num);
    }

    @ReactProp(name = "rippleRadius")
    public final void setRippleRadius(ButtonViewGroup buttonViewGroup, Integer num) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setRippleRadius(num);
    }

    public static /* synthetic */ void setExclusive$default(RNGestureHandlerButtonViewManager rNGestureHandlerButtonViewManager, ButtonViewGroup buttonViewGroup, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        rNGestureHandlerButtonViewManager.setExclusive(buttonViewGroup, z);
    }

    @ReactProp(name = "exclusive")
    public final void setExclusive(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setExclusive(z);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.updateBackground();
    }

    @Metadata(mo24973d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020\u0010H\u0016J\b\u00102\u001a\u00020/H\u0002J\u0018\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u00020-2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0018\u00107\u001a\u00020\u00102\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0002J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0016J0\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0014J\u0010\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020=H\u0017J\u0010\u0010F\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020\u0010H\u0016J\b\u0010I\u001a\u00020-H\u0002J\b\u0010J\u001a\u00020\u0010H\u0002J\u0006\u0010K\u001a\u00020-J\u0017\u0010L\u001a\u00020-2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020-0NH\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R$\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014¨\u0006P"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Landroid/view/ViewGroup;", "Lcom/swmansion/gesturehandler/NativeViewGestureHandler$StateChangeHook;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_backgroundColor", "", "radius", "", "borderRadius", "getBorderRadius", "()F", "setBorderRadius", "(F)V", "exclusive", "", "getExclusive", "()Z", "setExclusive", "(Z)V", "isTouched", "setTouched", "lastAction", "lastEventTime", "", "needBackgroundUpdate", "color", "rippleColor", "getRippleColor", "()Ljava/lang/Integer;", "setRippleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rippleRadius", "getRippleRadius", "setRippleRadius", "useBorderlessDrawable", "getUseBorderlessDrawable", "setUseBorderlessDrawable", "useForeground", "useDrawableOnForeground", "getUseDrawableOnForeground", "setUseDrawableOnForeground", "afterGestureEnd", "", "applyRippleEffectWhenNeeded", "Landroid/graphics/drawable/Drawable;", "selectable", "canStart", "createSelectableDrawable", "dispatchDrawableHotspotChanged", "x", "y", "drawableHotspotChanged", "isChildTouched", "children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "t", "r", "b", "onTouchEvent", "event", "setBackgroundColor", "setPressed", "pressed", "tryFreeingResponder", "tryGrabbingResponder", "updateBackground", "withBackgroundUpdate", "block", "Lkotlin/Function0;", "Companion", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerButtonViewManager.kt */
    public static final class ButtonViewGroup extends ViewGroup implements NativeViewGestureHandler.StateChangeHook {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String SELECTABLE_ITEM_BACKGROUND = "selectableItemBackground";
        public static final String SELECTABLE_ITEM_BACKGROUND_BORDERLESS = "selectableItemBackgroundBorderless";
        /* access modifiers changed from: private */
        public static View.OnClickListener dummyClickListener = C1594xeef1704a.INSTANCE;
        /* access modifiers changed from: private */
        public static TypedValue resolveOutValue = new TypedValue();
        /* access modifiers changed from: private */
        public static ButtonViewGroup responder;
        private int _backgroundColor;
        private float borderRadius;
        private boolean exclusive = true;
        private boolean isTouched;
        private int lastAction = -1;
        private long lastEventTime = -1;
        /* access modifiers changed from: private */
        public boolean needBackgroundUpdate;
        private Integer rippleColor;
        private Integer rippleRadius;
        private boolean useBorderlessDrawable;
        private boolean useDrawableOnForeground;

        /* access modifiers changed from: private */
        /* renamed from: dummyClickListener$lambda-5  reason: not valid java name */
        public static final void m207dummyClickListener$lambda5(View view) {
        }

        public void dispatchDrawableHotspotChanged(float f, float f2) {
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public ButtonViewGroup(Context context) {
            super(context);
            setOnClickListener(dummyClickListener);
            setClickable(true);
            setFocusable(true);
            this.needBackgroundUpdate = true;
        }

        public final Integer getRippleColor() {
            return this.rippleColor;
        }

        public final void setRippleColor(Integer num) {
            this.rippleColor = num;
            this.needBackgroundUpdate = true;
        }

        public final Integer getRippleRadius() {
            return this.rippleRadius;
        }

        public final void setRippleRadius(Integer num) {
            this.rippleRadius = num;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseDrawableOnForeground() {
            return this.useDrawableOnForeground;
        }

        public final void setUseDrawableOnForeground(boolean z) {
            this.useDrawableOnForeground = z;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseBorderlessDrawable() {
            return this.useBorderlessDrawable;
        }

        public final void setUseBorderlessDrawable(boolean z) {
            this.useBorderlessDrawable = z;
        }

        public final float getBorderRadius() {
            return this.borderRadius;
        }

        public final void setBorderRadius(float f) {
            this.borderRadius = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final boolean getExclusive() {
            return this.exclusive;
        }

        public final void setExclusive(boolean z) {
            this.exclusive = z;
        }

        public final boolean isTouched() {
            return this.isTouched;
        }

        public final void setTouched(boolean z) {
            this.isTouched = z;
        }

        private final void withBackgroundUpdate(Function0<Unit> function0) {
            function0.invoke();
            this.needBackgroundUpdate = true;
        }

        public void setBackgroundColor(int i) {
            this._backgroundColor = i;
            this.needBackgroundUpdate = true;
        }

        private final Drawable applyRippleEffectWhenNeeded(Drawable drawable) {
            Integer num = this.rippleColor;
            if (num != null && Build.VERSION.SDK_INT >= 21 && (drawable instanceof RippleDrawable)) {
                ((RippleDrawable) drawable).setColor(new ColorStateList(new int[][]{new int[]{16842910}}, new int[]{num.intValue()}));
            }
            Integer num2 = this.rippleRadius;
            if (Build.VERSION.SDK_INT >= 23 && num2 != null && (drawable instanceof RippleDrawable)) {
                ((RippleDrawable) drawable).setRadius((int) PixelUtil.toPixelFromDIP((float) num2.intValue()));
            }
            return drawable;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "ev");
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            return isPressed();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            long eventTime = motionEvent.getEventTime();
            int action = motionEvent.getAction();
            if (this.lastEventTime == eventTime && this.lastAction == action) {
                return false;
            }
            this.lastEventTime = eventTime;
            this.lastAction = action;
            return super.onTouchEvent(motionEvent);
        }

        public final void updateBackground() {
            if (this.needBackgroundUpdate) {
                this.needBackgroundUpdate = false;
                if (this._backgroundColor == 0) {
                    setBackground((Drawable) null);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    setForeground((Drawable) null);
                }
                if (this.useDrawableOnForeground && Build.VERSION.SDK_INT >= 23) {
                    setForeground(applyRippleEffectWhenNeeded(createSelectableDrawable()));
                    int i = this._backgroundColor;
                    if (i != 0) {
                        setBackgroundColor(i);
                    }
                } else if (this._backgroundColor == 0 && this.rippleColor == null) {
                    setBackground(createSelectableDrawable());
                } else {
                    PaintDrawable paintDrawable = new PaintDrawable(this._backgroundColor);
                    Drawable createSelectableDrawable = createSelectableDrawable();
                    float f = this.borderRadius;
                    if (!(f == 0.0f)) {
                        paintDrawable.setCornerRadius(f);
                        if (Build.VERSION.SDK_INT >= 21 && (createSelectableDrawable instanceof RippleDrawable)) {
                            PaintDrawable paintDrawable2 = new PaintDrawable(-1);
                            paintDrawable2.setCornerRadius(this.borderRadius);
                            ((RippleDrawable) createSelectableDrawable).setDrawableByLayerId(16908334, paintDrawable2);
                        }
                    }
                    applyRippleEffectWhenNeeded(createSelectableDrawable);
                    setBackground(new LayerDrawable(new Drawable[]{paintDrawable, createSelectableDrawable}));
                }
            }
        }

        private final Drawable createSelectableDrawable() {
            int i = Build.VERSION.SDK_INT;
            String str = (!this.useBorderlessDrawable || i < 21) ? SELECTABLE_ITEM_BACKGROUND : SELECTABLE_ITEM_BACKGROUND_BORDERLESS;
            Companion companion = Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            getContext().getTheme().resolveAttribute(companion.getAttrId(context, str), resolveOutValue, true);
            if (i >= 21) {
                Drawable drawable = getResources().getDrawable(resolveOutValue.resourceId, getContext().getTheme());
                Intrinsics.checkNotNullExpressionValue(drawable, "{\n        resources.getDrawable(resolveOutValue.resourceId, context.theme)\n      }");
                return drawable;
            }
            Drawable drawable2 = getResources().getDrawable(resolveOutValue.resourceId);
            Intrinsics.checkNotNullExpressionValue(drawable2, "{\n        @Suppress(\"Deprecation\")\n        resources.getDrawable(resolveOutValue.resourceId)\n      }");
            return drawable2;
        }

        public void drawableHotspotChanged(float f, float f2) {
            ButtonViewGroup buttonViewGroup = responder;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f, f2);
            }
        }

        public boolean canStart() {
            boolean tryGrabbingResponder = tryGrabbingResponder();
            if (tryGrabbingResponder) {
                this.isTouched = true;
            }
            return tryGrabbingResponder;
        }

        public void afterGestureEnd() {
            tryFreeingResponder();
            this.isTouched = false;
        }

        private final boolean tryGrabbingResponder() {
            boolean z;
            if (isChildTouched$default(this, (Sequence) null, 1, (Object) null)) {
                return false;
            }
            ButtonViewGroup buttonViewGroup = responder;
            if (buttonViewGroup == null) {
                responder = this;
                return true;
            }
            if (!this.exclusive) {
                if (buttonViewGroup == null) {
                    z = false;
                } else {
                    z = buttonViewGroup.exclusive;
                }
                if (!z) {
                    return true;
                }
            } else if (buttonViewGroup == this) {
                return true;
            }
            return false;
        }

        private final void tryFreeingResponder() {
            if (responder == this) {
                responder = null;
            }
        }

        static /* synthetic */ boolean isChildTouched$default(ButtonViewGroup buttonViewGroup, Sequence<View> sequence, int i, Object obj) {
            if ((i & 1) != 0) {
                sequence = ViewGroupKt.getChildren(buttonViewGroup);
            }
            return buttonViewGroup.isChildTouched(sequence);
        }

        private final boolean isChildTouched(Sequence<? extends View> sequence) {
            for (View view : sequence) {
                if (view instanceof ButtonViewGroup) {
                    ButtonViewGroup buttonViewGroup = (ButtonViewGroup) view;
                    if (buttonViewGroup.isTouched || buttonViewGroup.isPressed()) {
                        return true;
                    }
                }
                if (view instanceof ViewGroup) {
                    return isChildTouched(ViewGroupKt.getChildren((ViewGroup) view));
                }
            }
            return false;
        }

        public void setPressed(boolean z) {
            if (z) {
                tryGrabbingResponder();
            }
            boolean z2 = false;
            if (!this.exclusive) {
                ButtonViewGroup buttonViewGroup = responder;
                if (!(buttonViewGroup != null && buttonViewGroup.exclusive) && !isChildTouched$default(this, (Sequence) null, 1, (Object) null)) {
                    z2 = true;
                }
            }
            if (!z || responder == this || z2) {
                super.setPressed(z);
                this.isTouched = z;
            }
            if (!z && responder == this) {
                responder = null;
            }
        }

        @Metadata(mo24973d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$Companion;", "", "()V", "SELECTABLE_ITEM_BACKGROUND", "", "SELECTABLE_ITEM_BACKGROUND_BORDERLESS", "dummyClickListener", "Landroid/view/View$OnClickListener;", "getDummyClickListener", "()Landroid/view/View$OnClickListener;", "setDummyClickListener", "(Landroid/view/View$OnClickListener;)V", "resolveOutValue", "Landroid/util/TypedValue;", "getResolveOutValue", "()Landroid/util/TypedValue;", "setResolveOutValue", "(Landroid/util/TypedValue;)V", "responder", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "getResponder", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "setResponder", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;)V", "getAttrId", "", "context", "Landroid/content/Context;", "attr", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
        /* compiled from: RNGestureHandlerButtonViewManager.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TypedValue getResolveOutValue() {
                return ButtonViewGroup.resolveOutValue;
            }

            public final void setResolveOutValue(TypedValue typedValue) {
                Intrinsics.checkNotNullParameter(typedValue, "<set-?>");
                ButtonViewGroup.resolveOutValue = typedValue;
            }

            public final ButtonViewGroup getResponder() {
                return ButtonViewGroup.responder;
            }

            public final void setResponder(ButtonViewGroup buttonViewGroup) {
                ButtonViewGroup.responder = buttonViewGroup;
            }

            public final View.OnClickListener getDummyClickListener() {
                return ButtonViewGroup.dummyClickListener;
            }

            public final void setDummyClickListener(View.OnClickListener onClickListener) {
                Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
                ButtonViewGroup.dummyClickListener = onClickListener;
            }

            /* access modifiers changed from: private */
            public final int getAttrId(Context context, String str) {
                SoftAssertions.assertNotNull(str);
                if (Intrinsics.areEqual((Object) str, (Object) ButtonViewGroup.SELECTABLE_ITEM_BACKGROUND)) {
                    return C1595R.attr.selectableItemBackground;
                }
                if (Intrinsics.areEqual((Object) str, (Object) ButtonViewGroup.SELECTABLE_ITEM_BACKGROUND_BORDERLESS)) {
                    return C1595R.attr.selectableItemBackgroundBorderless;
                }
                return context.getResources().getIdentifier(str, "attr", "android");
            }
        }
    }
}
