package com.swmansion.rnscreens;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo24974d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo24975k = 3, mo24976mv = {1, 4, 0})
/* compiled from: SearchBarView.kt */
final class SearchBarView$setSearchViewListeners$4 implements View.OnClickListener {
    final /* synthetic */ SearchBarView this$0;

    SearchBarView$setSearchViewListeners$4(SearchBarView searchBarView) {
        this.this$0 = searchBarView;
    }

    public final void onClick(View view) {
        this.this$0.handleOpen();
    }
}
