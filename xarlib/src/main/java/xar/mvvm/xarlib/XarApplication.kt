package xar.mvvm.xarlib

import androidx.multidex.MultiDexApplication
import com.google.android.gms.ads.MobileAds
import xar.mvvm.xarlib.admobs.AppOpenManager

abstract class XarApplication : MultiDexApplication(){

    private lateinit var appOpenManager: AppOpenManager

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) { }
        if(enableAdmob()) appOpenManager = AppOpenManager(this)
    }

    abstract fun enableAdmob():Boolean
}