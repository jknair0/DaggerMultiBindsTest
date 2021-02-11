package tech.jknair.dagger.splash;

import dagger.Module;
import dagger.Subcomponent;

@Subcomponent(modules = {SplashSubComponent.SplashModule.class})
public interface SplashSubComponent {

    void inject(SplashActivity splashActivity);

    @Module
    interface SplashModule {

    }

}
