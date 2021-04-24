package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.templates

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

@HiltViewModel
class TemplatezViewModel @Inject constructor(

) : XarViewModel() //change it to AppViewModel when upgrade
{

    ///private val _splashCommands = MutableLiveData<SplashCommand>()
    ///val splashCommands : LiveData<SplashCommand> get() = _splashCommands

    
}
