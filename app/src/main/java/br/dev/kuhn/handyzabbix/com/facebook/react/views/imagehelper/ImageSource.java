package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import com.facebook.infer.annotation.Assertions;
import com.github.mikephil.charting.utils.Utils;

public class ImageSource {
    private boolean isResource;
    private double mSize;
    private String mSource;
    private Uri mUri;

    public ImageSource(Context context, String str, double d, double d2) {
        this.mSource = str;
        this.mSize = d * d2;
        this.mUri = computeUri(context);
    }

    public ImageSource(Context context, String str) {
        this(context, str, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
    }

    public String getSource() {
        return this.mSource;
    }

    public Uri getUri() {
        return (Uri) Assertions.assertNotNull(this.mUri);
    }

    public double getSize() {
        return this.mSize;
    }

    public boolean isResource() {
        return this.isResource;
    }

    private Uri computeUri(Context context) {
        try {
            Uri parse = Uri.parse(this.mSource);
            return parse.getScheme() == null ? computeLocalUri(context) : parse;
        } catch (Exception unused) {
            return computeLocalUri(context);
        }
    }

    private Uri computeLocalUri(Context context) {
        this.isResource = true;
        return ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(context, this.mSource);
    }
}
