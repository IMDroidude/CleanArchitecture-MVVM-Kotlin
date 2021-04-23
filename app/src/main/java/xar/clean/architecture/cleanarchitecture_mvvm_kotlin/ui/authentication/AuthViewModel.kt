package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.splash.SplashViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

@HiltViewModel
class AuthViewModel @Inject constructor(

) : XarViewModel() //change it to AppViewModel when upgrade
{

    private val _authCommands = MutableLiveData<AuthAction>()
    val authCommands : LiveData<AuthAction> get() = _authCommands

    init {
        viewModelScope.launch {
            _authCommands.postValue(AuthAction.ShowLoader)
        }
    }

    fun authenticate(userName:String,password:String){
        if(userName.isEmpty() || password.isEmpty()) _authCommands.postValue(AuthAction.UserNameOrEmailInvalid(true))
        //blalh
        _authCommands.postValue(AuthAction.AuthFailed)
        _authCommands.postValue(AuthAction.AuthSuccess(arrayListOf()))
    }

    sealed class AuthAction{
        object ShowLoader:AuthAction()
        object AuthFailed:AuthAction()
        data class AuthSuccess(val response:List<String>):AuthAction()
        object PasswordNotMatched : AuthAction()
        data class UserNameOrEmailInvalid(val lengthInvalid:Boolean) : AuthAction()
        object AuthorizationTokenExpire:AuthAction()
    }
}
