package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.test

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KClass

@HiltViewModel
class DeleteViewModel @Inject constructor(

) : XarViewModel() //change it to AppViewModel when upgrade
{

    private val _deleteCommands = MutableLiveData<DeleteViewModelCommands>()
    val deleteCommands: LiveData<DeleteViewModelCommands> get() = _deleteCommands


    sealed class DeleteViewModelCommands {
        class OpenNextScreen(val className: KClass<*>) : DeleteViewModelCommands()
        class ShowToast(val title: String) : DeleteViewModelCommands()
    }
}