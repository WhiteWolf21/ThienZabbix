package com.facebook.react.views.modal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.C0873R;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.common.ContextUtils;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;

public class ReactModalHostView extends ViewGroup implements LifecycleEventListener, FabricViewStateManager.HasFabricViewStateManager {
    private String mAnimationType;
    private Dialog mDialog;
    private boolean mHardwareAccelerated;
    private DialogRootViewGroup mHostView;
    /* access modifiers changed from: private */
    public OnRequestCloseListener mOnRequestCloseListener;
    private DialogInterface.OnShowListener mOnShowListener;
    private boolean mPropertyRequiresNewDialog;
    private boolean mStatusBarTranslucent;
    private boolean mTransparent;

    public interface OnRequestCloseListener {
        void onRequestClose(DialogInterface dialogInterface);
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void onHostPause() {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ReactModalHostView(Context context) {
        super(context);
        ((ReactContext) context).addLifecycleEventListener(this);
        this.mHostView = new DialogRootViewGroup(context);
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
        this.mHostView.dispatchProvideStructure(viewStructure);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismiss();
    }

    public void addView(View view, int i) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.addView(view, i);
    }

    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    public View getChildAt(int i) {
        return this.mHostView.getChildAt(i);
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(view);
    }

    public void removeViewAt(int i) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(getChildAt(i));
    }

    public void onDropInstance() {
        ((ReactContext) getContext()).removeLifecycleEventListener(this);
        dismiss();
    }

    private void dismiss() {
        Activity activity;
        UiThreadUtil.assertOnUiThread();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            if (dialog.isShowing() && ((activity = (Activity) ContextUtils.findContextOfType(this.mDialog.getContext(), Activity.class)) == null || !activity.isFinishing())) {
                this.mDialog.dismiss();
            }
            this.mDialog = null;
            ((ViewGroup) this.mHostView.getParent()).removeViewAt(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setOnRequestCloseListener(OnRequestCloseListener onRequestCloseListener) {
        this.mOnRequestCloseListener = onRequestCloseListener;
    }

    /* access modifiers changed from: protected */
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    /* access modifiers changed from: protected */
    public void setTransparent(boolean z) {
        this.mTransparent = z;
    }

    /* access modifiers changed from: protected */
    public void setStatusBarTranslucent(boolean z) {
        this.mStatusBarTranslucent = z;
        this.mPropertyRequiresNewDialog = true;
    }

    /* access modifiers changed from: protected */
    public void setAnimationType(String str) {
        this.mAnimationType = str;
        this.mPropertyRequiresNewDialog = true;
    }

    /* access modifiers changed from: protected */
    public void setHardwareAccelerated(boolean z) {
        this.mHardwareAccelerated = z;
        this.mPropertyRequiresNewDialog = true;
    }

    public void onHostResume() {
        showOrUpdate();
    }

    public void onHostDestroy() {
        onDropInstance();
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    private Activity getCurrentActivity() {
        return ((ReactContext) getContext()).getCurrentActivity();
    }

    /* access modifiers changed from: protected */
    public void showOrUpdate() {
        UiThreadUtil.assertOnUiThread();
        if (this.mDialog != null) {
            if (this.mPropertyRequiresNewDialog) {
                dismiss();
            } else {
                updateProperties();
                return;
            }
        }
        this.mPropertyRequiresNewDialog = false;
        int i = C0873R.style.Theme_FullScreenDialog;
        if (this.mAnimationType.equals("fade")) {
            i = C0873R.style.Theme_FullScreenDialogAnimatedFade;
        } else if (this.mAnimationType.equals("slide")) {
            i = C0873R.style.Theme_FullScreenDialogAnimatedSlide;
        }
        Activity currentActivity = getCurrentActivity();
        Context context = currentActivity == null ? getContext() : currentActivity;
        Dialog dialog = new Dialog(context, i);
        this.mDialog = dialog;
        dialog.getWindow().setFlags(8, 8);
        this.mDialog.setContentView(getContentView());
        updateProperties();
        this.mDialog.setOnShowListener(this.mOnShowListener);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1) {
                    return false;
                }
                if (i == 4) {
                    Assertions.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
                    ReactModalHostView.this.mOnRequestCloseListener.onRequestClose(dialogInterface);
                    return true;
                }
                Activity currentActivity = ((ReactContext) ReactModalHostView.this.getContext()).getCurrentActivity();
                if (currentActivity != null) {
                    return currentActivity.onKeyUp(i, keyEvent);
                }
                return false;
            }
        });
        this.mDialog.getWindow().setSoftInputMode(16);
        if (this.mHardwareAccelerated) {
            this.mDialog.getWindow().addFlags(16777216);
        }
        if (currentActivity != null && !currentActivity.isFinishing()) {
            this.mDialog.show();
            if (context instanceof Activity) {
                this.mDialog.getWindow().getDecorView().setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.mDialog.getWindow().clearFlags(8);
        }
    }

