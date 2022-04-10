package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.reactcommunity.rndatetimepicker.RNConstants;
import com.swmansion.reanimated.NodesManager;
import javax.annotation.Nullable;

public class ValueNode extends Node {
    private Object mValue;

    public ValueNode(int i, @Nullable ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        if (readableMap == null || !readableMap.hasKey(RNConstants.ARG_VALUE)) {
            this.mValue = null;
            return;
        }
        ReadableType type = readableMap.getType(RNConstants.ARG_VALUE);
        if (type == ReadableType.String) {
            this.mValue = readableMap.getString(RNConstants.ARG_VALUE);
        } else if (type == ReadableType.Number) {
            this.mValue = Double.valueOf(readableMap.getDouble(RNConstants.ARG_VALUE));
        } else if (type == ReadableType.Null) {
            this.mValue = null;
        } else {
            throw new IllegalStateException("Not supported value type. Must be boolean, number or string");
        }
    }

    public void setValue(Object obj) {
        this.mValue = obj;
        forceUpdateMemoizedValue(obj);
    }

    /* access modifiers changed from: protected */
    public Object evaluate() {
        return this.mValue;
    }
}
