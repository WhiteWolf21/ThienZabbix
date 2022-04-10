package com.swmansion.rnscreens;

import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "", "run"}, mo24975k = 3, mo24976mv = {1, 4, 0})
/* compiled from: ScreenStackFragment.kt */
final class ScreenStackFragment$onCreateAnimation$1 implements Runnable {
    final /* synthetic */ ScreenStackFragment this$0;

    ScreenStackFragment$onCreateAnimation$1(ScreenStackFragment screenStackFragment) {
        this.this$0 = screenStackFragment;
    }

    public final void run() {
        this.this$0.dispatchOnWillAppear();
        this.this$0.dispatchOnAppear();
    }
}
