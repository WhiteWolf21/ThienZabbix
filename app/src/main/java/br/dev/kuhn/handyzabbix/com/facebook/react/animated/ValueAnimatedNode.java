package com.facebook.react.animated;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReadableMap;
import com.github.mikephil.charting.utils.Utils;
import com.reactcommunity.rndatetimepicker.RNConstants;

class ValueAnimatedNode extends AnimatedNode {
    Object mAnimatedObject = null;
    double mOffset = Utils.DOUBLE_EPSILON;
    double mValue = Double.NaN;
    private AnimatedNodeValueListener mValueListener;

    public ValueAnimatedNode() {
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.mValue = readableMap.getDouble(RNConstants.ARG_VALUE);
        this.mOffset = readableMap.getDouble(TypedValues.Cycle.S_WAVE_OFFSET);
    }

    public double getValue() {
        if (Double.isNaN(this.mOffset + this.mValue)) {
            update();
        }
        return this.mOffset + this.mValue;
    }

    public Object getAnimatedObject() {
        return this.mAnimatedObject;
    }

    public void flattenOffset() {
        this.mValue += this.mOffset;
        this.mOffset = Utils.DOUBLE_EPSILON;
    }

    public void extractOffset() {
        this.mOffset += this.mValue;
        this.mValue = Utils.DOUBLE_EPSILON;
    }

    public void onValueUpdate() {
        AnimatedNodeValueListener animatedNodeValueListener = this.mValueListener;
        if (animatedNodeValueListener != null) {
            animatedNodeValueListener.onValueUpdate(getValue());
        }
    }

    public void setValueListener(AnimatedNodeValueListener animatedNodeValueListener) {
        this.mValueListener = animatedNodeValueListener;
    }

    public String prettyPrint() {
        return "ValueAnimatedNode[" + this.mTag + "]: value: " + this.mValue + " offset: " + this.mOffset;
    }
}
