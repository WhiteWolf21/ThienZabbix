package br.dev.kuhn.handyzabbix.expo.modules.kotlin.events;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u0007\b\t¨\u0006\n"}, mo24974d2 = {"Lexpo/modules/kotlin/events/EventListener;", "", "eventName", "Lexpo/modules/kotlin/events/EventName;", "(Lexpo/modules/kotlin/events/EventName;)V", "getEventName", "()Lexpo/modules/kotlin/events/EventName;", "Lexpo/modules/kotlin/events/BasicEventListener;", "Lexpo/modules/kotlin/events/EventListenerWithPayload;", "Lexpo/modules/kotlin/events/EventListenerWithSenderAndPayload;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: EventListener.kt */
public abstract class EventListener {
    private final EventName eventName;

    private EventListener(EventName eventName2) {
        this.eventName = eventName2;
    }

    public /* synthetic */ EventListener(EventName eventName2, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventName2);
    }

    public final EventName getEventName() {
        return this.eventName;
    }
}
