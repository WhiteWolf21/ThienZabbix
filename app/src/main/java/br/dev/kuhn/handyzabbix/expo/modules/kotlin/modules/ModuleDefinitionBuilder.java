package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import android.app.Activity;
import android.content.Intent;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithPayload;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.methods.AnyMethod;
import expo.modules.kotlin.methods.Method;
import expo.modules.kotlin.methods.PromiseMethod;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import expo.modules.kotlin.views.ViewManagerDefinition;
import expo.modules.kotlin.views.ViewManagerDefinitionBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\"\u0010 \u001a\u00020!2\u001a\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004J\u001f\u0010\"\u001a\u00020!2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060#\"\u00020\u0006¢\u0006\u0002\u0010$J,\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0\u0004H\bø\u0001\u0000J+\u0010%\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00062\u0010\b\u0004\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\bø\u0001\u0000¢\u0006\u0002\b(JI\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062#\b\u0004\u0010'\u001a\u001d\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H&0*H\bø\u0001\u0000Jf\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u0001\"\u0006\b\u0002\u0010-\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u000628\b\u0004\u0010'\u001a2\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H-¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H&0.H\bø\u0001\u0000J\u0001\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u0001\"\u0006\b\u0002\u0010-\u0018\u0001\"\u0006\b\u0003\u00100\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062M\b\u0004\u0010'\u001aG\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H-¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002H&01H\bø\u0001\u0000J \u0001\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u0001\"\u0006\b\u0002\u0010-\u0018\u0001\"\u0006\b\u0003\u00100\u0018\u0001\"\u0006\b\u0004\u00103\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062b\b\u0004\u0010'\u001a\\\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H-¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002H&04H\bø\u0001\u0000J½\u0001\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u0001\"\u0006\b\u0002\u0010-\u0018\u0001\"\u0006\b\u0003\u00100\u0018\u0001\"\u0006\b\u0004\u00103\u0018\u0001\"\u0006\b\u0005\u00106\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062w\b\u0004\u0010'\u001aq\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H-¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H&07H\bø\u0001\u0000JÜ\u0001\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u0001\"\u0006\b\u0002\u0010-\u0018\u0001\"\u0006\b\u0003\u00100\u0018\u0001\"\u0006\b\u0004\u00103\u0018\u0001\"\u0006\b\u0005\u00106\u0018\u0001\"\u0006\b\u0006\u00109\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062\u0001\b\u0004\u0010'\u001a\u0001\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H-¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002H&0:H\bø\u0001\u0000Jù\u0001\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u0001\"\u0006\b\u0002\u0010-\u0018\u0001\"\u0006\b\u0003\u00100\u0018\u0001\"\u0006\b\u0004\u00103\u0018\u0001\"\u0006\b\u0005\u00106\u0018\u0001\"\u0006\b\u0006\u00109\u0018\u0001\"\u0006\b\u0007\u0010<\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062¢\u0001\b\u0004\u0010'\u001a\u0001\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H-¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002H&0=H\bø\u0001\u0000J\u0002\u0010%\u001a\u00020!\"\u0006\b\u0000\u0010&\u0018\u0001\"\u0006\b\u0001\u0010)\u0018\u0001\"\u0006\b\u0002\u0010-\u0018\u0001\"\u0006\b\u0003\u00100\u0018\u0001\"\u0006\b\u0004\u00103\u0018\u0001\"\u0006\b\u0005\u00106\u0018\u0001\"\u0006\b\u0006\u00109\u0018\u0001\"\u0006\b\u0007\u0010<\u0018\u0001\"\u0006\b\b\u0010?\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00062·\u0001\b\u0004\u0010'\u001a°\u0001\u0012\u0013\u0012\u0011H)¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H-¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b+\u0012\b\b\u0016\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H&0@H\bø\u0001\u0000J\u000e\u0010\u0016\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0006J\u001c\u0010B\u001a\u00020!2\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\bø\u0001\u0000J\u001c\u0010C\u001a\u00020!2\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\bø\u0001\u0000J\u001c\u0010D\u001a\u00020!2\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\bø\u0001\u0000J(\u0010E\u001a\u00020!2\u001a\b\u0004\u0010'\u001a\u0014\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020!0.H\bø\u0001\u0000J\u001c\u0010H\u001a\u00020!2\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\bø\u0001\u0000J\u001c\u0010I\u001a\u00020!2\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\bø\u0001\u0000J\"\u0010J\u001a\u00020!2\u0014\b\u0004\u0010'\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020!0*H\bø\u0001\u0000J\u001c\u0010L\u001a\u00020!2\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\bø\u0001\u0000J\u001c\u0010M\u001a\u00020!2\u000e\b\u0004\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\bø\u0001\u0000J%\u0010N\u001a\u00020!2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020!0*¢\u0006\u0002\bPH\bø\u0001\u0000R\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u0002\u0007\n\u0005\b20\u0001¨\u0006Q"}, mo24974d2 = {"Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "", "()V", "constantsProvider", "Lkotlin/Function0;", "", "", "eventListeners", "", "Lexpo/modules/kotlin/events/EventName;", "Lexpo/modules/kotlin/events/EventListener;", "getEventListeners$annotations", "getEventListeners", "()Ljava/util/Map;", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "methods", "Lexpo/modules/kotlin/methods/AnyMethod;", "getMethods$annotations", "getMethods", "setMethods", "(Ljava/util/Map;)V", "name", "viewManagerDefinition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getViewManagerDefinition$annotations", "getViewManagerDefinition", "()Lexpo/modules/kotlin/views/ViewManagerDefinition;", "setViewManagerDefinition", "(Lexpo/modules/kotlin/views/ViewManagerDefinition;)V", "build", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "constants", "", "events", "", "([Ljava/lang/String;)V", "function", "R", "body", "methodWithoutArgs", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "onActivityDestroys", "onActivityEntersBackground", "onActivityEntersForeground", "onActivityResult", "Landroid/app/Activity;", "Lexpo/modules/kotlin/events/OnActivityResultPayload;", "onCreate", "onDestroy", "onNewIntent", "Landroid/content/Intent;", "onStartObserving", "onStopObserving", "viewManager", "Lexpo/modules/kotlin/views/ViewManagerDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ModuleDefinitionBuilder.kt */
public final class ModuleDefinitionBuilder {
    private Function0<? extends Map<String, ? extends Object>> constantsProvider = ModuleDefinitionBuilder$constantsProvider$1.INSTANCE;
    private final Map<EventName, EventListener> eventListeners = new LinkedHashMap();
    private EventsDefinition eventsDefinition;
    private Map<String, AnyMethod> methods = new LinkedHashMap();
    private String name;
    private ViewManagerDefinition viewManagerDefinition;

    public static /* synthetic */ void getEventListeners$annotations() {
    }

    public static /* synthetic */ void getMethods$annotations() {
    }

    public static /* synthetic */ void getViewManagerDefinition$annotations() {
    }

    public final Map<String, AnyMethod> getMethods() {
        return this.methods;
    }

    public final void setMethods(Map<String, AnyMethod> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.methods = map;
    }

    public final ViewManagerDefinition getViewManagerDefinition() {
        return this.viewManagerDefinition;
    }

    public final void setViewManagerDefinition(ViewManagerDefinition viewManagerDefinition2) {
        this.viewManagerDefinition = viewManagerDefinition2;
    }

    public final Map<EventName, EventListener> getEventListeners() {
        return this.eventListeners;
    }

    public final ModuleDefinitionData build() {
        String str = this.name;
        if (str != null) {
            return new ModuleDefinitionData(str, this.constantsProvider, this.methods, this.viewManagerDefinition, this.eventListeners, this.eventsDefinition);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void name(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final void constants(Function0<? extends Map<String, ? extends Object>> function0) {
        Intrinsics.checkNotNullParameter(function0, "constantsProvider");
        this.constantsProvider = function0;
    }

    public final void methodWithoutArgs(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "body");
        getMethods().put(str, new Method(str, new AnyType[0], new ModuleDefinitionBuilder$function$1(function0)));
    }

    public final /* synthetic */ <R> void function(String str, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "body");
        getMethods().put(str, new Method(str, new AnyType[0], new ModuleDefinitionBuilder$function$2(function0)));
    }

    public final /* synthetic */ <R, P0> void function(String str, Function1<? super P0, ? extends R> function1) {
        AnyMethod anyMethod;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str, new AnyType[0], new ModuleDefinitionBuilder$function$3(function1));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str, anyTypeArr, new ModuleDefinitionBuilder$function$4(function1));
        }
        methods2.put(str, anyMethod);
    }

    public final /* synthetic */ <R, P0, P1> void function(String str, Function2<? super P0, ? super P1, ? extends R> function2) {
        AnyMethod anyMethod;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P1");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str, anyTypeArr, new ModuleDefinitionBuilder$function$5(function2));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str, anyTypeArr2, new ModuleDefinitionBuilder$function$6(function2));
        }
        methods2.put(str, anyMethod);
    }

    public final /* synthetic */ <R, P0, P1, P2> void function(String str, Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        AnyMethod anyMethod;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function3, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P2");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str, anyTypeArr, new ModuleDefinitionBuilder$function$7(function3));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str, anyTypeArr2, new ModuleDefinitionBuilder$function$8(function3));
        }
        methods2.put(str, anyMethod);
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> void function(String str, Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        AnyMethod anyMethod;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P3");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str, anyTypeArr, new ModuleDefinitionBuilder$function$9(function4));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str, anyTypeArr2, new ModuleDefinitionBuilder$function$10(function4));
        }
        methods2.put(str, anyMethod);
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> void function(String str, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        AnyMethod anyMethod;
        String str2 = str;
        Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function52 = function5;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function52, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P4");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str2, anyTypeArr, new ModuleDefinitionBuilder$function$11(function52));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str2, anyTypeArr2, new ModuleDefinitionBuilder$function$12(function52));
        }
        methods2.put(str2, anyMethod);
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> void function(String str, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function6) {
        AnyMethod anyMethod;
        String str2 = str;
        Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function62 = function6;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function62, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P5");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str2, anyTypeArr, new ModuleDefinitionBuilder$function$13(function62));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str2, anyTypeArr2, new ModuleDefinitionBuilder$function$14(function62));
        }
        methods2.put(str2, anyMethod);
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> void function(String str, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        AnyMethod anyMethod;
        String str2 = str;
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function72, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P6");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str2, anyTypeArr, new ModuleDefinitionBuilder$function$15(function72));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            Intrinsics.reifiedOperationMarker(6, "P6");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str2, anyTypeArr2, new ModuleDefinitionBuilder$function$16(function72));
        }
        methods2.put(str2, anyMethod);
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> void function(String str, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function8) {
        AnyMethod anyMethod;
        String str2 = str;
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function82, "body");
        Map<String, AnyMethod> methods2 = getMethods();
        Intrinsics.reifiedOperationMarker(4, "P7");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            Intrinsics.reifiedOperationMarker(6, "P6");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new PromiseMethod(str2, anyTypeArr, new ModuleDefinitionBuilder$function$17(function82));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            Intrinsics.reifiedOperationMarker(6, "P6");
            Intrinsics.reifiedOperationMarker(6, "P7");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            anyMethod = new Method(str2, anyTypeArr2, new ModuleDefinitionBuilder$function$18(function82));
        }
        methods2.put(str2, anyMethod);
    }

    public final void viewManager(Function1<? super ViewManagerDefinitionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        if (getViewManagerDefinition() == null) {
            ViewManagerDefinitionBuilder viewManagerDefinitionBuilder = new ViewManagerDefinitionBuilder();
            function1.invoke(viewManagerDefinitionBuilder);
            setViewManagerDefinition(viewManagerDefinitionBuilder.build());
            return;
        }
        throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
    }

    public final void onCreate(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new ModuleDefinitionBuilder$onCreate$1(function0)));
    }

    public final void onDestroy(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new ModuleDefinitionBuilder$onDestroy$1(function0)));
    }

    public final void onActivityEntersForeground(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new ModuleDefinitionBuilder$onActivityEntersForeground$1(function0)));
    }

    public final void onActivityEntersBackground(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new ModuleDefinitionBuilder$onActivityEntersBackground$1(function0)));
    }

    public final void onActivityDestroys(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new ModuleDefinitionBuilder$onActivityDestroys$1(function0)));
    }

    public final void events(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "events");
        this.eventsDefinition = new EventsDefinition(strArr);
    }

    public final void onNewIntent(Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        getEventListeners().put(EventName.ON_NEW_INTENT, new EventListenerWithPayload(EventName.ON_NEW_INTENT, new ModuleDefinitionBuilder$onNewIntent$1(function1)));
    }

    public final void onActivityResult(Function2<? super Activity, ? super OnActivityResultPayload, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new ModuleDefinitionBuilder$onActivityResult$1(function2)));
    }

    public final void onStartObserving(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getMethods().put("startObserving", new Method("startObserving", new AnyType[0], new ModuleDefinitionBuilder$function$1(function0)));
    }

    public final void onStopObserving(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getMethods().put("stopObserving", new Method("stopObserving", new AnyType[0], new ModuleDefinitionBuilder$function$1(function0)));
    }
}
