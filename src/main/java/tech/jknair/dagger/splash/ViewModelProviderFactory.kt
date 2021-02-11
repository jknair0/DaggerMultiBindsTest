package tech.jknair.dagger.splash

import javax.inject.Inject
import tech.jknair.dagger.base.ViewModel
import tech.jknair.dagger.base.ViewModelProvider
import java.lang.IllegalStateException
import javax.inject.Provider

/**
 * if you dont use [out] for the Class the code will be generated as Class<ViewModel> but the dagger is looking for Class<? extends ViewModel>(based on the [ViewModelClassKey] implementation we have provided.)
 *
 * if you dont use [JvmSuppressWildcards] the kotlin will generate map as Map<..., ? extends Provider<ViewModel>> but dagger is looking for Map<..., Provider<ViewModel>>
 *
 * so the final shape dagger is looking for it Map<Class<? extends ViewModel>, Provider<ViewModel>> , so beware for the errors saying that No method found with @Provide provide some random Map<...>.
 */
class ViewModelProviderFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T> create(viewModelClass: Class<out ViewModel>): T {
        val viewModelProvider = creators[viewModelClass] ?: creators.asIterable().firstOrNull {
            viewModelClass.isAssignableFrom(it.key)
        }?.value
        checkNotNull(viewModelProvider) { """Failed to instantiate ${viewModelClass.simpleName}""" }
        return viewModelProvider.get() as T
    }
}