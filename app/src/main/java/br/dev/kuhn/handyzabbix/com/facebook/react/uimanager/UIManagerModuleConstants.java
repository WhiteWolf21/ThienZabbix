package com.facebook.react.uimanager;

import android.widget.ImageView;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.events.TouchEventType;
import java.util.HashMap;
import java.util.Map;

class UIManagerModuleConstants {
    public static final String ACTION_DISMISSED = "dismissed";
    public static final String ACTION_ITEM_SELECTED = "itemSelected";

    UIManagerModuleConstants() {
    }

    static Map getBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topChange", MapBuilder.m123of("phasedRegistrationNames", MapBuilder.m124of("bubbled", "onChange", "captured", "onChangeCapture"))).put("topSelect", MapBuilder.m123of("phasedRegistrationNames", MapBuilder.m124of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(TouchEventType.getJSEventName(TouchEventType.START), MapBuilder.m123of("phasedRegistrationNames", MapBuilder.m124of("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).put(TouchEventType.getJSEventName(TouchEventType.MOVE), MapBuilder.m123of("phasedRegistrationNames", MapBuilder.m124of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).put(TouchEventType.getJSEventName(TouchEventType.END), MapBuilder.m123of("phasedRegistrationNames", MapBuilder.m124of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).put(TouchEventType.getJSEventName(TouchEventType.CANCEL), MapBuilder.m123of("phasedRegistrationNames", MapBuilder.m124of("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture"))).build();
    }

    static Map getDirectEventTypeConstants() {
        return MapBuilder.builder().put("topContentSizeChange", MapBuilder.m123of("registrationName", "onContentSizeChange")).put("topLayout", MapBuilder.m123of("registrationName", ViewProps.ON_LAYOUT)).put("topLoadingError", MapBuilder.m123of("registrationName", "onLoadingError")).put("topLoadingFinish", MapBuilder.m123of("registrationName", "onLoadingFinish")).put("topLoadingStart", MapBuilder.m123of("registrationName", "onLoadingStart")).put("topSelectionChange", MapBuilder.m123of("registrationName", "onSelectionChange")).put("topMessage", MapBuilder.m123of("registrationName", "onMessage")).put("topClick", MapBuilder.m123of("registrationName", "onClick")).put("topScrollBeginDrag", MapBuilder.m123of("registrationName", "onScrollBeginDrag")).put("topScrollEndDrag", MapBuilder.m123of("registrationName", "onScrollEndDrag")).put("topScroll", MapBuilder.m123of("registrationName", "onScroll")).put("topMomentumScrollBegin", MapBuilder.m123of("registrationName", "onMomentumScrollBegin")).put("topMomentumScrollEnd", MapBuilder.m123of("registrationName", "onMomentumScrollEnd")).build();
    }

    public static Map<String, Object> getConstants() {
        HashMap newHashMap = MapBuilder.newHashMap();
        newHashMap.put("UIView", MapBuilder.m123of("ContentMode", MapBuilder.m125of("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        newHashMap.put("StyleConstants", MapBuilder.m123of("PointerEventsValues", MapBuilder.m126of("none", Integer.valueOf(PointerEvents.NONE.ordinal()), "boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(PointerEvents.AUTO.ordinal()))));
        newHashMap.put("PopupMenu", MapBuilder.m124of(ACTION_DISMISSED, ACTION_DISMISSED, ACTION_ITEM_SELECTED, ACTION_ITEM_SELECTED));
        newHashMap.put("AccessibilityEventTypes", MapBuilder.m125of("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return newHashMap;
    }
}
