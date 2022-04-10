package com.swmansion.rnscreens;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.C0052R;
import androidx.appcompat.widget.SearchView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0019R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0004¨\u0006\u001c"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchViewFormatter;", "", "searchView", "Landroidx/appcompat/widget/SearchView;", "(Landroidx/appcompat/widget/SearchView;)V", "mDefaultTextColor", "", "Ljava/lang/Integer;", "mDefaultTintBackground", "Landroid/graphics/drawable/Drawable;", "searchEditText", "Landroid/widget/EditText;", "getSearchEditText", "()Landroid/widget/EditText;", "searchTextPlate", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSearchTextPlate", "()Landroid/view/View;", "getSearchView", "()Landroidx/appcompat/widget/SearchView;", "setSearchView", "setTextColor", "", "textColor", "(Ljava/lang/Integer;)V", "setTintColor", "tintColor", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
/* compiled from: SearchViewFormatter.kt */
public final class SearchViewFormatter {
    private Integer mDefaultTextColor;
    private Drawable mDefaultTintBackground;
    private SearchView searchView;

    public SearchViewFormatter(SearchView searchView2) {
        Intrinsics.checkNotNullParameter(searchView2, "searchView");
        this.searchView = searchView2;
    }

    public final SearchView getSearchView() {
        return this.searchView;
    }

    public final void setSearchView(SearchView searchView2) {
        Intrinsics.checkNotNullParameter(searchView2, "<set-?>");
        this.searchView = searchView2;
    }

    private final EditText getSearchEditText() {
        View findViewById = this.searchView.findViewById(C0052R.C0056id.search_src_text);
        if (!(findViewById instanceof EditText)) {
            findViewById = null;
        }
        return (EditText) findViewById;
    }

    private final View getSearchTextPlate() {
        return this.searchView.findViewById(C0052R.C0056id.search_plate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r0 = r0.getTextColors();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setTextColor(java.lang.Integer r2) {
        /*
            r1 = this;
            java.lang.Integer r0 = r1.mDefaultTextColor
            if (r2 == 0) goto L_0x002c
            if (r0 != 0) goto L_0x001e
            android.widget.EditText r0 = r1.getSearchEditText()
            if (r0 == 0) goto L_0x001b
            android.content.res.ColorStateList r0 = r0.getTextColors()
            if (r0 == 0) goto L_0x001b
            int r0 = r0.getDefaultColor()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r1.mDefaultTextColor = r0
        L_0x001e:
            android.widget.EditText r0 = r1.getSearchEditText()
            if (r0 == 0) goto L_0x003b
            int r2 = r2.intValue()
            r0.setTextColor(r2)
            goto L_0x003b
        L_0x002c:
            if (r0 == 0) goto L_0x003b
            android.widget.EditText r2 = r1.getSearchEditText()
            if (r2 == 0) goto L_0x003b
            int r0 = r0.intValue()
            r2.setTextColor(r0)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchViewFormatter.setTextColor(java.lang.Integer):void");
    }

    public final void setTintColor(Integer num) {
        Drawable drawable = this.mDefaultTintBackground;
        if (num != null) {
            if (drawable == null) {
                View searchTextPlate = getSearchTextPlate();
                Intrinsics.checkNotNullExpressionValue(searchTextPlate, "searchTextPlate");
                this.mDefaultTintBackground = searchTextPlate.getBackground();
            }
            getSearchTextPlate().setBackgroundColor(num.intValue());
        } else if (drawable != null) {
            View searchTextPlate2 = getSearchTextPlate();
            Intrinsics.checkNotNullExpressionValue(searchTextPlate2, "searchTextPlate");
            searchTextPlate2.setBackground(drawable);
        }
    }
}
