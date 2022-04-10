package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "Lexpo/modules/kotlin/ModulesProvider;", "invoke"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ExpoModulesHelper.kt */
final class ExpoModulesHelper$Companion$modulesProvider$2 extends Lambda implements Function0<ModulesProvider> {
    public static final ExpoModulesHelper$Companion$modulesProvider$2 INSTANCE = new ExpoModulesHelper$Companion$modulesProvider$2();

    ExpoModulesHelper$Companion$modulesProvider$2() {
        super(0);
    }

    public final ModulesProvider invoke() {
        try {
            Object newInstance = Class.forName("expo.modules.ExpoModulesPackageList").newInstance();
            if (newInstance != null) {
                return (ModulesProvider) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.ModulesProvider");
        } catch (Exception e) {
            Log.e("ExpoModulesHelper", "Couldn't get expo modules list.", e);
            return null;
        }
    }
}
