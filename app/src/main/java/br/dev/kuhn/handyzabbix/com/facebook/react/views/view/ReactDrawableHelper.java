package com.facebook.react.views.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import expo.modules.notifications.service.NotificationsService;

public class ReactDrawableHelper {
    private static final TypedValue sResolveOutValue = new TypedValue();

    public static Drawable createDrawableFromJSDescription(Context context, ReadableMap readableMap) {
        String string = readableMap.getString(NotificationsService.EVENT_TYPE_KEY);
        if ("ThemeAttrAndroid".equals(string)) {
            String string2 = readableMap.getString("attribute");
            int attrId = getAttrId(context, string2);
            if (context.getTheme().resolveAttribute(attrId, sResolveOutValue, true)) {
                return setRadius(readableMap, getDefaultThemeDrawable(context));
            }
            throw new JSApplicationIllegalArgumentException("Attribute " + string2 + " with id " + attrId + " couldn't be resolved into a drawable");
        } else if ("RippleAndroid".equals(string)) {
            return setRadius(readableMap, getRippleDrawable(context, readableMap));
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid type for android drawable: " + string);
        }
    }

    private static int getAttrId(Context context, String str) {
        SoftAssertions.assertNotNull(str);
        if (RNGestureHandlerButtonViewManager.ButtonViewGroup.SELECTABLE_ITEM_BACKGROUND.equals(str)) {
            return 16843534;
        }
        if (RNGestureHandlerButtonViewManager.ButtonViewGroup.SELECTABLE_ITEM_BACKGROUND_BORDERLESS.equals(str)) {
            return 16843868;
        }
        return context.getResources().getIdentifier(str, "attr", "android");
    }

    private static Drawable getDefaultThemeDrawable(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable(sResolveOutValue.resourceId, context.getTheme());
        }
        return context.getResources().getDrawable(sResolveOutValue.resourceId);
    }

    private static RippleDrawable getRippleDrawable(Context context, ReadableMap readableMap) {
        int color = getColor(context, readableMap);
        return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{color}), (Drawable) null, getMask(readableMap));
    }

    private static Drawable setRadius(ReadableMap readableMap, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && readableMap.hasKey("rippleRadius") && (drawable instanceof RippleDrawable)) {
            ((RippleDrawable) drawable).setRadius((int) PixelUtil.toPixelFromDIP(readableMap.getDouble("rippleRadius")));
        }
        return drawable;
    }

    private static int getColor(Context context, ReadableMap readableMap) {
        if (readableMap.hasKey("color") && !readableMap.isNull("color")) {
            return readableMap.getInt("color");
        }
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = sResolveOutValue;
        if (theme.resolveAttribute(16843820, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
    }

    private static Drawable getMask(ReadableMap readableMap) {
        if (!readableMap.hasKey("borderless") || readableMap.isNull("borderless") || !readableMap.getBoolean("borderless")) {
            return new ColorDrawable(-1);
        }
        return null;
    }
}
