package xar.mvvm.xarlib

import androidx.multidex.MultiDexApplication
import com.google.android.gms.ads.MobileAds

abstract class XarApplication : MultiDexApplication(){

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) { }
    }
}