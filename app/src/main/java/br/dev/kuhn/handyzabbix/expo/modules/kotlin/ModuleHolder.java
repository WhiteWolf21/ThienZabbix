package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithPayload;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.MethodNotFoundException;
import expo.modules.kotlin.methods.AnyMethod;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J!\u0010\u0016\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u0002H\u0019¢\u0006\u0002\u0010\u001bJ/\u0010\u0016\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u00192\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u0002H\u001c2\u0006\u0010\u001a\u001a\u0002H\u0019¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, mo24974d2 = {"Lexpo/modules/kotlin/ModuleHolder;", "", "module", "Lexpo/modules/kotlin/modules/Module;", "(Lexpo/modules/kotlin/modules/Module;)V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getDefinition", "()Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getModule", "()Lexpo/modules/kotlin/modules/Module;", "name", "", "getName", "()Ljava/lang/String;", "call", "", "methodName", "args", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "post", "eventName", "Lexpo/modules/kotlin/events/EventName;", "Payload", "payload", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;)V", "Sender", "sender", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ModuleHolder.kt */
public final class ModuleHolder {
    private final ModuleDefinitionData definition;
    private final Module module;

    public ModuleHolder(Module module2) {
        Intrinsics.checkNotNullParameter(module2, "module");
        this.module = module2;
        this.definition = module2.definition();
    }

    public final Module getModule() {
        return this.module;
    }

    public final ModuleDefinitionData getDefinition() {
        return this.definition;
    }

    public final String getName() {
        return this.definition.getName();
    }

    public final void call(String str, ReadableArray readableArray, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(readableArray, "args");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        AnyMethod anyMethod = this.definition.getMethods().get(str);
        if (anyMethod != null) {
            anyMethod.call(readableArray, promise);
        } else {
            promise.reject(new MethodNotFoundException(str, this.definition.getName()));
        }
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener != null) {
            if (!(eventListener instanceof BasicEventListener)) {
                eventListener = null;
            }
            BasicEventListener basicEventListener = (BasicEventListener) eventListener;
            if (basicEventListener != null) {
                basicEventListener.call();
            }
        }
    }

    public final <Payload> void post(EventName eventName, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener != null) {
            if (!(eventListener instanceof EventListenerWithPayload)) {
                eventListener = null;
            }
            EventListenerWithPayload eventListenerWithPayload = (EventListenerWithPayload) eventListener;
            if (eventListenerWithPayload != null) {
                eventListenerWithPayload.call(payload);
            }
        }
    }

    public final <Sender, Payload> void post(EventName eventName, Sender sender, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener != null) {
            if (!(eventListener instanceof EventListenerWithSenderAndPayload)) {
                eventListener = null;
            }
            EventListenerWithSenderAndPayload eventListenerWithSenderAndPayload = (EventListenerWithSenderAndPayload) eventListener;
            if (eventListenerWithSenderAndPayload != null) {
                eventListenerWithSenderAndPayload.call(sender, payload);
            }
        }
    }
}
