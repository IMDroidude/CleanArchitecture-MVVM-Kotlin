package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.splash

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.admobs.AdaptiveBannerActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.main.MainActivity
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

import kotlin.reflect.KClass

@HiltViewModel
class SplashViewModel @Inject constructor(
   @ApplicationContext val context:Context
) : XarViewModel() //change it to AppViewModel when upgrade
{
    val liveString:LiveData<String> = MutableLiveData<String>().apply {
        value = "hello"
    }
    /*private val _splashCommands = MutableLiveData<SplashCommand>()
    val splashCommands : LiveData<SplashCommand> get() = _splashCommands*/
    val commandFlow = flow<SplashCommand> {
        delay(800)
        emit(SplashCommand.OpenNextScreen(MainActivity::class))
        /*if(internetNoAvailab)
            emit(SplashCommand.NetworkErro(""))*/
    }
    /*private val _splashViewState = MutableLiveData<SplashViewState>()
    val splashViewState : LiveData<SplashViewState> get() = _splashViewState*/

    init {


        /*viewModelScope.launch {
           delay(2000)
            _splashCommands.postValue(SplashCommand.OpenNextScreen(MainActivity::class))

            _splashCommands.postValue(SplashCommand.ShowToast("I m clicked"))
        }*/
    }

    sealed class SplashCommand {
        class OpenNextScreen(val className: KClass<*>) : SplashCommand()
        class ShowToast(val title:String):SplashCommand()
        ///class NetworkErro(val errorMessage):SplashCommand()
    }

    ///data class SplashViewState(val name: String,val className: KClass<*>?)
}
