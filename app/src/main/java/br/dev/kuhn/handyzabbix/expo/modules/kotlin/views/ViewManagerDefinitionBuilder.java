package br.dev.kuhn.handyzabbix.expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import expo.modules.kotlin.types.AnyTypeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJb\u0010\u001e\u001a\u00020\u001f\"\n\b\u0000\u0010 \u0018\u0001*\u00020\u000f\"\u0006\b\u0001\u0010!\u0018\u00012\u0006\u0010\"\u001a\u00020\u000528\b\b\u0010#\u001a2\u0012\u0013\u0012\u0011H ¢\u0006\f\b%\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0013\u0012\u0011H!¢\u0006\f\b%\u0012\b\b\"\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0$H\bø\u0001\u0000J.\u0010&\u001a\u00020\u001f\"\n\b\u0000\u0010 \u0018\u0001*\u00020\u000f2\u0014\b\b\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H 0\rH\bø\u0001\u0000R0\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u00168\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0002\u0007\n\u0005\b20\u0001¨\u0006'"}, mo24974d2 = {"Lexpo/modules/kotlin/views/ViewManagerDefinitionBuilder;", "", "()V", "props", "", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "getProps$annotations", "getProps", "()Ljava/util/Map;", "setProps", "(Ljava/util/Map;)V", "viewFactory", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "getViewFactory$annotations", "getViewFactory", "()Lkotlin/jvm/functions/Function1;", "setViewFactory", "(Lkotlin/jvm/functions/Function1;)V", "viewType", "Ljava/lang/Class;", "getViewType$annotations", "getViewType", "()Ljava/lang/Class;", "setViewType", "(Ljava/lang/Class;)V", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "prop", "", "ViewType", "PropType", "name", "body", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "view", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ViewManagerDefinitionBuilder.kt */
public final class ViewManagerDefinitionBuilder {
    private Map<String, AnyViewProp> props = new LinkedHashMap();
    private Function1<? super Context, ? extends View> viewFactory;
    private Class<? extends View> viewType;

    public static /* synthetic */ void getProps$annotations() {
    }

    public static /* synthetic */ void getViewFactory$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public final Function1<Context, View> getViewFactory() {
        return this.viewFactory;
    }

    public final void setViewFactory(Function1<? super Context, ? extends View> function1) {
        this.viewFactory = function1;
    }

    public final Class<? extends View> getViewType() {
        return this.viewType;
    }

    public final void setViewType(Class<? extends View> cls) {
        this.viewType = cls;
    }

    public final Map<String, AnyViewProp> getProps() {
        return this.props;
    }

    public final void setProps(Map<String, AnyViewProp> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.props = map;
    }

    public final ViewManagerDefinition build() {
        Function1<? super Context, ? extends View> function1 = this.viewFactory;
        if (function1 != null) {
            Class<? extends View> cls = this.viewType;
            if (cls != null) {
                return new ViewManagerDefinition(function1, cls, this.props);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final /* synthetic */ <ViewType extends View> void view(Function1<? super Context, ? extends ViewType> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        Intrinsics.reifiedOperationMarker(4, "ViewType");
        setViewType(View.class);
        setViewFactory(function1);
    }

    public final /* synthetic */ <ViewType extends View, PropType> void prop(String str, Function2<? super ViewType, ? super PropType, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "body");
        Map<String, AnyViewProp> props2 = getProps();
        Intrinsics.reifiedOperationMarker(6, "PropType");
        props2.put(str, new ConcreteViewProp(str, AnyTypeKt.toAnyType((KType) null), function2));
    }
}
