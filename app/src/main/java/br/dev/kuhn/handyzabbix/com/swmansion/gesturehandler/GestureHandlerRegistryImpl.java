package com.swmansion.gesturehandler;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0016J+\u0010\n\u001a\u0002H\u000b\"\f\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u0002H\u000b¢\u0006\u0002\u0010\rR&\u0010\u0003\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/GestureHandlerRegistryImpl;", "Lcom/swmansion/gesturehandler/GestureHandlerRegistry;", "()V", "handlers", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Ljava/util/ArrayList;", "Lcom/swmansion/gesturehandler/GestureHandler;", "getHandlersForView", "view", "registerHandlerForView", "T", "handler", "(Landroid/view/View;Lcom/swmansion/gesturehandler/GestureHandler;)Lcom/swmansion/gesturehandler/GestureHandler;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: GestureHandlerRegistryImpl.kt */
public final class GestureHandlerRegistryImpl implements GestureHandlerRegistry {
    private final WeakHashMap<View, ArrayList<GestureHandler<?>>> handlers = new WeakHashMap<>();

    public final <T extends GestureHandler<?>> T registerHandlerForView(View view, T t) {
        Intrinsics.checkNotNullParameter(t, "handler");
        ArrayList arrayList = this.handlers.get(view);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(t);
            this.handlers.put(view, arrayList2);
        } else {
            arrayList.add(t);
        }
        return t;
    }

    public ArrayList<GestureHandler<?>> getHandlersForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.handlers.get(view);
    }
}
