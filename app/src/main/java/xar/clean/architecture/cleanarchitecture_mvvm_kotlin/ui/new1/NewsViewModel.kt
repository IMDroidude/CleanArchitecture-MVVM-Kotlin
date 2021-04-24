package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.new1

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KClass

@HiltViewModel
class NewsViewModel @Inject constructor(

) : XarViewModel() //change it to AppViewModel when upgrade
{

    private val _newsCommands = MutableLiveData<NewsViewModelCommands>()
    val newsCommands: LiveData<NewsViewModelCommands> get() = _newsCommands


    sealed class NewsViewModelCommands {
        class OpenNextScreen(val className: KClass<*>) : NewsViewModelCommands()
        class ShowToast(val title: String) : NewsViewModelCommands()
    }
}