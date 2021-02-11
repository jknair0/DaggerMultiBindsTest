package tech.jknair.dagger.base;

public interface ViewModelProvider {

    interface Factory {

        <T> T create(Class<? extends ViewModel> viewModelClass);

    }

}
