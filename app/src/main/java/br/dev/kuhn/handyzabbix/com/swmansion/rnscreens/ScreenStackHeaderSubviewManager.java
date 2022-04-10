package com.swmansion.rnscreens;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007¨\u0006\u000f"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderSubviewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "()V", "createViewInstance", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "setType", "", "view", "Lcom/swmansion/rnscreens/ScreenStackHeaderSubview;", "type", "Companion", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
@ReactModule(name = "RNSScreenStackHeaderSubview")
/* compiled from: ScreenStackHeaderSubviewManager.kt */
public final class ScreenStackHeaderSubviewManager extends ReactViewManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderSubview";

    public String getName() {
        return REACT_CLASS;
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new ScreenStackHeaderSubview(themedReactContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r3.setType(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Unknown type " + r4);
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "type")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setType(com.swmansion.rnscreens.ScreenStackHeaderSubview r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.hashCode()
            switch(r0) {
                case -1364013995: goto L_0x003e;
                case 3015911: goto L_0x0033;
                case 3317767: goto L_0x0028;
                case 108511772: goto L_0x001d;
                case 1778179403: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x004c
        L_0x0012:
            java.lang.String r0 = "searchBar"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x004c
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.SEARCH_BAR
            goto L_0x0048
        L_0x001d:
            java.lang.String r0 = "right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x004c
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.RIGHT
            goto L_0x0048
        L_0x0028:
            java.lang.String r0 = "left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x004c
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.LEFT
            goto L_0x0048
        L_0x0033:
            java.lang.String r0 = "back"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x004c
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.BACK
            goto L_0x0048
        L_0x003e:
            java.lang.String r0 = "center"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x004c
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.CENTER
        L_0x0048:
            r3.setType(r4)
            return
        L_0x004c:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStackHeaderSubviewManager.setType(com.swmansion.rnscreens.ScreenStackHeaderSubview, java.lang.String):void");
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderSubviewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenStackHeaderSubviewManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
