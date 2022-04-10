package com.swmansion.gesturehandler;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0015\u0018\u0000 I2\u00020\u0001:\u0001IB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0002JS\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\f2\u0006\u0010)\u001a\u00020\n2'\u0010*\u001a#\u0012\u0019\u0012\u0017\u0012\u0002\b\u0003\u0018\u00010\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110+H\b¢\u0006\u0002\u0010.J\u001c\u0010/\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0002J \u00103\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nH\u0002J\"\u00107\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u00100\u001a\u0002012\u0006\u00108\u001a\u000205H\u0002J\u0010\u00109\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0002J \u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nH\u0002J\u0014\u0010;\u001a\u00020\u00112\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0010\u0010<\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010=\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010>\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\u0014\u0010?\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\"\u0010@\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00112\u0006\u00100\u001a\u000201J\u001c\u0010D\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010E\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nH\u0002J\b\u0010F\u001a\u00020\u001fH\u0002J \u0010G\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nH\u0002J\u0014\u0010H\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/GestureHandlerOrchestrator;", "", "wrapperView", "Landroid/view/ViewGroup;", "handlerRegistry", "Lcom/swmansion/gesturehandler/GestureHandlerRegistry;", "viewConfigHelper", "Lcom/swmansion/gesturehandler/ViewConfigurationHelper;", "(Landroid/view/ViewGroup;Lcom/swmansion/gesturehandler/GestureHandlerRegistry;Lcom/swmansion/gesturehandler/ViewConfigurationHelper;)V", "activationIndex", "", "awaitingHandlers", "", "Lcom/swmansion/gesturehandler/GestureHandler;", "[Lcom/swmansion/gesturehandler/GestureHandler;", "awaitingHandlersCount", "finishedHandlersCleanupScheduled", "", "gestureHandlers", "gestureHandlersCount", "handlersToCancel", "handlingChangeSemaphore", "isHandlingTouch", "minimumAlphaForTraversal", "", "getMinimumAlphaForTraversal", "()F", "setMinimumAlphaForTraversal", "(F)V", "preparedHandlers", "addAwaitingHandler", "", "handler", "canReceiveEvents", "view", "Landroid/view/View;", "cancelAll", "cleanupAwaitingHandlers", "cleanupFinishedHandlers", "compactHandlersIf", "handlers", "count", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "([Lcom/swmansion/gesturehandler/GestureHandler;ILkotlin/jvm/functions/Function1;)I", "deliverEventToGestureHandler", "event", "Landroid/view/MotionEvent;", "deliverEventToGestureHandlers", "extractAncestorHandlers", "coords", "", "pointerId", "extractCoordsForView", "outputCoords", "extractGestureHandlers", "viewGroup", "hasOtherHandlerToWaitFor", "isClipping", "isViewAttachedUnderWrapper", "isViewOverflowingParent", "makeActive", "onHandlerStateChange", "newState", "prevState", "onTouchEvent", "recordHandlerIfNotPresent", "recordViewHandlersForPointer", "scheduleFinishedHandlersCleanup", "traverseWithPointerEvents", "tryActivate", "Companion", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: GestureHandlerOrchestrator.kt */
public final class GestureHandlerOrchestrator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DEFAULT_MIN_ALPHA_FOR_TRAVERSAL = 0.0f;
    private static final int SIMULTANEOUS_GESTURE_HANDLER_LIMIT = 20;
    private static final Comparator<GestureHandler<?>> handlersComparator = $$Lambda$GestureHandlerOrchestrator$fSJKmY0Ocyc0tAbc7K5bJo0KRmA.INSTANCE;
    /* access modifiers changed from: private */
    public static final Matrix inverseMatrix = new Matrix();
    /* access modifiers changed from: private */
    public static final float[] matrixTransformCoords = new float[2];
    private static final float[] tempCoords = new float[2];
    private static final PointF tempPoint = new PointF();
    private int activationIndex;
    private final GestureHandler<?>[] awaitingHandlers = new GestureHandler[20];
    private int awaitingHandlersCount;
    private boolean finishedHandlersCleanupScheduled;
    private final GestureHandler<?>[] gestureHandlers = new GestureHandler[20];
    private int gestureHandlersCount;
    private final GestureHandlerRegistry handlerRegistry;
    private final GestureHandler<?>[] handlersToCancel = new GestureHandler[20];
    private int handlingChangeSemaphore;
    private boolean isHandlingTouch;
    private float minimumAlphaForTraversal;
    private final GestureHandler<?>[] preparedHandlers = new GestureHandler[20];
    private final ViewConfigurationHelper viewConfigHelper;
    private final ViewGroup wrapperView;

    @Metadata(mo24975k = 3, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: GestureHandlerOrchestrator.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventsConfig.values().length];
            iArr[PointerEventsConfig.NONE.ordinal()] = 1;
            iArr[PointerEventsConfig.BOX_ONLY.ordinal()] = 2;
            iArr[PointerEventsConfig.BOX_NONE.ordinal()] = 3;
            iArr[PointerEventsConfig.AUTO.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GestureHandlerOrchestrator(ViewGroup viewGroup, GestureHandlerRegistry gestureHandlerRegistry, ViewConfigurationHelper viewConfigurationHelper) {
        Intrinsics.checkNotNullParameter(viewGroup, "wrapperView");
        Intrinsics.checkNotNullParameter(gestureHandlerRegistry, "handlerRegistry");
        Intrinsics.checkNotNullParameter(viewConfigurationHelper, "viewConfigHelper");
        this.wrapperView = viewGroup;
        this.handlerRegistry = gestureHandlerRegistry;
        this.viewConfigHelper = viewConfigurationHelper;
    }

    public final float getMinimumAlphaForTraversal() {
        return this.minimumAlphaForTraversal;
    }

    public final void setMinimumAlphaForTraversal(float f) {
        this.minimumAlphaForTraversal = f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r1 != 5) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1
            r3.isHandlingTouch = r0
            int r1 = r4.getActionMasked()
            if (r1 == 0) goto L_0x0019
            r2 = 3
            if (r1 == r2) goto L_0x0015
            r2 = 5
            if (r1 == r2) goto L_0x0019
            goto L_0x001c
        L_0x0015:
            r3.cancelAll()
            goto L_0x001c
        L_0x0019:
            r3.extractGestureHandlers(r4)
        L_0x001c:
            r3.deliverEventToGestureHandlers(r4)
            r4 = 0
            r3.isHandlingTouch = r4
            boolean r4 = r3.finishedHandlersCleanupScheduled
            if (r4 == 0) goto L_0x002d
            int r4 = r3.handlingChangeSemaphore
            if (r4 != 0) goto L_0x002d
            r3.cleanupFinishedHandlers()
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.GestureHandlerOrchestrator.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private final void scheduleFinishedHandlersCleanup() {
        if (this.isHandlingTouch || this.handlingChangeSemaphore != 0) {
            this.finishedHandlersCleanupScheduled = true;
        } else {
            cleanupFinishedHandlers();
        }
    }

    private final int compactHandlersIf(GestureHandler<?>[] gestureHandlerArr, int i, Function1<? super GestureHandler<?>, Boolean> function1) {
        int i2 = 0;
        if (i <= 0) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (function1.invoke(gestureHandlerArr[i2]).booleanValue()) {
                gestureHandlerArr[i3] = gestureHandlerArr[i2];
                i3++;
            }
            if (i4 >= i) {
                return i3;
            }
            i2 = i4;
        }
    }

    private final void cleanupFinishedHandlers() {
        int i;
        int i2 = this.gestureHandlersCount - 1;
        boolean z = false;
        if (i2 >= 0) {
            while (true) {
                int i3 = i2 - 1;
                GestureHandler<?> gestureHandler = this.gestureHandlers[i2];
                Intrinsics.checkNotNull(gestureHandler);
                if (Companion.isFinished(gestureHandler.getState()) && !gestureHandler.isAwaiting()) {
                    this.gestureHandlers[i2] = null;
                    gestureHandler.reset();
                    gestureHandler.setActive(false);
                    gestureHandler.setAwaiting(false);
                    gestureHandler.setActivationIndex(Integer.MAX_VALUE);
                    z = true;
                }
                if (i3 < 0) {
                    break;
                }
                i2 = i3;
            }
        }
        if (z) {
            GestureHandler<?>[] gestureHandlerArr = this.gestureHandlers;
            int i4 = this.gestureHandlersCount;
            if (i4 > 0) {
                int i5 = 0;
                i = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (gestureHandlerArr[i5] != null) {
                        gestureHandlerArr[i] = gestureHandlerArr[i5];
                        i++;
                    }
                    if (i6 >= i4) {
                        break;
                    }
                    i5 = i6;
                }
            } else {
                i = 0;
            }
            this.gestureHandlersCount = i;
        }
        this.finishedHandlersCleanupScheduled = false;
    }

    private final boolean hasOtherHandlerToWaitFor(GestureHandler<?> gestureHandler) {
        int i = this.gestureHandlersCount;
        if (i > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                GestureHandler<?> gestureHandler2 = this.gestureHandlers[i2];
                Intrinsics.checkNotNull(gestureHandler2);
                Companion companion = Companion;
                if (!companion.isFinished(gestureHandler2.getState()) && companion.shouldHandlerWaitForOther(gestureHandler, gestureHandler2)) {
                    return true;
                }
                if (i3 >= i) {
                    break;
                }
                i2 = i3;
            }
        }
        return false;
    }

    private final void tryActivate(GestureHandler<?> gestureHandler) {
        if (hasOtherHandlerToWaitFor(gestureHandler)) {
            addAwaitingHandler(gestureHandler);
            return;
        }
        makeActive(gestureHandler);
        gestureHandler.setAwaiting(false);
    }

    private final void cleanupAwaitingHandlers() {
        GestureHandler<?>[] gestureHandlerArr = this.awaitingHandlers;
        int i = this.awaitingHandlersCount;
        int i2 = 0;
        if (i > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                GestureHandler<?> gestureHandler = gestureHandlerArr[i2];
                Intrinsics.checkNotNull(gestureHandler);
                if (gestureHandler.isAwaiting()) {
                    gestureHandlerArr[i3] = gestureHandlerArr[i2];
                    i3++;
                }
                if (i4 >= i) {
                    break;
                }
                i2 = i4;
            }
            i2 = i3;
        }
        this.awaitingHandlersCount = i2;
    }

    public final void onHandlerStateChange(GestureHandler<?> gestureHandler, int i, int i2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        this.handlingChangeSemaphore++;
        if (Companion.isFinished(i)) {
            int i3 = this.awaitingHandlersCount;
            if (i3 > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    GestureHandler<?> gestureHandler2 = this.awaitingHandlers[i4];
                    Companion companion = Companion;
                    Intrinsics.checkNotNull(gestureHandler2);
                    if (companion.shouldHandlerWaitForOther(gestureHandler2, gestureHandler)) {
                        if (i == 5) {
                            gestureHandler2.cancel();
                            gestureHandler2.setAwaiting(false);
                        } else {
                            tryActivate(gestureHandler2);
                        }
                    }
                    if (i5 >= i3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            cleanupAwaitingHandlers();
        }
        if (i == 4) {
            tryActivate(gestureHandler);
        } else if (i2 != 4 && i2 != 5) {
            gestureHandler.dispatchStateChange(i, i2);
        } else if (gestureHandler.isActive()) {
            gestureHandler.dispatchStateChange(i, i2);
        }
        this.handlingChangeSemaphore--;
        scheduleFinishedHandlersCleanup();
    }

    private final void makeActive(GestureHandler<?> gestureHandler) {
        int i;
        int state = gestureHandler.getState();
        gestureHandler.setAwaiting(false);
        gestureHandler.setActive(true);
        int i2 = this.activationIndex;
        this.activationIndex = i2 + 1;
        gestureHandler.setActivationIndex(i2);
        int i3 = this.gestureHandlersCount;
        if (i3 > 0) {
            int i4 = 0;
            i = 0;
            while (true) {
                int i5 = i4 + 1;
                GestureHandler<?> gestureHandler2 = this.gestureHandlers[i4];
                Intrinsics.checkNotNull(gestureHandler2);
                if (Companion.shouldHandlerBeCancelledBy(gestureHandler2, gestureHandler)) {
                    this.handlersToCancel[i] = gestureHandler2;
                    i++;
                }
                if (i5 >= i3) {
                    break;
                }
                i4 = i5;
            }
        } else {
            i = 0;
        }
        int i6 = i - 1;
        if (i6 >= 0) {
            while (true) {
                int i7 = i6 - 1;
                GestureHandler<?> gestureHandler3 = this.handlersToCancel[i6];
                Intrinsics.checkNotNull(gestureHandler3);
                gestureHandler3.cancel();
                if (i7 < 0) {
                    break;
                }
                i6 = i7;
            }
        }
        int i8 = this.awaitingHandlersCount - 1;
        if (i8 >= 0) {
            while (true) {
                int i9 = i8 - 1;
                GestureHandler<?> gestureHandler4 = this.awaitingHandlers[i8];
                Intrinsics.checkNotNull(gestureHandler4);
                if (Companion.shouldHandlerBeCancelledBy(gestureHandler4, gestureHandler)) {
                    gestureHandler4.cancel();
                    gestureHandler4.setAwaiting(false);
                }
                if (i9 < 0) {
                    break;
                }
                i8 = i9;
            }
        }
        cleanupAwaitingHandlers();
        gestureHandler.dispatchStateChange(4, 2);
        if (state != 4) {
            gestureHandler.dispatchStateChange(5, 4);
            if (state != 5) {
                gestureHandler.dispatchStateChange(0, 5);
            }
        }
    }

    private final void deliverEventToGestureHandlers(MotionEvent motionEvent) {
        int i = this.gestureHandlersCount;
        int i2 = 0;
        ArraysKt.copyInto((T[]) this.gestureHandlers, (T[]) this.preparedHandlers, 0, 0, i);
        ArraysKt.sortWith(this.preparedHandlers, handlersComparator, 0, i);
        if (i > 0) {
            while (true) {
                int i3 = i2 + 1;
                GestureHandler<?> gestureHandler = this.preparedHandlers[i2];
                Intrinsics.checkNotNull(gestureHandler);
                deliverEventToGestureHandler(gestureHandler, motionEvent);
                if (i3 < i) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    private final void cancelAll() {
        int i = this.awaitingHandlersCount - 1;
        if (i >= 0) {
            while (true) {
                int i2 = i - 1;
                GestureHandler<?> gestureHandler = this.awaitingHandlers[i];
                Intrinsics.checkNotNull(gestureHandler);
                gestureHandler.cancel();
                if (i2 < 0) {
                    break;
                }
                i = i2;
            }
        }
        int i3 = this.gestureHandlersCount;
        int i4 = 0;
        if (i3 > 0) {
            while (true) {
                int i5 = i4 + 1;
                this.preparedHandlers[i4] = this.gestureHandlers[i4];
                if (i5 >= i3) {
                    break;
                }
                i4 = i5;
            }
        }
        int i6 = i3 - 1;
        if (i6 >= 0) {
            while (true) {
                int i7 = i6 - 1;
                GestureHandler<?> gestureHandler2 = this.preparedHandlers[i6];
                Intrinsics.checkNotNull(gestureHandler2);
                gestureHandler2.cancel();
                if (i7 >= 0) {
                    i6 = i7;
                } else {
                    return;
                }
            }
        }
    }

    private final void deliverEventToGestureHandler(GestureHandler<?> gestureHandler, MotionEvent motionEvent) {
        if (!isViewAttachedUnderWrapper(gestureHandler.getView())) {
            gestureHandler.cancel();
        } else if (gestureHandler.wantEvents()) {
            int actionMasked = motionEvent.getActionMasked();
            float[] fArr = tempCoords;
            extractCoordsForView(gestureHandler.getView(), motionEvent, fArr);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            motionEvent.setLocation(fArr[0], fArr[1]);
            if (gestureHandler.getNeedsPointerData()) {
                gestureHandler.updatePointerData(motionEvent);
            }
            if (!gestureHandler.isAwaiting() || actionMasked != 2) {
                gestureHandler.handle(motionEvent);
                if (gestureHandler.isActive()) {
                    gestureHandler.dispatchHandlerUpdate(motionEvent);
                }
                if (actionMasked == 1 || actionMasked == 6) {
                    gestureHandler.stopTrackingPointer(motionEvent.getPointerId(motionEvent.getActionIndex()));
                }
            }
            motionEvent.setLocation(x, y);
        }
    }

    private final boolean isViewAttachedUnderWrapper(View view) {
        if (view == null) {
            return false;
        }
        if (view == this.wrapperView) {
            return true;
        }
        ViewParent parent = view.getParent();
        while (parent != null && parent != this.wrapperView) {
            parent = parent.getParent();
        }
        if (parent == this.wrapperView) {
            return true;
        }
        return false;
    }

    private final void extractCoordsForView(View view, MotionEvent motionEvent, float[] fArr) {
        if (view == this.wrapperView) {
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
            return;
        }
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ViewParent parent = view.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            extractCoordsForView(viewGroup, motionEvent, fArr);
            PointF pointF = tempPoint;
            Companion.transformTouchPointToViewCoords(fArr[0], fArr[1], viewGroup, view, pointF);
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            return;
        }
        throw new IllegalArgumentException("Parent is null? View is no longer in the tree".toString());
    }

    private final void addAwaitingHandler(GestureHandler<?> gestureHandler) {
        int i = this.awaitingHandlersCount;
        boolean z = false;
        if (i > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (this.awaitingHandlers[i2] != gestureHandler) {
                    if (i3 >= i) {
                        break;
                    }
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
        int i4 = this.awaitingHandlersCount;
        GestureHandler<?>[] gestureHandlerArr = this.awaitingHandlers;
        if (i4 < gestureHandlerArr.length) {
            z = true;
        }
        if (z) {
            this.awaitingHandlersCount = i4 + 1;
            gestureHandlerArr[i4] = gestureHandler;
            gestureHandler.setAwaiting(true);
            int i5 = this.activationIndex;
            this.activationIndex = i5 + 1;
            gestureHandler.setActivationIndex(i5);
            return;
        }
        throw new IllegalStateException("Too many recognizers".toString());
    }

    private final void recordHandlerIfNotPresent(GestureHandler<?> gestureHandler, View view) {
        int i = this.gestureHandlersCount;
        if (i > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (this.gestureHandlers[i2] != gestureHandler) {
                    if (i3 >= i) {
                        break;
                    }
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
        int i4 = this.gestureHandlersCount;
        GestureHandler<?>[] gestureHandlerArr = this.gestureHandlers;
        if (i4 < gestureHandlerArr.length) {
            this.gestureHandlersCount = i4 + 1;
            gestureHandlerArr[i4] = gestureHandler;
            gestureHandler.setActive(false);
            gestureHandler.setAwaiting(false);
            gestureHandler.setActivationIndex(Integer.MAX_VALUE);
            gestureHandler.prepare(view, this);
            return;
        }
        throw new IllegalStateException("Too many recognizers".toString());
    }

    private final boolean isViewOverflowingParent(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return false;
        }
        Matrix matrix = view.getMatrix();
        float[] fArr = matrixTransformCoords;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        matrix.mapPoints(fArr);
        float left = fArr[0] + ((float) view.getLeft());
        float top = fArr[1] + ((float) view.getTop());
        if (left < 0.0f || left + ((float) view.getWidth()) > ((float) viewGroup.getWidth()) || top < 0.0f || top + ((float) view.getHeight()) > ((float) viewGroup.getHeight())) {
            return true;
        }
        return false;
    }

    private final boolean extractAncestorHandlers(View view, float[] fArr, int i) {
        boolean z = false;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                ArrayList<GestureHandler<?>> handlersForView = this.handlerRegistry.getHandlersForView((View) parent);
                if (handlersForView != null) {
                    Iterator<GestureHandler<?>> it = handlersForView.iterator();
                    while (it.hasNext()) {
                        GestureHandler next = it.next();
                        if (next.isEnabled() && next.isWithinBounds(view, fArr[0], fArr[1])) {
                            Intrinsics.checkNotNullExpressionValue(next, "handler");
                            recordHandlerIfNotPresent(next, viewGroup);
                            next.startTrackingPointer(i);
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private final boolean recordViewHandlersForPointer(View view, float[] fArr, int i) {
        boolean z;
        int size;
        ArrayList<GestureHandler<?>> handlersForView = this.handlerRegistry.getHandlersForView(view);
        boolean z2 = false;
        if (handlersForView != null && (size = handlersForView.size()) > 0) {
            int i2 = 0;
            z = false;
            while (true) {
                int i3 = i2 + 1;
                GestureHandler<?> gestureHandler = handlersForView.get(i2);
                Intrinsics.checkNotNullExpressionValue(gestureHandler, "it[i]");
                GestureHandler gestureHandler2 = gestureHandler;
                if (gestureHandler2.isEnabled() && gestureHandler2.isWithinBounds(view, fArr[0], fArr[1])) {
                    recordHandlerIfNotPresent(gestureHandler2, view);
                    gestureHandler2.startTrackingPointer(i);
                    z = true;
                }
                if (i3 >= size) {
                    break;
                }
                i2 = i3;
            }
        } else {
            z = false;
        }
        float width = (float) view.getWidth();
        float f = fArr[0];
        if (0.0f <= f && f <= width) {
            float height = (float) view.getHeight();
            float f2 = fArr[1];
            if (0.0f <= f2 && f2 <= height) {
                z2 = true;
            }
            if (z2 && isViewOverflowingParent(view) && extractAncestorHandlers(view, fArr, i)) {
                return true;
            }
        }
        return z;
    }

    private final void extractGestureHandlers(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float[] fArr = tempCoords;
        fArr[0] = motionEvent.getX(actionIndex);
        fArr[1] = motionEvent.getY(actionIndex);
        traverseWithPointerEvents(this.wrapperView, fArr, pointerId);
        extractGestureHandlers(this.wrapperView, fArr, pointerId);
    }

    private final boolean extractGestureHandlers(ViewGroup viewGroup, float[] fArr, int i) {
        boolean z;
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            while (true) {
                int i2 = childCount - 1;
                View childInDrawingOrderAtIndex = this.viewConfigHelper.getChildInDrawingOrderAtIndex(viewGroup, childCount);
                if (canReceiveEvents(childInDrawingOrderAtIndex)) {
                    PointF pointF = tempPoint;
                    Companion companion = Companion;
                    companion.transformTouchPointToViewCoords(fArr[0], fArr[1], viewGroup, childInDrawingOrderAtIndex, pointF);
                    float f = fArr[0];
                    float f2 = fArr[1];
                    fArr[0] = pointF.x;
                    fArr[1] = pointF.y;
                    if (!isClipping(childInDrawingOrderAtIndex) || companion.isTransformedTouchPointInView(fArr[0], fArr[1], childInDrawingOrderAtIndex)) {
                        z = traverseWithPointerEvents(childInDrawingOrderAtIndex, fArr, i);
                    } else {
                        z = false;
                    }
                    fArr[0] = f;
                    fArr[1] = f2;
                    if (z) {
                        return true;
                    }
                }
                if (i2 < 0) {
                    break;
                }
                childCount = i2;
            }
        }
        return false;
    }

    private final boolean traverseWithPointerEvents(View view, float[] fArr, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.viewConfigHelper.getPointerEventsConfigForView(view).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        boolean extractGestureHandlers = view instanceof ViewGroup ? extractGestureHandlers((ViewGroup) view, fArr, i) : false;
                        if (recordViewHandlersForPointer(view, fArr, i) || extractGestureHandlers || Companion.shouldHandlerlessViewBecomeTouchTarget(view, fArr)) {
                            return true;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (view instanceof ViewGroup) {
                    return extractGestureHandlers((ViewGroup) view, fArr, i);
                }
            } else if (recordViewHandlersForPointer(view, fArr, i) || Companion.shouldHandlerlessViewBecomeTouchTarget(view, fArr)) {
                return true;
            }
        }
        return false;
    }

    private final boolean canReceiveEvents(View view) {
        return view.getVisibility() == 0 && view.getAlpha() >= this.minimumAlphaForTraversal;
    }

    private final boolean isClipping(View view) {
        return !(view instanceof ViewGroup) || this.viewConfigHelper.isViewClippingChildren((ViewGroup) view);
    }

    @Metadata(mo24973d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001c\u001a\u00020\u00122\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J \u0010\u001f\u001a\u00020\u00122\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\rH\u0002J0\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, mo24974d2 = {"Lcom/swmansion/gesturehandler/GestureHandlerOrchestrator$Companion;", "", "()V", "DEFAULT_MIN_ALPHA_FOR_TRAVERSAL", "", "SIMULTANEOUS_GESTURE_HANDLER_LIMIT", "", "handlersComparator", "Ljava/util/Comparator;", "Lcom/swmansion/gesturehandler/GestureHandler;", "inverseMatrix", "Landroid/graphics/Matrix;", "matrixTransformCoords", "", "tempCoords", "tempPoint", "Landroid/graphics/PointF;", "canRunSimultaneously", "", "a", "b", "isFinished", "state", "isTransformedTouchPointInView", "x", "y", "child", "Landroid/view/View;", "shouldHandlerBeCancelledBy", "handler", "other", "shouldHandlerWaitForOther", "shouldHandlerlessViewBecomeTouchTarget", "view", "coords", "transformTouchPointToViewCoords", "", "parent", "Landroid/view/ViewGroup;", "outLocalPoint", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: GestureHandlerOrchestrator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isFinished(int i) {
            return i == 3 || i == 1 || i == 5;
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean shouldHandlerlessViewBecomeTouchTarget(View view, float[] fArr) {
            if (!(!(view instanceof ViewGroup) || view.getBackground() != null) || !isTransformedTouchPointInView(fArr[0], fArr[1], view)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final void transformTouchPointToViewCoords(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
            float scrollX = (f + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
            float scrollY = (f2 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
            Matrix matrix = view.getMatrix();
            if (!matrix.isIdentity()) {
                float[] access$getMatrixTransformCoords$cp = GestureHandlerOrchestrator.matrixTransformCoords;
                access$getMatrixTransformCoords$cp[0] = scrollX;
                access$getMatrixTransformCoords$cp[1] = scrollY;
                matrix.invert(GestureHandlerOrchestrator.inverseMatrix);
                GestureHandlerOrchestrator.inverseMatrix.mapPoints(access$getMatrixTransformCoords$cp);
                float f3 = access$getMatrixTransformCoords$cp[0];
                scrollY = access$getMatrixTransformCoords$cp[1];
                scrollX = f3;
            }
            pointF.set(scrollX, scrollY);
        }

        /* access modifiers changed from: private */
        public final boolean isTransformedTouchPointInView(float f, float f2, View view) {
            if (0.0f <= f && f <= ((float) view.getWidth())) {
                if (0.0f <= f2 && f2 <= ((float) view.getHeight())) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean shouldHandlerWaitForOther(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
            return gestureHandler != gestureHandler2 && (gestureHandler.shouldWaitForHandlerFailure(gestureHandler2) || gestureHandler2.shouldRequireToWaitForFailure(gestureHandler));
        }

        private final boolean canRunSimultaneously(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
            return gestureHandler == gestureHandler2 || gestureHandler.shouldRecognizeSimultaneously(gestureHandler2) || gestureHandler2.shouldRecognizeSimultaneously(gestureHandler);
        }

        /* access modifiers changed from: private */
        public final boolean shouldHandlerBeCancelledBy(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
            if (!gestureHandler.hasCommonPointers(gestureHandler2) || canRunSimultaneously(gestureHandler, gestureHandler2)) {
                return false;
            }
            if (gestureHandler == gestureHandler2 || (!gestureHandler.isAwaiting() && gestureHandler.getState() != 4)) {
                return true;
            }
            return gestureHandler.shouldBeCancelledBy(gestureHandler2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlersComparator$lambda-10  reason: not valid java name */
    public static final int m202handlersComparator$lambda10(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        if ((gestureHandler.isActive() && gestureHandler2.isActive()) || (gestureHandler.isAwaiting() && gestureHandler2.isAwaiting())) {
            return Integer.signum(gestureHandler2.getActivationIndex() - gestureHandler.getActivationIndex());
        }
        if (!gestureHandler.isActive()) {
            if (gestureHandler2.isActive()) {
                return 1;
            }
            if (!gestureHandler.isAwaiting()) {
                if (gestureHandler2.isAwaiting()) {
                    return 1;
                }
                return 0;
            }
        }
        return -1;
    }
}
