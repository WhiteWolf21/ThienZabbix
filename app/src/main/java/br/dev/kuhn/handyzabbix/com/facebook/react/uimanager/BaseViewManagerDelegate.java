package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
    }

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1721943862: goto L_0x0157;
                case -1721943861: goto L_0x014c;
                case -1589741021: goto L_0x0141;
                case -1267206133: goto L_0x0136;
                case -1228066334: goto L_0x012b;
                case -908189618: goto L_0x0120;
                case -908189617: goto L_0x0115;
                case -877170387: goto L_0x010a;
                case -731417480: goto L_0x00fc;
                case -101663499: goto L_0x00ee;
                case -101359900: goto L_0x00e0;
                case -80891667: goto L_0x00d2;
                case -40300674: goto L_0x00c4;
                case -4379043: goto L_0x00b6;
                case 36255470: goto L_0x00a8;
                case 333432965: goto L_0x009a;
                case 581268560: goto L_0x008c;
                case 588239831: goto L_0x007e;
                case 746986311: goto L_0x0070;
                case 1052666732: goto L_0x0062;
                case 1146842694: goto L_0x0054;
                case 1153872867: goto L_0x0046;
                case 1287124693: goto L_0x0038;
                case 1349188574: goto L_0x002a;
                case 1505602511: goto L_0x001c;
                case 2045685618: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0161
        L_0x000e:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0018
            goto L_0x0161
        L_0x0018:
            r2 = 25
            goto L_0x0161
        L_0x001c:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0026
            goto L_0x0161
        L_0x0026:
            r2 = 24
            goto L_0x0161
        L_0x002a:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x0161
        L_0x0034:
            r2 = 23
            goto L_0x0161
        L_0x0038:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0042
            goto L_0x0161
        L_0x0042:
            r2 = 22
            goto L_0x0161
        L_0x0046:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0050
            goto L_0x0161
        L_0x0050:
            r2 = 21
            goto L_0x0161
        L_0x0054:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x0161
        L_0x005e:
            r2 = 20
            goto L_0x0161
        L_0x0062:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x006c
            goto L_0x0161
        L_0x006c:
            r2 = 19
            goto L_0x0161
        L_0x0070:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x007a
            goto L_0x0161
        L_0x007a:
            r2 = 18
            goto L_0x0161
        L_0x007e:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0088
            goto L_0x0161
        L_0x0088:
            r2 = 17
            goto L_0x0161
        L_0x008c:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0096
            goto L_0x0161
        L_0x0096:
            r2 = 16
            goto L_0x0161
        L_0x009a:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00a4
            goto L_0x0161
        L_0x00a4:
            r2 = 15
            goto L_0x0161
        L_0x00a8:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00b2
            goto L_0x0161
        L_0x00b2:
            r2 = 14
            goto L_0x0161
        L_0x00b6:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00c0
            goto L_0x0161
        L_0x00c0:
            r2 = 13
            goto L_0x0161
        L_0x00c4:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ce
            goto L_0x0161
        L_0x00ce:
            r2 = 12
            goto L_0x0161
        L_0x00d2:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00dc
            goto L_0x0161
        L_0x00dc:
            r2 = 11
            goto L_0x0161
        L_0x00e0:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ea
            goto L_0x0161
        L_0x00ea:
            r2 = 10
            goto L_0x0161
        L_0x00ee:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00f8
            goto L_0x0161
        L_0x00f8:
            r2 = 9
            goto L_0x0161
        L_0x00fc:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0106
            goto L_0x0161
        L_0x0106:
            r2 = 8
            goto L_0x0161
        L_0x010a:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0113
            goto L_0x0161
        L_0x0113:
            r2 = 7
            goto L_0x0161
        L_0x0115:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x011e
            goto L_0x0161
        L_0x011e:
            r2 = 6
            goto L_0x0161
        L_0x0120:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0129
            goto L_0x0161
        L_0x0129:
            r2 = 5
            goto L_0x0161
        L_0x012b:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0134
            goto L_0x0161
        L_0x0134:
            r2 = 4
            goto L_0x0161
        L_0x0136:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x013f
            goto L_0x0161
        L_0x013f:
            r2 = 3
            goto L_0x0161
        L_0x0141:
            java.lang.String r0 = "shadowColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x014a
            goto L_0x0161
        L_0x014a:
            r2 = 2
            goto L_0x0161
        L_0x014c:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0155
            goto L_0x0161
        L_0x0155:
            r2 = 1
            goto L_0x0161
        L_0x0157:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0160
            goto L_0x0161
        L_0x0160:
            r2 = 0
        L_0x0161:
            r6 = 1065353216(0x3f800000, float:1.0)
            r0 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r2) {
                case 0: goto L_0x02bb;
                case 1: goto L_0x02ac;
                case 2: goto L_0x0297;
                case 3: goto L_0x0288;
                case 4: goto L_0x0279;
                case 5: goto L_0x026a;
                case 6: goto L_0x025b;
                case 7: goto L_0x0252;
                case 8: goto L_0x0242;
                case 9: goto L_0x0239;
                case 10: goto L_0x0230;
                case 11: goto L_0x0220;
                case 12: goto L_0x0210;
                case 13: goto L_0x0200;
                case 14: goto L_0x01f7;
                case 15: goto L_0x01e7;
                case 16: goto L_0x01d7;
                case 17: goto L_0x01c7;
                case 18: goto L_0x01be;
                case 19: goto L_0x01b5;
                case 20: goto L_0x01ac;
                case 21: goto L_0x01a3;
                case 22: goto L_0x018d;
                case 23: goto L_0x017d;
                case 24: goto L_0x0174;
                case 25: goto L_0x016b;
                default: goto L_0x0169;
            }
        L_0x0169:
            goto L_0x02c9
        L_0x016b:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            goto L_0x02c9
        L_0x0174:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
            goto L_0x02c9
        L_0x017d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0182
            goto L_0x0188
        L_0x0182:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0188:
            r6.setBorderRadius(r5, r3)
            goto L_0x02c9
        L_0x018d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0192
            goto L_0x019e
        L_0x0192:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x019e:
            r6.setBackgroundColor(r5, r1)
            goto L_0x02c9
        L_0x01a3:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            goto L_0x02c9
        L_0x01ac:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            goto L_0x02c9
        L_0x01b5:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            goto L_0x02c9
        L_0x01be:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            goto L_0x02c9
        L_0x01c7:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01cc
            goto L_0x01d2
        L_0x01cc:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01d2:
            r6.setBorderBottomRightRadius(r5, r3)
            goto L_0x02c9
        L_0x01d7:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01dc
            goto L_0x01e2
        L_0x01dc:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01e2:
            r6.setBorderBottomLeftRadius(r5, r3)
            goto L_0x02c9
        L_0x01e7:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01ec
            goto L_0x01f2
        L_0x01ec:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01f2:
            r6.setBorderTopRightRadius(r5, r3)
            goto L_0x02c9
        L_0x01f7:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            goto L_0x02c9
        L_0x0200:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0205
            goto L_0x020b
        L_0x0205:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x020b:
            r6.setElevation(r5, r0)
            goto L_0x02c9
        L_0x0210:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0215
            goto L_0x021b
        L_0x0215:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x021b:
            r6.setRotation(r5, r0)
            goto L_0x02c9
        L_0x0220:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0225
            goto L_0x022b
        L_0x0225:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x022b:
            r6.setRenderToHardwareTexture(r5, r1)
            goto L_0x02c9
        L_0x0230:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            goto L_0x02c9
        L_0x0239:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            goto L_0x02c9
        L_0x0242:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0247
            goto L_0x024d
        L_0x0247:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x024d:
            r6.setZIndex(r5, r0)
            goto L_0x02c9
        L_0x0252:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            goto L_0x02c9
        L_0x025b:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x0260
            goto L_0x0266
        L_0x0260:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x0266:
            r0.setScaleY(r5, r6)
            goto L_0x02c9
        L_0x026a:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x026f
            goto L_0x0275
        L_0x026f:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x0275:
            r0.setScaleX(r5, r6)
            goto L_0x02c9
        L_0x0279:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x027e
            goto L_0x0284
        L_0x027e:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0284:
            r6.setBorderTopLeftRadius(r5, r3)
            goto L_0x02c9
        L_0x0288:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x028d
            goto L_0x0293
        L_0x028d:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x0293:
            r0.setOpacity(r5, r6)
            goto L_0x02c9
        L_0x0297:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x029c
            goto L_0x02a8
        L_0x029c:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x02a8:
            r6.setShadowColor(r5, r1)
            goto L_0x02c9
        L_0x02ac:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02b1
            goto L_0x02b7
        L_0x02b1:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x02b7:
            r6.setTranslateY(r5, r0)
            goto L_0x02c9
        L_0x02bb:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02c0
            goto L_0x02c6
        L_0x02c0:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x02c6:
            r6.setTranslateX(r5, r0)
        L_0x02c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
