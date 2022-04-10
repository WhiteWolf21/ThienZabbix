package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;

public class ModalHostViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ModalHostViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ModalHostViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1851617609: goto L_0x005b;
                case -1850124175: goto L_0x0050;
                case -1726194350: goto L_0x0045;
                case -1618432855: goto L_0x003a;
                case -1156137512: goto L_0x002f;
                case -795203165: goto L_0x0024;
                case 1195991583: goto L_0x0019;
                case 2031205598: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0065
        L_0x000e:
            java.lang.String r0 = "animationType"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0017
            goto L_0x0065
        L_0x0017:
            r2 = 7
            goto L_0x0065
        L_0x0019:
            java.lang.String r0 = "hardwareAccelerated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x0065
        L_0x0022:
            r2 = 6
            goto L_0x0065
        L_0x0024:
            java.lang.String r0 = "animated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x0065
        L_0x002d:
            r2 = 5
            goto L_0x0065
        L_0x002f:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0038
            goto L_0x0065
        L_0x0038:
            r2 = 4
            goto L_0x0065
        L_0x003a:
            java.lang.String r0 = "identifier"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0065
        L_0x0043:
            r2 = 3
            goto L_0x0065
        L_0x0045:
            java.lang.String r0 = "transparent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x004e
            goto L_0x0065
        L_0x004e:
            r2 = 2
            goto L_0x0065
        L_0x0050:
            java.lang.String r0 = "supportedOrientations"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0059
            goto L_0x0065
        L_0x0059:
            r2 = 1
            goto L_0x0065
        L_0x005b:
            java.lang.String r0 = "presentationStyle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r2 = 0
        L_0x0065:
            switch(r2) {
                case 0: goto L_0x00d7;
                case 1: goto L_0x00cd;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00ab;
                case 4: goto L_0x009a;
                case 5: goto L_0x0089;
                case 6: goto L_0x0078;
                case 7: goto L_0x006d;
                default: goto L_0x0068;
            }
        L_0x0068:
            super.setProperty(r4, r5, r6)
            goto L_0x00e0
        L_0x006d:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setAnimationType(r4, r6)
            goto L_0x00e0
        L_0x0078:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x007f
            goto L_0x0085
        L_0x007f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0085:
            r5.setHardwareAccelerated(r4, r1)
            goto L_0x00e0
        L_0x0089:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x0090
            goto L_0x0096
        L_0x0090:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0096:
            r5.setAnimated(r4, r1)
            goto L_0x00e0
        L_0x009a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00a1
            goto L_0x00a7
        L_0x00a1:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00a7:
            r5.setStatusBarTranslucent(r4, r1)
            goto L_0x00e0
        L_0x00ab:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00b2
            goto L_0x00b8
        L_0x00b2:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x00b8:
            r5.setIdentifier(r4, r1)
            goto L_0x00e0
        L_0x00bc:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00c3
            goto L_0x00c9
        L_0x00c3:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00c9:
            r5.setTransparent(r4, r1)
            goto L_0x00e0
        L_0x00cd:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setSupportedOrientations(r4, r6)
            goto L_0x00e0
        L_0x00d7:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setPresentationStyle(r4, r6)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ModalHostViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
