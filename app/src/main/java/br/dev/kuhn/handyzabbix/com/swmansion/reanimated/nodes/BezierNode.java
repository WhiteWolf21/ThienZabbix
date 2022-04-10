package com.swmansion.reanimated.nodes;

import android.graphics.PointF;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.MapUtils;
import com.swmansion.reanimated.NodesManager;

public class BezierNode extends Node {
    private final int mInputID;
    private final CubicBezierInterpolator mInterpolator;

    private static class CubicBezierInterpolator {

        /* renamed from: a */
        protected PointF f256a;

        /* renamed from: b */
        protected PointF f257b;

        /* renamed from: c */
        protected PointF f258c;
        protected PointF end;
        protected PointF start;

        public CubicBezierInterpolator(PointF pointF, PointF pointF2) {
            this.f256a = new PointF();
            this.f257b = new PointF();
            this.f258c = new PointF();
            this.start = pointF;
            this.end = pointF2;
        }

        public CubicBezierInterpolator(float f, float f2, float f3, float f4) {
            this(new PointF(f, f2), new PointF(f3, f4));
        }

        public float getInterpolation(float f) {
            return getBezierCoordinateY(getXForTime(f));
        }

        /* access modifiers changed from: protected */
        public float getBezierCoordinateY(float f) {
            this.f258c.y = this.start.y * 3.0f;
            this.f257b.y = ((this.end.y - this.start.y) * 3.0f) - this.f258c.y;
            this.f256a.y = (1.0f - this.f258c.y) - this.f257b.y;
            return f * (this.f258c.y + ((this.f257b.y + (this.f256a.y * f)) * f));
        }

        /* access modifiers changed from: protected */
        public float getXForTime(float f) {
            float f2 = f;
            for (int i = 1; i < 14; i++) {
                float bezierCoordinateX = getBezierCoordinateX(f2) - f;
                if (((double) Math.abs(bezierCoordinateX)) < 0.001d) {
                    break;
                }
                f2 -= bezierCoordinateX / getXDerivate(f2);
            }
            return f2;
        }

        private float getXDerivate(float f) {
            return this.f258c.x + (f * ((this.f257b.x * 2.0f) + (this.f256a.x * 3.0f * f)));
        }

        private float getBezierCoordinateX(float f) {
            this.f258c.x = this.start.x * 3.0f;
            this.f257b.x = ((this.end.x - this.start.x) * 3.0f) - this.f258c.x;
            this.f256a.x = (1.0f - this.f258c.x) - this.f257b.x;
            return f * (this.f258c.x + ((this.f257b.x + (this.f256a.x * f)) * f));
        }
    }

    public BezierNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputID = MapUtils.getInt(readableMap, "input", "Reanimated: Argument passed to bezier node is either of wrong type or is missing.");
        this.mInterpolator = new CubicBezierInterpolator((float) readableMap.getDouble("mX1"), (float) readableMap.getDouble("mY1"), (float) readableMap.getDouble("mX2"), (float) readableMap.getDouble("mY2"));
    }

    /* access modifiers changed from: protected */
    public Double evaluate() {
        return Double.valueOf((double) this.mInterpolator.getInterpolation(((Double) this.mNodesManager.getNodeValue(this.mInputID)).floatValue()));
    }
}
