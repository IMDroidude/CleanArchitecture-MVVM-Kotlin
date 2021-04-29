package xar.mvvm.xarlib.admobs

import android.app.Activity
import androidx.lifecycle.Lifecycle.Event.ON_START
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import xar.mvvm.xarlib.XarApplication
import java.util.*

class AppOpenManager (private var myApplication: XarApplication) : LifecycleObserver,Application.ActivityLifecycleCallbacks {
    companion object {
        private const val LOG_TAG = "AppOpenManager"
        private const val AD_UNIT_ID = "ca-app-pub-3940256099942544/3419835294"
    }
    private var appOpenAd: AppOpenAd? = null
    private lateinit var loadCallback: AppOpenAd.AppOpenAdLoadCallback
    private var currentActivity : Activity? = null
    private var isShowingAd : Boolean = false
    private var loadTime:Long = 0

    init{
        this.myApplication.registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(ON_START)
    fun onStart() {
        showAdIfAvailable()
        Log.d(LOG_TAG, "onStart")
    }

    fun showAdIfAvailable() {
        // Only show ad if there is not already an app open ad currently showing
        // and an ad is available.
        if (!isShowingAd && isAdAvailable())
        {
            Log.d(LOG_TAG, "Will show ad.")
            val fullScreenContentCallback = object: FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    // Set the reference to null so isAdAvailable() returns false.
                    this@AppOpenManager.appOpenAd = null
                    isShowingAd = false
                    fetchAd()
                }
                override fun onAdFailedToShowFullScreenContent(adError: AdError) {}
                override fun onAdShowedFullScreenContent() {
                    isShowingAd = true
                }
            }
            appOpenAd?.show(currentActivity)
            appOpenAd?.fullScreenContentCallback = fullScreenContentCallback
        }
        else
        {
            Log.d(LOG_TAG, "Can not show ad.")
            fetchAd()
        }
    }
    /** Request an ad */
    fun fetchAd() {
        // We will implement this below.
        if (isAdAvailable()) {
            return
        }
        loadCallback = object:AppOpenAd.AppOpenAdLoadCallback() {
            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
            }

            override fun onAdLoaded(ad: AppOpenAd) {
                super.onAdLoaded(ad)
                this@AppOpenManager.appOpenAd = ad
                this@AppOpenManager.loadTime = (Date()).getTime()
            }
            /*override fun onAppOpenAdLoaded(ad:AppOpenAd) {
                this@AppOpenManager.appOpenAd = ad
                this@AppOpenManager.loadTime = (Date()).getTime()
            }*/
            /**
             * Called when an app open ad has failed to load.
             *
             * @param loadAdError the error.
             */
            /*override fun onAppOpenAdFailedToLoad(loadAdError: LoadAdError) {
                // Handle the error.
            }*/


        }

        val request : AdRequest  = getAdRequest()
        AppOpenAd.load(
            myApplication, AD_UNIT_ID, request,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback)
    }



    /** Creates and returns ad request. */
    private fun getAdRequest():AdRequest {
        return AdRequest.Builder().build()
    }
    /** Utility method that checks if ad exists and can be shown. */
    fun isAdAvailable():Boolean {
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4)
    }

    /** Utility method to check if ad was loaded more than n hours ago. */
    private fun wasLoadTimeLessThanNHoursAgo(numHours:Long):Boolean {
        val dateDifference = (Date()).time - this.loadTime
        val numMilliSecondsPerHour:Long = 3600000
        return (dateDifference < (numMilliSecondsPerHour * numHours))
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityDestroyed(activity: Activity) {
        currentActivity = null
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }


}