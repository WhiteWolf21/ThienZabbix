package br.dev.kuhn.handyzabbix.expo.modules.kotlin.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, mo24974d2 = {"Lexpo/modules/kotlin/events/EventsDefinition;", "", "names", "", "", "([Ljava/lang/String;)V", "getNames", "()[Ljava/lang/String;", "[Ljava/lang/String;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: EventsDefinition.kt */
public final class EventsDefinition {
    private final String[] names;

    public EventsDefinition(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "names");
        this.names = strArr;
    }

    public final String[] getNames() {
        return this.names;
    }
}
