package br.dev.kuhn.handyzabbix.expo.modules.kotlin.events;

import android.os.Bundle;
import expo.modules.core.interfaces.services.EventEmitter;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.ModuleHolder;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p014io.FilenameUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0001J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u00100\u0010H\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo24974d2 = {"Lexpo/modules/kotlin/events/KEventEmitterWrapper;", "Lexpo/modules/core/interfaces/services/EventEmitter;", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "legacyEventEmitter", "(Lexpo/modules/kotlin/ModuleHolder;Lexpo/modules/core/interfaces/services/EventEmitter;)V", "emit", "", "viewId", "", "event", "Lexpo/modules/core/interfaces/services/EventEmitter$Event;", "kotlin.jvm.PlatformType", "eventName", "", "eventBody", "Landroid/os/Bundle;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: KEventEmitterWrapper.kt */
public final class KEventEmitterWrapper implements EventEmitter {
    private final EventEmitter legacyEventEmitter;
    private final ModuleHolder moduleHolder;

    public void emit(int i, EventEmitter.Event event) {
        this.legacyEventEmitter.emit(i, event);
    }

    public void emit(int i, String str, Bundle bundle) {
        this.legacyEventEmitter.emit(i, str, bundle);
    }

    public KEventEmitterWrapper(ModuleHolder moduleHolder2, EventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(moduleHolder2, "moduleHolder");
        Intrinsics.checkNotNullParameter(eventEmitter, "legacyEventEmitter");
        this.moduleHolder = moduleHolder2;
        this.legacyEventEmitter = eventEmitter;
    }

    public void emit(String str, Bundle bundle) {
        String[] names;
        Intrinsics.checkNotNullParameter(str, "eventName");
        EventsDefinition eventsDefinition = this.moduleHolder.getDefinition().getEventsDefinition();
        boolean z = true;
        if (eventsDefinition == null || (names = eventsDefinition.getNames()) == null || !ArraysKt.contains((T[]) names, str)) {
            z = false;
        }
        if (z) {
            this.legacyEventEmitter.emit(str, bundle);
            return;
        }
        throw new IllegalArgumentException(("Unsupported event: " + str + FilenameUtils.EXTENSION_SEPARATOR).toString());
    }
}
