package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SegmentedControlManagerInterface;

public class SegmentedControlManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SegmentedControlManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SegmentedControlManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1609594047: goto L_0x0050;
                case -1063571914: goto L_0x0045;
                case -823812830: goto L_0x003a;
                case 1287124693: goto L_0x002f;
                case 1327599912: goto L_0x0024;
                case 1436069623: goto L_0x0019;
                case 1684715624: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x005a
        L_0x000e:
            java.lang.String r0 = "momentary"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0017
            goto L_0x005a
        L_0x0017:
            r3 = 6
            goto L_0x005a
        L_0x0019:
            java.lang.String r0 = "selectedIndex"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x005a
        L_0x0022:
            r3 = 5
            goto L_0x005a
        L_0x0024:
            java.lang.String r0 = "tintColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x005a
        L_0x002d:
            r3 = 4
            goto L_0x005a
        L_0x002f:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0038
            goto L_0x005a
        L_0x0038:
            r3 = 3
            goto L_0x005a
        L_0x003a:
            java.lang.String r0 = "values"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x005a
        L_0x0043:
            r3 = 2
            goto L_0x005a
        L_0x0045:
            java.lang.String r0 = "textColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x004e
            goto L_0x005a
        L_0x004e:
            r3 = 1
            goto L_0x005a
        L_0x0050:
            java.lang.String r0 = "enabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            switch(r3) {
                case 0: goto L_0x00be;
                case 1: goto L_0x00ae;
                case 2: goto L_0x00a4;
                case 3: goto L_0x0094;
                case 4: goto L_0x0084;
                case 5: goto L_0x0073;
                case 6: goto L_0x0062;
                default: goto L_0x005d;
            }
        L_0x005d:
            super.setProperty(r5, r6, r7)
            goto L_0x00ce
        L_0x0062:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            if (r7 != 0) goto L_0x0069
            goto L_0x006f
        L_0x0069:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x006f:
            r6.setMomentary(r5, r2)
            goto L_0x00ce
        L_0x0073:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            if (r7 != 0) goto L_0x007a
            goto L_0x0080
        L_0x007a:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0080:
            r6.setSelectedIndex(r5, r2)
            goto L_0x00ce
        L_0x0084:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setTintColor(r5, r7)
            goto L_0x00ce
        L_0x0094:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setBackgroundColor(r5, r7)
            goto L_0x00ce
        L_0x00a4:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setValues(r5, r7)
            goto L_0x00ce
        L_0x00ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setTextColor(r5, r7)
            goto L_0x00ce
        L_0x00be:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            if (r7 != 0) goto L_0x00c5
            goto L_0x00cb
        L_0x00c5:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00cb:
            r6.setEnabled(r5, r1)
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.SegmentedControlManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
