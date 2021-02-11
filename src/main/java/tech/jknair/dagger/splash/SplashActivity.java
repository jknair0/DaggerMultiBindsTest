package tech.jknair.dagger.splash;

import tech.jknair.dagger.Main;
import tech.jknair.dagger.base.Preconditions;
import tech.jknair.dagger.base.ViewModelProvider;

import javax.inject.Inject;

public class SplashActivity {

    @Inject
    ViewModelProvider.Factory factory;

    SplashViewModel splashViewModel;

    public void check() {
        Main.appComponent.splashSubComponent().inject(this);
        splashViewModel = factory.create(SplashViewModel.class);
        Preconditions.checkNotNull(splashViewModel);
    }

}
