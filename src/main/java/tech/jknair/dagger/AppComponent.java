package tech.jknair.dagger;

import dagger.Component;
import tech.jknair.dagger.splash.SplashSubComponent;

@Component(modules = {AppModule.class, AppModuleStatics.class})
public interface AppComponent {

    SplashSubComponent splashSubComponent();

}
