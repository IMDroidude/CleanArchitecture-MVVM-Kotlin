package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.utils.prefs

import xar.mvvm.xarlib.prefs.PrefStore
import javax.inject.Inject

class LocalPrefsImpl @Inject constructor(val prefStore: PrefStore):LocalPrefs{

    companion object{
        const val KEY_LOGGED_IN = "key_logged_in"
    }
    override fun isLoggedIn(): Boolean = prefStore.getBoolean(KEY_LOGGED_IN,false)

}