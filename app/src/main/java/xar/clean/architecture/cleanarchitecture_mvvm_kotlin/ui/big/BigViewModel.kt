package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.big

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KClass

@HiltViewModel
class BigViewModel @Inject constructor(

) : XarViewModel() //change it to AppViewModel when upgrade
{

    private val _bigCommands = MutableLiveData<big_view_modelCommands>()
    val bigCommands: LiveData<big_view_modelCommands> get() = _bigCommands


    sealed class big_view_modelCommands {
        class OpenNextScreen(val className: KClass<*>) : big_view_modelCommands()
    }
}