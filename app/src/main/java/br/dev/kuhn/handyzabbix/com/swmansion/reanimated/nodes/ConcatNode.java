package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.Utils;
import java.text.NumberFormat;
import java.util.Locale;

public class ConcatNode extends Node {
    private static final NumberFormat sFormatter;
    private final int[] mInputIDs;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.ENGLISH);
        sFormatter = instance;
        instance.setMinimumFractionDigits(0);
        instance.setGroupingUsed(false);
    }

    public ConcatNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray("input"));
    }

    /* access modifiers changed from: protected */
    public String evaluate() {
        StringBuilder sb = new StringBuilder();
        for (int findNodeById : this.mInputIDs) {
            Object value = this.mNodesManager.findNodeById(findNodeById, Node.class).value();
            if (value instanceof Double) {
                value = sFormatter.format((Double) value);
            }
            sb.append(value);
        }
        return sb.toString();
    }
}
