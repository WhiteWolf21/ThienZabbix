package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.ViewAtIndex;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ReanimatedNativeHierarchyManager extends NativeViewHierarchyManager {
    private HashMap<Integer, Runnable> cleanerCallback = new HashMap<>();
    private HashMap<Integer, Set<Integer>> mPendingDeletionsForTag = null;
    private LayoutAnimationController mReaLayoutAnimator = null;
    private HashMap<Integer, ArrayList<View>> toBeRemoved = new HashMap<>();

    public ReanimatedNativeHierarchyManager(ViewManagerRegistry viewManagerRegistry, ReactApplicationContext reactApplicationContext) {
        super(viewManagerRegistry);
        Class<? super Object> superclass = getClass().getSuperclass();
        try {
            Field declaredField = superclass.getDeclaredField("mLayoutAnimator");
            declaredField.setAccessible(true);
            Field declaredField2 = Field.class.getDeclaredField("accessFlags");
            declaredField2.setAccessible(true);
            declaredField2.setInt(declaredField, declaredField.getModifiers() & -17);
            ReaLayoutAnimator reaLayoutAnimator = new ReaLayoutAnimator(reactApplicationContext, this);
            this.mReaLayoutAnimator = reaLayoutAnimator;
            declaredField.set(this, reaLayoutAnimator);
            Field declaredField3 = superclass.getDeclaredField("mPendingDeletionsForTag");
            declaredField3.setAccessible(true);
            Field declaredField4 = Field.class.getDeclaredField("accessFlags");
            declaredField4.setAccessible(true);
            declaredField4.setInt(declaredField, declaredField.getModifiers() & -17);
            HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
            this.mPendingDeletionsForTag = hashMap;
            declaredField3.set(this, hashMap);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        setLayoutAnimationEnabled(true);
    }

    public ReanimatedNativeHierarchyManager(ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager) {
        super(viewManagerRegistry, rootViewManager);
    }

    public synchronized void updateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        LayoutAnimationController layoutAnimationController;
        super.updateLayout(i, i2, i3, i4, i5, i6);
        if (((ReaLayoutAnimator) this.mReaLayoutAnimator).isLayoutAnimationEnabled()) {
            try {
                View resolveView = resolveView(i2);
                String name = resolveViewManager(i2).getName();
                View resolveView2 = resolveView(i);
                if (!(resolveView2 == null || !name.equals(ScreenViewManager.REACT_CLASS) || (layoutAnimationController = this.mReaLayoutAnimator) == null)) {
                    layoutAnimationController.applyLayoutUpdate(resolveView, (int) resolveView2.getX(), (int) resolveView2.getY(), resolveView2.getWidth(), resolveView2.getHeight());
                }
            } catch (IllegalViewOperationException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void manageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        Set set;
        ArrayList arrayList;
        int i2 = i;
        int[] iArr3 = iArr2;
        synchronized (this) {
            if (!((ReaLayoutAnimator) this.mReaLayoutAnimator).isLayoutAnimationEnabled()) {
                super.manageChildren(i, iArr, viewAtIndexArr, iArr2);
                return;
            }
            try {
                ViewGroup viewGroup = (ViewGroup) resolveView(i);
                ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
                if (viewGroupManager.getName().equals(ScreenStackViewManager.REACT_CLASS)) {
                    super.manageChildren(i, iArr, viewAtIndexArr, iArr2);
                    return;
                }
                if (this.toBeRemoved.containsKey(Integer.valueOf(i))) {
                    HashSet hashSet = new HashSet();
                    Iterator it = this.toBeRemoved.get(Integer.valueOf(i)).iterator();
                    while (it.hasNext()) {
                        hashSet.add(Integer.valueOf(((View) it.next()).getId()));
                    }
                    while (viewGroupManager.getChildCount(viewGroup) != 0 && hashSet.contains(Integer.valueOf(viewGroupManager.getChildAt(viewGroup, viewGroupManager.getChildCount(viewGroup) - 1).getId()))) {
                        viewGroupManager.removeViewAt(viewGroup, viewGroupManager.getChildCount(viewGroup) - 1);
                    }
                }
                if (iArr3 != null) {
                    if (!this.toBeRemoved.containsKey(Integer.valueOf(i))) {
                        this.toBeRemoved.put(Integer.valueOf(i), new ArrayList());
                    }
                    ArrayList arrayList2 = this.toBeRemoved.get(Integer.valueOf(i));
                    int length = iArr3.length;
                    int i3 = 0;
                    while (i3 < length) {
                        try {
                            final View resolveView = resolveView(Integer.valueOf(iArr3[i3]).intValue());
                            arrayList2.add(resolveView);
                            HashMap<Integer, Runnable> hashMap = this.cleanerCallback;
                            Integer valueOf = Integer.valueOf(resolveView.getId());
                            final ArrayList arrayList3 = arrayList2;
                            final ViewGroupManager viewGroupManager2 = viewGroupManager;
                            arrayList = arrayList2;
                            C16231 r12 = r1;
                            final ViewGroup viewGroup2 = viewGroup;
                            C16231 r1 = new Runnable() {
                                public void run() {
                                    arrayList3.remove(resolveView);
                                    viewGroupManager2.removeView(viewGroup2, resolveView);
                                }
                            };
                            hashMap.put(valueOf, r12);
                        } catch (IllegalViewOperationException e) {
                            arrayList = arrayList2;
                            e.printStackTrace();
                        }
                        i3++;
                        arrayList2 = arrayList;
                    }
                }
                HashMap<Integer, Set<Integer>> hashMap2 = this.mPendingDeletionsForTag;
                if (!(hashMap2 == null || (set = hashMap2.get(Integer.valueOf(i))) == null)) {
                    set.clear();
                }
                super.manageChildren(i2, iArr, viewAtIndexArr, (int[]) null);
                if (this.toBeRemoved.containsKey(Integer.valueOf(i))) {
                    Iterator it2 = this.toBeRemoved.get(Integer.valueOf(i)).iterator();
                    while (it2.hasNext()) {
                        viewGroupManager.addView(viewGroup, (View) it2.next(), viewGroupManager.getChildCount(viewGroup));
                    }
                }
                super.manageChildren(i2, (int[]) null, (ViewAtIndex[]) null, iArr3);
            } catch (IllegalViewOperationException e2) {
                int[] iArr4 = iArr;
                ViewAtIndex[] viewAtIndexArr2 = viewAtIndexArr;
                e2.printStackTrace();
                super.manageChildren(i, iArr, viewAtIndexArr, iArr2);
            }
        }
    }

    public void publicDropView(View view) {
        dropView(view);
    }

    /* access modifiers changed from: protected */
    public synchronized void dropView(View view) {
        if (!((ReaLayoutAnimator) this.mReaLayoutAnimator).isLayoutAnimationEnabled()) {
            super.dropView(view);
            return;
        }
        if (this.toBeRemoved.containsKey(Integer.valueOf(view.getId()))) {
            this.toBeRemoved.remove(Integer.valueOf(view.getId()));
        }
        if (this.cleanerCallback.containsKey(Integer.valueOf(view.getId()))) {
            this.cleanerCallback.remove(Integer.valueOf(view.getId()));
            this.cleanerCallback.get(Integer.valueOf(view.getId())).run();
        }
        super.dropView(view);
    }
}
