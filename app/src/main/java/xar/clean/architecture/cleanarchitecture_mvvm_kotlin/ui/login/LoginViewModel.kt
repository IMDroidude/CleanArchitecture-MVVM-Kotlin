package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.login

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel
import xar.mvvm.xarlib.prefs.PrefStore
import xar.mvvm.xarlib.prefs.SharedPrefStore

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val prefStore: PrefStore
) : XarViewModel() //change it to AppViewModel when upgrade
{
    init {
        prefStore.saveBoolean("isLoggedIn",true)
    }

}