    private View getContentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mHostView);
        if (this.mStatusBarTranslucent) {
            frameLayout.setSystemUiVisibility(1024);
        } else {
            frameLayout.setFitsSystemWindows(true);
        }
        return frameLayout;
    }

    private void updateProperties() {
        Assertions.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
        Activity currentActivity = getCurrentActivity();
        Window window = this.mDialog.getWindow();
        if (currentActivity != null && !currentActivity.isFinishing() && window.isActive()) {
            if ((currentActivity.getWindow().getAttributes().flags & 1024) != 0) {
                window.addFlags(1024);
            } else {
                window.clearFlags(1024);
            }
            if (this.mTransparent) {
                window.clearFlags(2);
                return;
            }
            window.setDimAmount(0.5f);
            window.setFlags(2, 2);
        }
    }

    public FabricViewStateManager getFabricViewStateManager() {
        return this.mHostView.getFabricViewStateManager();
    }

    public void updateState(int i, int i2) {
        this.mHostView.updateState(i, i2);
    }

    static class DialogRootViewGroup extends ReactViewGroup implements RootView, FabricViewStateManager.HasFabricViewStateManager {
        private boolean hasAdjustedSize = false;
        private final FabricViewStateManager mFabricViewStateManager = new FabricViewStateManager();
        private final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);
        /* access modifiers changed from: private */
        public int viewHeight;
        /* access modifiers changed from: private */
        public int viewWidth;

        public void requestDisallowInterceptTouchEvent(boolean z) {
        }

        public DialogRootViewGroup(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.viewWidth = i;
            this.viewHeight = i2;
            updateFirstChildView();
        }

        private void updateFirstChildView() {
            if (getChildCount() > 0) {
                this.hasAdjustedSize = false;
                final int id = getChildAt(0).getId();
                if (this.mFabricViewStateManager.hasStateWrapper()) {
                    updateState(this.viewWidth, this.viewHeight);
                    return;
                }
                ReactContext reactContext = getReactContext();
                reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                    public void runGuarded() {
                        UIManagerModule uIManagerModule = (UIManagerModule) DialogRootViewGroup.this.getReactContext().getNativeModule(UIManagerModule.class);
                        if (uIManagerModule != null) {
                            uIManagerModule.updateNodeSize(id, DialogRootViewGroup.this.viewWidth, DialogRootViewGroup.this.viewHeight);
                        }
                    }
                });
                return;
            }
            this.hasAdjustedSize = true;
        }

        public void updateState(int i, int i2) {
            final float dIPFromPixel = PixelUtil.toDIPFromPixel((float) i);
            final float dIPFromPixel2 = PixelUtil.toDIPFromPixel((float) i2);
            ReadableMap state = getFabricViewStateManager().getState();
            if (state != null) {
                float f = 0.0f;
                float f2 = state.hasKey("screenHeight") ? (float) state.getDouble("screenHeight") : 0.0f;
                if (state.hasKey("screenWidth")) {
                    f = (float) state.getDouble("screenWidth");
                }
                if (Math.abs(f - dIPFromPixel) < 0.9f && Math.abs(f2 - dIPFromPixel2) < 0.9f) {
                    return;
                }
            }
            this.mFabricViewStateManager.setState(new FabricViewStateManager.StateUpdateCallback() {
                public WritableMap getStateUpdate() {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("screenWidth", (double) dIPFromPixel);
                    writableNativeMap.putDouble("screenHeight", (double) dIPFromPixel2);
                    return writableNativeMap;
                }
            });
        }

        public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
            super.addView(view, i, layoutParams);
            if (this.hasAdjustedSize) {
                updateFirstChildView();
            }
        }

        public void handleException(Throwable th) {
            getReactContext().handleException(new RuntimeException(th));
        }

        /* access modifiers changed from: private */
        public ReactContext getReactContext() {
            return (ReactContext) getContext();
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            super.onTouchEvent(motionEvent);
            return true;
        }

        public void onChildStartedNativeGesture(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, getEventDispatcher());
        }

        private EventDispatcher getEventDispatcher() {
            return ((UIManagerModule) getReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public FabricViewStateManager getFabricViewStateManager() {
            return this.mFabricViewStateManager;
        }
    }
}
