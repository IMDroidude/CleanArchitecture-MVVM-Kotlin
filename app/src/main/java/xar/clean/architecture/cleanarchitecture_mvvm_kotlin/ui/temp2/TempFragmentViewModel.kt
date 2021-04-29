package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.temp2

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KClass

@HiltViewModel
class TempFragmentViewModel @Inject constructor(

) : XarViewModel() {

    private val _tempCommands = MutableLiveData<TempFragmentViewModelCommands>()
    val tempCommands: LiveData<TempFragmentViewModelCommands> get() = _tempCommands


    sealed class TempFragmentViewModelCommands {
        class OpenNextScreen(val className: KClass<*>) : TempFragmentViewModelCommands()
        class ShowToast(val title: String) : TempFragmentViewModelCommands()
    }
}

