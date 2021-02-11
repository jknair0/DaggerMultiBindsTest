package tech.jknair.dagger;

import dagger.MapKey;
import tech.jknair.dagger.base.ViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(METHOD)
@Retention(RUNTIME)
@MapKey
public @interface ViewModelKey {
  Class<? extends ViewModel> value();
}
