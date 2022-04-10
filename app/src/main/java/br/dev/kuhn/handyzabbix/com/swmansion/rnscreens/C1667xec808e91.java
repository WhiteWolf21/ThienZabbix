package com.swmansion.rnscreens;

import android.view.animation.Animation;
import com.swmansion.rnscreens.ScreenStackFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo24974d2 = {"com/swmansion/rnscreens/ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
/* renamed from: com.swmansion.rnscreens.ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1 */
/* compiled from: ScreenStackFragment.kt */
public final class C1667xec808e91 implements Animation.AnimationListener {
    final /* synthetic */ ScreenStackFragment.ScreensCoordinatorLayout this$0;

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    C1667xec808e91(ScreenStackFragment.ScreensCoordinatorLayout screensCoordinatorLayout) {
        this.this$0 = screensCoordinatorLayout;
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.mFragment.onViewAnimationStart();
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.mFragment.onViewAnimationEnd();
    }
}
