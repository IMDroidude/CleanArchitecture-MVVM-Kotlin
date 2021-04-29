package xar.clean.architecture.cleanarchitecture_mvvm_kotlin

import dagger.hilt.android.HiltAndroidApp
import xar.mvvm.xarlib.XarApplication

@HiltAndroidApp
class AppMain : XarApplication(){

    override fun onCreate() {
        super.onCreate()
    }
    override fun enableAdmob(): Boolean = true
}