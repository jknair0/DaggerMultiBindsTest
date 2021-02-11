package tech.jknair.dagger;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import tech.jknair.dagger.base.ViewModel;
import tech.jknair.dagger.splash.SplashViewModel;

@Module
public class AppModule {

    @Provides
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    ViewModel splashViewModel() {
        System.out.println("SplashViewModel created here");
        return new SplashViewModel();
    }

}
