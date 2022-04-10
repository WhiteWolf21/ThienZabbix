package com.swmansion.rnscreens;

import android.content.Context;
import android.view.ViewParent;
import androidx.appcompat.widget.SearchView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002CDB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\fH\u0002J\b\u00105\u001a\u000202H\u0002J\u0012\u00106\u001a\u0002022\b\u00107\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u00108\u001a\u0002022\b\u00107\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u00109\u001a\u000202H\u0014J\u0006\u0010:\u001a\u000202J\u001a\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020\u001b2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u000202H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010!8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010.\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,¨\u0006E"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchBarView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "autoCapitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "getAutoCapitalize", "()Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "setAutoCapitalize", "(Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;)V", "autoFocus", "", "getAutoFocus", "()Z", "setAutoFocus", "(Z)V", "inputType", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "getInputType", "()Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "setInputType", "(Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;)V", "mAreListenersSet", "mSearchViewFormatter", "Lcom/swmansion/rnscreens/SearchViewFormatter;", "placeholder", "", "getPlaceholder", "()Ljava/lang/String;", "setPlaceholder", "(Ljava/lang/String;)V", "screenStackFragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "getScreenStackFragment", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "shouldOverrideBackButton", "getShouldOverrideBackButton", "setShouldOverrideBackButton", "textColor", "", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tintColor", "getTintColor", "setTintColor", "handleClose", "", "handleFocusChange", "hasFocus", "handleOpen", "handleTextChange", "newText", "handleTextSubmit", "onAttachedToWindow", "onUpdate", "sendEvent", "eventName", "eventContent", "Lcom/facebook/react/bridge/WritableMap;", "setSearchViewListeners", "searchView", "Landroidx/appcompat/widget/SearchView;", "setSearchViewProps", "SearchBarAutoCapitalize", "SearchBarInputTypes", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
/* compiled from: SearchBarView.kt */
public final class SearchBarView extends ReactViewGroup {
    private SearchBarAutoCapitalize autoCapitalize = SearchBarAutoCapitalize.NONE;
    private boolean autoFocus;
    private SearchBarInputTypes inputType = SearchBarInputTypes.TEXT;
    private boolean mAreListenersSet;
    /* access modifiers changed from: private */
    public SearchViewFormatter mSearchViewFormatter;
    private String placeholder;
    private boolean shouldOverrideBackButton = true;
    private Integer textColor;
    private Integer tintColor;

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "", "(Ljava/lang/String;I)V", "NONE", "WORDS", "SENTENCES", "CHARACTERS", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: SearchBarView.kt */
    public enum SearchBarAutoCapitalize {
        NONE,
        WORDS,
        SENTENCES,
        CHARACTERS
    }

    public SearchBarView(ReactContext reactContext) {
        super(reactContext);
    }

    public final SearchBarInputTypes getInputType() {
        return this.inputType;
    }

    public final void setInputType(SearchBarInputTypes searchBarInputTypes) {
        Intrinsics.checkNotNullParameter(searchBarInputTypes, "<set-?>");
        this.inputType = searchBarInputTypes;
    }

    public final SearchBarAutoCapitalize getAutoCapitalize() {
        return this.autoCapitalize;
    }

    public final void setAutoCapitalize(SearchBarAutoCapitalize searchBarAutoCapitalize) {
        Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "<set-?>");
        this.autoCapitalize = searchBarAutoCapitalize;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(Integer num) {
        this.textColor = num;
    }

    public final Integer getTintColor() {
        return this.tintColor;
    }

