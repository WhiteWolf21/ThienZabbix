package br.dev.kuhn.handyzabbix.expo.modules.kotlin.views;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import expo.modules.core.ViewManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p014io.FilenameUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo24974d2 = {"Lexpo/modules/kotlin/views/ViewManagerDefinition;", "", "viewFactory", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "viewType", "Ljava/lang/Class;", "props", "", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Class;Ljava/util/Map;)V", "createView", "context", "getViewManagerType", "Lexpo/modules/core/ViewManager$ViewManagerType;", "setProps", "", "propsToSet", "Lcom/facebook/react/bridge/ReadableMap;", "onView", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ViewManagerDefinition.kt */
public final class ViewManagerDefinition {
    private final Map<String, AnyViewProp> props;
    private final Function1<Context, View> viewFactory;
    private final Class<? extends View> viewType;

    public ViewManagerDefinition(Function1<? super Context, ? extends View> function1, Class<? extends View> cls, Map<String, ? extends AnyViewProp> map) {
        Intrinsics.checkNotNullParameter(function1, "viewFactory");
        Intrinsics.checkNotNullParameter(cls, "viewType");
        Intrinsics.checkNotNullParameter(map, "props");
        this.viewFactory = function1;
        this.viewType = cls;
        this.props = map;
    }

    public final View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.viewFactory.invoke(context);
    }

    public final ViewManager.ViewManagerType getViewManagerType() {
        if (ViewGroup.class.isAssignableFrom(this.viewType)) {
            return ViewManager.ViewManagerType.GROUP;
        }
        return ViewManager.ViewManagerType.SIMPLE;
    }

    public final void setProps(ReadableMap readableMap, View view) {
        Intrinsics.checkNotNullParameter(readableMap, "propsToSet");
        Intrinsics.checkNotNullParameter(view, "onView");
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Intrinsics.checkNotNullExpressionValue(keySetIterator, "propsToSet.keySetIterator()");
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            AnyViewProp anyViewProp = this.props.get(nextKey);
            if (anyViewProp != null) {
                Dynamic dynamic = readableMap.getDynamic(nextKey);
                Intrinsics.checkNotNullExpressionValue(dynamic, "propsToSet.getDynamic(key)");
                try {
                    anyViewProp.set(dynamic, view);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    Integer.valueOf(Log.e("ExpoModulesCore", "Cannot set the " + nextKey + " prop on the " + this.viewType.getSimpleName() + FilenameUtils.EXTENSION_SEPARATOR, th));
                }
                dynamic.recycle();
            }
        }
    }
}
