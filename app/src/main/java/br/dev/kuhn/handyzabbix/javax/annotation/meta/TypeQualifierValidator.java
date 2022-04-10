package br.dev.kuhn.handyzabbix.javax.annotation.meta;

import java.lang.annotation.Annotation;
import br.dev.kuhn.handyzabbix.javax.annotation.Nonnull;

public interface TypeQualifierValidator<A extends Annotation> {
    @Nonnull
    When forConstantValue(@Nonnull A a, Object obj);
}
