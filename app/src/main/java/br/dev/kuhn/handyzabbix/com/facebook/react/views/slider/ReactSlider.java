package com.facebook.react.views.slider;

import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.github.mikephil.charting.utils.Utils;

public class ReactSlider extends AppCompatSeekBar {
    private static int DEFAULT_TOTAL_STEPS = 128;
    private double mMaxValue = Utils.DOUBLE_EPSILON;
    private double mMinValue = Utils.DOUBLE_EPSILON;
    private double mStep = Utils.DOUBLE_EPSILON;
    private double mStepCalculated = Utils.DOUBLE_EPSILON;
    private double mValue = Utils.DOUBLE_EPSILON;

    public ReactSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        disableStateListAnimatorIfNeeded();
    }

    /* access modifiers changed from: package-private */
    public void disableStateListAnimatorIfNeeded() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 26) {
            super.setStateListAnimator((StateListAnimator) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxValue(double d) {
        this.mMaxValue = d;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setMinValue(double d) {
        this.mMinValue = d;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setValue(double d) {
        this.mValue = d;
        updateValue();
    }

    /* access modifiers changed from: package-private */
    public void setStep(double d) {
        this.mStep = d;
        updateAll();
    }

    public double toRealProgress(int i) {
        if (i == getMax()) {
            return this.mMaxValue;
        }
        return (((double) i) * getStepValue()) + this.mMinValue;
    }

    private void updateAll() {
        if (this.mStep == Utils.DOUBLE_EPSILON) {
            this.mStepCalculated = (this.mMaxValue - this.mMinValue) / ((double) DEFAULT_TOTAL_STEPS);
        }
        setMax(getTotalSteps());
        updateValue();
    }

    private void updateValue() {
        double d = this.mValue;
        double d2 = this.mMinValue;
        setProgress((int) Math.round(((d - d2) / (this.mMaxValue - d2)) * ((double) getTotalSteps())));
    }

    private int getTotalSteps() {
        return (int) Math.ceil((this.mMaxValue - this.mMinValue) / getStepValue());
    }

    private double getStepValue() {
        double d = this.mStep;
        return d > Utils.DOUBLE_EPSILON ? d : this.mStepCalculated;
    }
}
