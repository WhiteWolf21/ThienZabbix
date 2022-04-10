package com.th3rdwave.safeareacontext;

class Rect {
    float height;
    float width;

    /* renamed from: x */
    float f281x;

    /* renamed from: y */
    float f282y;

    Rect(float f, float f2, float f3, float f4) {
        this.f281x = f;
        this.f282y = f2;
        this.width = f3;
        this.height = f4;
    }

    /* access modifiers changed from: package-private */
    public boolean equalsToRect(Rect rect) {
        if (this == rect) {
            return true;
        }
        return this.f281x == rect.f281x && this.f282y == rect.f282y && this.width == rect.width && this.height == rect.height;
    }
}
