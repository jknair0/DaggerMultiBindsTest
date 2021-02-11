package tech.jknair.dagger.splash;

import tech.jknair.dagger.base.ViewModel;
import tech.jknair.dagger.base.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.text.View;
import java.util.Map;

public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public ViewModelProviderFactory(
            Map<Class<? extends ViewModel>, Provider<ViewModel>> creators
    ) {
        this.creators = creators;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T create(Class<? extends ViewModel> viewModelClass) {
        Provider<ViewModel> viewModelProvider = creators.get(viewModelClass);
        if (viewModelProvider == null) {
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> classProviderEntry : creators.entrySet()) {
                if (viewModelClass.isAssignableFrom(classProviderEntry.getKey())) {
                    viewModelProvider = classProviderEntry.getValue();
                    break;
                }
            }
        }
        if (viewModelProvider == null) {
            throw new IllegalStateException("Failed to instantiate " + viewModelClass.getSimpleName());
        }
        return (T) viewModelProvider.get();
    }
}
