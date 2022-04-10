package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.methods.AnyMethod;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R%\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, mo24974d2 = {"Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "", "name", "", "constantsProvider", "Lkotlin/Function0;", "", "methods", "Lexpo/modules/kotlin/methods/AnyMethod;", "viewManagerDefinition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "eventListeners", "Lexpo/modules/kotlin/events/EventName;", "Lexpo/modules/kotlin/events/EventListener;", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/util/Map;Lexpo/modules/kotlin/views/ViewManagerDefinition;Ljava/util/Map;Lexpo/modules/kotlin/events/EventsDefinition;)V", "getConstantsProvider", "()Lkotlin/jvm/functions/Function0;", "getEventListeners", "()Ljava/util/Map;", "getEventsDefinition", "()Lexpo/modules/kotlin/events/EventsDefinition;", "getMethods", "getName", "()Ljava/lang/String;", "getViewManagerDefinition", "()Lexpo/modules/kotlin/views/ViewManagerDefinition;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ModuleDefinitionData.kt */
public final class ModuleDefinitionData {
    private final Function0<Map<String, Object>> constantsProvider;
    private final Map<EventName, EventListener> eventListeners;
    private final EventsDefinition eventsDefinition;
    private final Map<String, AnyMethod> methods;
    private final String name;
    private final ViewManagerDefinition viewManagerDefinition;

    public ModuleDefinitionData(String str, Function0<? extends Map<String, ? extends Object>> function0, Map<String, ? extends AnyMethod> map, ViewManagerDefinition viewManagerDefinition2, Map<EventName, ? extends EventListener> map2, EventsDefinition eventsDefinition2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "constantsProvider");
        Intrinsics.checkNotNullParameter(map, "methods");
        Intrinsics.checkNotNullParameter(map2, "eventListeners");
        this.name = str;
        this.constantsProvider = function0;
        this.methods = map;
        this.viewManagerDefinition = viewManagerDefinition2;
        this.eventListeners = map2;
        this.eventsDefinition = eventsDefinition2;
    }

    public final String getName() {
        return this.name;
    }

    public final Function0<Map<String, Object>> getConstantsProvider() {
        return this.constantsProvider;
    }

    public final Map<String, AnyMethod> getMethods() {
        return this.methods;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModuleDefinitionData(String str, Function0 function0, Map map, ViewManagerDefinition viewManagerDefinition2, Map map2, EventsDefinition eventsDefinition2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function0, map, (i & 8) != 0 ? null : viewManagerDefinition2, (i & 16) != 0 ? MapsKt.emptyMap() : map2, (i & 32) != 0 ? null : eventsDefinition2);
    }

    public final ViewManagerDefinition getViewManagerDefinition() {
        return this.viewManagerDefinition;
    }

    public final Map<EventName, EventListener> getEventListeners() {
        return this.eventListeners;
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }
}
