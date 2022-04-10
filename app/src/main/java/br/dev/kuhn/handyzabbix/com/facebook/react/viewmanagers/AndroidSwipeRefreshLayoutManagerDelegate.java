package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;

public class AndroidSwipeRefreshLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwipeRefreshLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwipeRefreshLayoutManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 1
            r3 = -1
            switch(r0) {
                case -1609594047: goto L_0x0045;
                case -1354842768: goto L_0x003a;
                case -885150488: goto L_0x002f;
                case -416037467: goto L_0x0024;
                case -321826009: goto L_0x0019;
                case 3530753: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x004f
        L_0x000e:
            java.lang.String r0 = "size"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0017
            goto L_0x004f
        L_0x0017:
            r3 = 5
            goto L_0x004f
        L_0x0019:
            java.lang.String r0 = "refreshing"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x004f
        L_0x0022:
            r3 = 4
            goto L_0x004f
        L_0x0024:
            java.lang.String r0 = "progressViewOffset"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x004f
        L_0x002d:
            r3 = 3
            goto L_0x004f
        L_0x002f:
            java.lang.String r0 = "progressBackgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0038
            goto L_0x004f
        L_0x0038:
            r3 = 2
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "colors"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x004f
        L_0x0043:
            r3 = 1
            goto L_0x004f
        L_0x0045:
            java.lang.String r0 = "enabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r3 = 0
        L_0x004f:
            switch(r3) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x009a;
                case 2: goto L_0x008a;
                case 3: goto L_0x0078;
                case 4: goto L_0x0067;
                case 5: goto L_0x0056;
                default: goto L_0x0052;
            }
        L_0x0052:
            super.setProperty(r5, r6, r7)
            goto L_0x00b4
        L_0x0056:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x005d
            goto L_0x0063
        L_0x005d:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0063:
            r6.setSize(r5, r2)
            goto L_0x00b4
        L_0x0067:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x006e
            goto L_0x0074
        L_0x006e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0074:
            r6.setRefreshing(r5, r1)
            goto L_0x00b4
        L_0x0078:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x0080
            r7 = 0
            goto L_0x0086
        L_0x0080:
            java.lang.Double r7 = (java.lang.Double) r7
            float r7 = r7.floatValue()
        L_0x0086:
            r6.setProgressViewOffset(r5, r7)
            goto L_0x00b4
        L_0x008a:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setProgressBackgroundColor(r5, r7)
            goto L_0x00b4
        L_0x009a:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setColors(r5, r7)
            goto L_0x00b4
        L_0x00a4:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x00ab
            goto L_0x00b1
        L_0x00ab:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x00b1:
            r6.setEnabled(r5, r2)
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing")) {
            ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setNativeRefreshing(t, readableArray.getBoolean(0));
        }
    }
}
