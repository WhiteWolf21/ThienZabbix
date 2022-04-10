package com.swmansion.reanimated.layoutReanimation;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.swmansion.reanimated.Scheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class AnimationsManager implements ViewHierarchyObserver {
    private static final String[] LAYOUT_KEYS = {Snapshot.ORIGIN_X, Snapshot.ORIGIN_Y, "width", "height"};
    private boolean isCatalystInstanceDestroyed = false;
    private HashMap<Integer, Runnable> mCallbacks;
    private boolean mCleaningScheduled = false;
    private ReactContext mContext;
    private NativeMethodsHolder mNativeMethodsHolder;
    private HashMap<Integer, View> mParent;
    private HashMap<Integer, ViewManager> mParentViewManager;
    private ReanimatedNativeHierarchyManager mReanimatedNativeHierarchyManager;
    private WeakReference<Scheduler> mScheduler;
    private HashMap<Integer, ViewState> mStates;
    private HashSet<Integer> mToRemove;
    private UIImplementation mUIImplementation;
    private UIManagerModule mUIManager;
    private HashMap<Integer, View> mViewForTag;
    private HashMap<Integer, ViewManager> mViewManager;

    public enum ViewState {
        Appearing,
        Disappearing,
        Layout,
        Inactive,
        ToRemove
    }

    public void setReanimatedNativeHierarchyManager(ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager) {
        this.mReanimatedNativeHierarchyManager = reanimatedNativeHierarchyManager;
    }

    public ReanimatedNativeHierarchyManager getReanimatedNativeHierarchyManager() {
        return this.mReanimatedNativeHierarchyManager;
    }

    public void setScheduler(Scheduler scheduler) {
        this.mScheduler = new WeakReference<>(scheduler);
    }

    public AnimationsManager(ReactContext reactContext, UIImplementation uIImplementation, UIManagerModule uIManagerModule) {
        this.mContext = reactContext;
        this.mUIImplementation = uIImplementation;
        this.mUIManager = uIManagerModule;
        this.mStates = new HashMap<>();
        this.mViewForTag = new HashMap<>();
        this.mToRemove = new HashSet<>();
        this.mViewManager = new HashMap<>();
        this.mParentViewManager = new HashMap<>();
        this.mParent = new HashMap<>();
        this.mCallbacks = new HashMap<>();
        this.isCatalystInstanceDestroyed = false;
    }

    public void onCatalystInstanceDestroy() {
        this.isCatalystInstanceDestroyed = true;
        this.mNativeMethodsHolder = null;
        this.mContext = null;
        this.mUIImplementation = null;
        this.mUIManager = null;
        this.mStates = null;
        this.mToRemove = null;
        this.mViewForTag = null;
        this.mViewManager = null;
        this.mParent = null;
        this.mParentViewManager = null;
        this.mCallbacks = null;
    }

    public void onViewRemoval(View view, ViewGroup viewGroup, Snapshot snapshot, Runnable runnable) {
        if (!this.isCatalystInstanceDestroyed) {
            Integer valueOf = Integer.valueOf(view.getId());
            HashMap<String, Object> currentMap = snapshot.toCurrentMap();
            ViewState viewState = this.mStates.get(Integer.valueOf(view.getId()));
            if (viewState != null && viewState != ViewState.Disappearing && viewState != ViewState.ToRemove) {
                this.mCallbacks.put(valueOf, runnable);
                if (viewState != ViewState.Inactive) {
                    this.mStates.put(valueOf, ViewState.Disappearing);
                    this.mNativeMethodsHolder.startAnimationForTag(valueOf.intValue(), "exiting", prepareDataForAnimationWorklet(currentMap, false));
                } else if (currentMap != null) {
                    this.mStates.put(Integer.valueOf(view.getId()), ViewState.ToRemove);
                    this.mToRemove.add(Integer.valueOf(view.getId()));
                    scheduleCleaning();
                }
            }
        }
    }

    public void onViewCreate(View view, ViewGroup viewGroup, Snapshot snapshot) {
        if (!this.isCatalystInstanceDestroyed) {
            Scheduler scheduler = (Scheduler) this.mScheduler.get();
            if (scheduler != null) {
                scheduler.triggerUI();
            }
            if (!this.mStates.containsKey(Integer.valueOf(view.getId()))) {
                this.mStates.put(Integer.valueOf(view.getId()), ViewState.Inactive);
                this.mViewForTag.put(Integer.valueOf(view.getId()), view);
                this.mViewManager.put(Integer.valueOf(view.getId()), snapshot.viewManager);
                this.mParentViewManager.put(Integer.valueOf(view.getId()), snapshot.parentViewManager);
                this.mParent.put(Integer.valueOf(view.getId()), snapshot.parent);
            }
            Integer valueOf = Integer.valueOf(view.getId());
            HashMap<String, Object> targetMap = snapshot.toTargetMap();
            if (this.mStates.get(Integer.valueOf(view.getId())) == ViewState.Inactive && targetMap != null) {
                this.mNativeMethodsHolder.startAnimationForTag(valueOf.intValue(), "entering", prepareDataForAnimationWorklet(targetMap, true));
            }
        }
    }

    public void onViewUpdate(View view, Snapshot snapshot, Snapshot snapshot2) {
        if (!this.isCatalystInstanceDestroyed) {
            Integer valueOf = Integer.valueOf(view.getId());
            HashMap<String, Object> targetMap = snapshot2.toTargetMap();
            HashMap<String, Object> currentMap = snapshot.toCurrentMap();
            ViewState viewState = this.mStates.get(Integer.valueOf(view.getId()));
            if (viewState != null && viewState != ViewState.Disappearing && viewState != ViewState.ToRemove && viewState != ViewState.Inactive) {
                if (viewState == ViewState.Appearing) {
                    boolean z = true;
                    for (int i = 0; i < Snapshot.targetKeysToTransform.size(); i++) {
                        if (((Number) currentMap.get(Snapshot.currentKeysToTransform.get(i))).doubleValue() != ((Number) targetMap.get(Snapshot.targetKeysToTransform.get(i))).doubleValue()) {
                            z = false;
                        }
                    }
                    if (z) {
                        return;
                    }
                }
                this.mStates.put(Integer.valueOf(view.getId()), ViewState.Layout);
                HashMap<String, Float> prepareDataForAnimationWorklet = prepareDataForAnimationWorklet(currentMap, false);
                HashMap hashMap = new HashMap(prepareDataForAnimationWorklet(targetMap, true));
                for (String next : prepareDataForAnimationWorklet.keySet()) {
                    hashMap.put(next, prepareDataForAnimationWorklet.get(next));
                }
                this.mNativeMethodsHolder.startAnimationForTag(valueOf.intValue(), "layout", hashMap);
            }
        }
    }

    public void notifyAboutProgress(Map<String, Object> map, Integer num) {
        if (this.mStates.get(num) == ViewState.Inactive) {
            this.mStates.put(num, ViewState.Appearing);
        }
        setNewProps(map, this.mViewForTag.get(num), this.mViewManager.get(num), this.mParentViewManager.get(num), Integer.valueOf(this.mParent.get(num).getId()));
    }

    public void notifyAboutEnd(int i, boolean z) {
        if (!z) {
            ViewState viewState = this.mStates.get(Integer.valueOf(i));
            if (viewState == ViewState.Appearing) {
                this.mStates.put(Integer.valueOf(i), ViewState.Layout);
            }
            if (viewState == ViewState.Disappearing) {
                this.mStates.put(Integer.valueOf(i), ViewState.ToRemove);
                this.mToRemove.add(Integer.valueOf(i));
                scheduleCleaning();
            }
        }
    }

    private void removeLeftovers() {
        HashSet hashSet = new HashSet();
        Iterator<Integer> it = this.mToRemove.iterator();
        while (it.hasNext()) {
            findRoot(this.mViewForTag.get(Integer.valueOf(it.next().intValue())), hashSet);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            View view = this.mViewForTag.get(Integer.valueOf(((Integer) it2.next()).intValue()));
            if (view != null) {
                dfs(view, view, this.mToRemove);
            }
        }
    }

    public void printSubTree(View view, int i) {
        if (i == 0) {
            Log.v("rea", "----------------------");
        }
        if (view != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append("+");
            }
            sb.append(" TAG:");
            sb.append(view.getId());
            sb.append(" STATE:");
            sb.append(this.mStates.get(Integer.valueOf(view.getId())));
            sb.append(" CLASS:");
            sb.append(view.getClass().getSimpleName());
            Log.v("rea", sb.toString());
            if (view instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i2 < viewGroup.getChildCount()) {
                        printSubTree(viewGroup.getChildAt(i2), i + 1);
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void scheduleCleaning() {
        if (!this.mCleaningScheduled) {
            this.mCleaningScheduled = true;
            this.mContext.runOnUiQueueThread(new Runnable(new WeakReference(this)) {
                public final /* synthetic */ WeakReference f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AnimationsManager.this.lambda$scheduleCleaning$0$AnimationsManager(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$scheduleCleaning$0$AnimationsManager(WeakReference weakReference) {
        this.mCleaningScheduled = false;
        if (((AnimationsManager) weakReference.get()) != null) {
            removeLeftovers();
        }
    }

    private void findRoot(View view, HashSet<Integer> hashSet) {
        int i = -1;
        while (view != null) {
            ViewState viewState = this.mStates.get(Integer.valueOf(view.getId()));
            if (viewState != ViewState.Disappearing) {
                if (viewState == ViewState.ToRemove) {
                    i = view.getId();
                }
                if (!(view.getParent() instanceof View)) {
                    break;
                }
                view = (View) view.getParent();
            } else {
                return;
            }
        }
        if (i != -1) {
            hashSet.add(Integer.valueOf(i));
        }
    }

    private boolean dfs(View view, View view2, HashSet<Integer> hashSet) {
        ViewGroup viewGroup;
        boolean z;
        if (!hashSet.contains(Integer.valueOf(view2.getId())) && this.mStates.containsKey(Integer.valueOf(view2.getId()))) {
            return true;
        }
        boolean z2 = false;
        if ((view2 instanceof ViewGroup) && (this.mViewManager.get(Integer.valueOf(view2.getId())) instanceof ViewGroupManager)) {
            ViewGroup viewGroup2 = (ViewGroup) view2;
            ViewGroupManager viewGroupManager = (ViewGroupManager) this.mViewManager.get(Integer.valueOf(viewGroup2.getId()));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < viewGroupManager.getChildCount(viewGroup2); i++) {
                arrayList.add(viewGroupManager.getChildAt(viewGroup2, i));
            }
            Iterator it = arrayList.iterator();
            loop1:
            while (true) {
                z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop1;
                    }
                    View view3 = (View) it.next();
                    if (z || dfs(view, view3, hashSet)) {
                        z = true;
                    }
                }
            }
            z2 = z;
        }
        if (!z2) {
            View view4 = (View) view2.getParent();
            if (this.mCallbacks.containsKey(Integer.valueOf(view2.getId()))) {
                this.mCallbacks.remove(Integer.valueOf(view2.getId()));
                this.mCallbacks.get(Integer.valueOf(view2.getId())).run();
            }
            if (this.mParent.containsKey(Integer.valueOf(view2.getId())) && (viewGroup = (ViewGroup) this.mParent.get(Integer.valueOf(view2.getId()))) != null) {
                viewGroup.removeView(view2);
            }
            this.mStates.remove(Integer.valueOf(view2.getId()));
            this.mViewForTag.remove(Integer.valueOf(view2.getId()));
            this.mViewManager.remove(Integer.valueOf(view2.getId()));
            this.mParentViewManager.remove(Integer.valueOf(view2.getId()));
            this.mParent.remove(Integer.valueOf(view2.getId()));
            this.mNativeMethodsHolder.removeConfigForTag(view2.getId());
            this.mToRemove.remove(Integer.valueOf(view2.getId()));
        }
        return z2;
    }

    public HashMap<String, Float> prepareDataForAnimationWorklet(HashMap<String, Object> hashMap, boolean z) {
        ArrayList<String> arrayList;
        HashMap<String, Float> hashMap2 = new HashMap<>();
        if (z) {
            arrayList = Snapshot.targetKeysToTransform;
        } else {
            arrayList = Snapshot.currentKeysToTransform;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            hashMap2.put(next, Float.valueOf(PixelUtil.toDIPFromPixel((float) ((Integer) hashMap.get(next)).intValue())));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mContext.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        hashMap2.put("windowWidth", Float.valueOf(PixelUtil.toDIPFromPixel((float) displayMetrics.widthPixels)));
        hashMap2.put("windowHeight", Float.valueOf(PixelUtil.toDIPFromPixel((float) i)));
        return hashMap2;
    }

    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
    }

    public void setNewProps(Map<String, Object> map, View view, ViewManager viewManager, ViewManager viewManager2, Integer num) {
        float f;
        float f2;
        float f3;
        float f4;
        Map<String, Object> map2 = map;
        if (map.get(Snapshot.ORIGIN_X) != null) {
            f = ((Double) map.get(Snapshot.ORIGIN_X)).floatValue();
        } else {
            f = PixelUtil.toDIPFromPixel((float) view.getLeft());
        }
        float f5 = f;
        if (map.get(Snapshot.ORIGIN_Y) != null) {
            f2 = ((Double) map.get(Snapshot.ORIGIN_Y)).floatValue();
        } else {
            f2 = PixelUtil.toDIPFromPixel((float) view.getTop());
        }
        float f6 = f2;
        if (map.get("width") != null) {
            f3 = ((Double) map.get("width")).floatValue();
        } else {
            f3 = PixelUtil.toDIPFromPixel((float) view.getWidth());
        }
        float f7 = f3;
        if (map.get("height") != null) {
            f4 = ((Double) map.get("height")).floatValue();
        } else {
            f4 = PixelUtil.toDIPFromPixel((float) view.getHeight());
        }
        float f8 = f4;
        updateLayout(view, viewManager2, num.intValue(), view.getId(), f5, f6, f7, f8);
        map.remove(Snapshot.ORIGIN_X);
        map.remove(Snapshot.ORIGIN_Y);
        map.remove("width");
        map.remove("height");
        if (map.size() != 0) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            for (String next : map.keySet()) {
                addProp(javaOnlyMap, next, map.get(next));
            }
            ViewManager viewManager3 = viewManager;
            viewManager3.updateProperties(view, new ReactStylesDiffMap(javaOnlyMap));
        }
    }

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof ReadableArray) {
            writableMap.putArray(str, (ReadableArray) obj);
        } else if (obj instanceof ReadableMap) {
            writableMap.putMap(str, (ReadableMap) obj);
        } else {
            throw new IllegalStateException("Unknown type of animated value [Layout Aniamtions]");
        }
    }

    public void updateLayout(View view, ViewManager viewManager, int i, int i2, float f, float f2, float f3, float f4) {
        int round = Math.round(PixelUtil.toPixelFromDIP(f));
        int round2 = Math.round(PixelUtil.toPixelFromDIP(f2));
        int round3 = Math.round(PixelUtil.toPixelFromDIP(f3));
        int round4 = Math.round(PixelUtil.toPixelFromDIP(f4));
        view.measure(View.MeasureSpec.makeMeasureSpec(round3, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(round4, BasicMeasure.EXACTLY));
        ViewParent parent = view.getParent();
        if (parent instanceof RootView) {
            parent.requestLayout();
        }
        if (i % 10 != 1) {
            view.layout(round, round2, round3 + round, round4 + round2);
        } else if (viewManager instanceof IViewManagerWithChildren) {
            IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) viewManager;
            if (iViewManagerWithChildren != null && !iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                view.layout(round, round2, round3 + round, round4 + round2);
            }
        } else {
            throw new IllegalViewOperationException("Trying to use view with tag " + i + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
        }
    }

    public boolean isLayoutAnimationEnabled() {
        return this.mNativeMethodsHolder.isLayoutAnimationEnabled();
    }
}