    public final void setTintColor(Integer num) {
        this.tintColor = num;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(String str) {
        this.placeholder = str;
    }

    public final boolean getShouldOverrideBackButton() {
        return this.shouldOverrideBackButton;
    }

    public final void setShouldOverrideBackButton(boolean z) {
        this.shouldOverrideBackButton = z;
    }

    public final boolean getAutoFocus() {
        return this.autoFocus;
    }

    public final void setAutoFocus(boolean z) {
        this.autoFocus = z;
    }

    /* access modifiers changed from: private */
    public final ScreenStackFragment getScreenStackFragment() {
        ScreenStackHeaderConfig config;
        ViewParent parent = getParent();
        if (!(parent instanceof ScreenStackHeaderSubview) || (config = ((ScreenStackHeaderSubview) parent).getConfig()) == null) {
            return null;
        }
        return config.getScreenFragment();
    }

    public final void onUpdate() {
        setSearchViewProps();
    }

    /* access modifiers changed from: private */
    public final void setSearchViewProps() {
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        CustomSearchView searchView = screenStackFragment != null ? screenStackFragment.getSearchView() : null;
        if (searchView != null) {
            if (!this.mAreListenersSet) {
                setSearchViewListeners(searchView);
                this.mAreListenersSet = true;
            }
            searchView.setInputType(this.inputType.toAndroidInputType(this.autoCapitalize));
            searchView.setQueryHint(this.placeholder);
            SearchViewFormatter searchViewFormatter = this.mSearchViewFormatter;
            if (searchViewFormatter != null) {
                searchViewFormatter.setTextColor(this.textColor);
            }
            SearchViewFormatter searchViewFormatter2 = this.mSearchViewFormatter;
            if (searchViewFormatter2 != null) {
                searchViewFormatter2.setTintColor(this.tintColor);
            }
            searchView.setOverrideBackAction(this.shouldOverrideBackButton);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null) {
            screenStackFragment.setOnSearchViewCreate(new SearchBarView$onAttachedToWindow$1(this));
        }
    }

    private final void setSearchViewListeners(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchBarView$setSearchViewListeners$1(this));
        searchView.setOnQueryTextFocusChangeListener(new SearchBarView$setSearchViewListeners$2(this));
        searchView.setOnCloseListener(new SearchBarView$setSearchViewListeners$3(this));
        searchView.setOnSearchClickListener(new SearchBarView$setSearchViewListeners$4(this));
    }

    /* access modifiers changed from: private */
    public final void handleTextChange(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("text", str);
        sendEvent("onChangeText", createMap);
    }

    /* access modifiers changed from: private */
    public final void handleFocusChange(boolean z) {
        sendEvent(z ? "onFocus" : "onBlur", (WritableMap) null);
    }

    /* access modifiers changed from: private */
    public final void handleClose() {
        sendEvent("onClose", (WritableMap) null);
    }

    /* access modifiers changed from: private */
    public final void handleOpen() {
        sendEvent("onOpen", (WritableMap) null);
    }

    /* access modifiers changed from: private */
    public final void handleTextSubmit(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("text", str);
        sendEvent("onSearchButtonPress", createMap);
    }

    private final void sendEvent(String str, WritableMap writableMap) {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        RCTEventEmitter rCTEventEmitter = (RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class);
        if (rCTEventEmitter != null) {
            rCTEventEmitter.receiveEvent(getId(), str, writableMap);
        }
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "", "(Ljava/lang/String;I)V", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "TEXT", "PHONE", "NUMBER", "EMAIL", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: SearchBarView.kt */
    public enum SearchBarInputTypes {
        ;

        public abstract int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize);

        @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$TEXT;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
        /* compiled from: SearchBarView.kt */
        static final class TEXT extends SearchBarInputTypes {

            @Metadata(mo24972bv = {1, 0, 3}, mo24975k = 3, mo24976mv = {1, 4, 0})
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] iArr = new int[SearchBarAutoCapitalize.values().length];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[SearchBarAutoCapitalize.NONE.ordinal()] = 1;
                    iArr[SearchBarAutoCapitalize.WORDS.ordinal()] = 2;
                    iArr[SearchBarAutoCapitalize.SENTENCES.ordinal()] = 3;
                    iArr[SearchBarAutoCapitalize.CHARACTERS.ordinal()] = 4;
                }
            }

            TEXT(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                int i = WhenMappings.$EnumSwitchMapping$0[searchBarAutoCapitalize.ordinal()];
                if (i == 1) {
                    return 1;
                }
                if (i == 2) {
                    return 8192;
                }
                if (i == 3) {
                    return 16384;
                }
                if (i == 4) {
                    return 4096;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$PHONE;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
        /* compiled from: SearchBarView.kt */
        static final class PHONE extends SearchBarInputTypes {
            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                return 3;
            }

            PHONE(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$NUMBER;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
        /* compiled from: SearchBarView.kt */
        static final class NUMBER extends SearchBarInputTypes {
            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                return 2;
            }

            NUMBER(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo24974d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$EMAIL;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
        /* compiled from: SearchBarView.kt */
        static final class EMAIL extends SearchBarInputTypes {
            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                return 32;
            }

            EMAIL(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }
    }
}
