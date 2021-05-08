package xar.mvvm.xarlib

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.google.android.gms.ads.MobileAds
import timber.log.Timber
import xar.mvvm.xarlib.admobs.AppOpenManager

abstract class XarApplication : MultiDexApplication(){

    private lateinit var appOpenManager: AppOpenManager

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) { }
        if(enableAdmob()) appOpenManager = AppOpenManager(this)
        if(enableFaceookAd()){
            // Initialize the Audience Network SDK
            ///AudienceNetworkAds.initialize(this);
            ///FacebookSdk.
        //
        // (getApplicationContext());// NO need according to new documentatino
            ///FacebookSdk.fullyInitialize();
            ///AppEventsLogger.activateApp(this);
            ///AppEventsLogger.activateApp(this);
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    abstract fun enableAdmob():Boolean
    abstract fun enableFaceookAd(): Boolean

    class ReleaseTree : Timber.DebugTree() {

        override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
            // Don't log VERBOSE and DEBUG
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
            Log.println(priority, "Test->$tag", message)

        }
    }
}