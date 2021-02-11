package tech.jknair.dagger;

import dagger.Binds;
import dagger.Module;
import tech.jknair.dagger.base.ViewModelProvider;
import tech.jknair.dagger.splash.ViewModelProviderFactory;

@Module
interface AppModuleStatics {

    @Binds
    ViewModelProvider.Factory providesVmFactory(ViewModelProviderFactory viewModelProviderFactory);

}