package xar.mvvm.xarlib

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.BuildConfig
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import xar.mvvm.xarlib.extensions.toast

abstract class XarActivity<DB: ViewDataBinding,VM: XarViewModel>(@LayoutRes val resLayoutID:Int) : AppCompatActivity(
    resLayoutID
) {

    lateinit var mBinding:DB
    abstract val mViewModel: VM
    /*private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> DB
    protected val binding: DB
        get() = _binding as DB*/
    var adView: AdView? = null
    var mInterstitialAd:InterstitialAd? = null

    var adRequest = AdRequest.Builder().build()
    var currentNativeAd: NativeAd? = null

    ///abstract fun setAdUnitID():String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,resLayoutID)
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)
        /*_binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)*/

        /*val strList = arrayListOf<UserBO>()
        recyclerView.adapter = SingleTypeListAdapter<UserBO>(strList,object :OnAdapterBind<UserBO>{
            override fun onBindData(itemView: View?, position: Int, data: UserBO) {
                itemView.text.la
            }

            override fun onItemClicked(position: Int, mView: View?) {
                TODO("Not yet implemented")
            }
        })*/
    }

    fun loadNativeAd(frameLayout: FrameLayout,adUnitID: String){
        val adLoader = AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
            .forNativeAd { ad : NativeAd ->
                // Show the ad.
            }
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    // Handle the failure by logging, altering the UI, and so on.
                }
            })
            .withNativeAdOptions(NativeAdOptions.Builder()
                // Methods in the NativeAdOptions.Builder class can be
                // used here to specify individual options settings.
                .build())
            .build()
    }


    fun loadInterstitalAd(adUnitID:String, onAdLoaded: ((isAdLoaded: Boolean) -> Unit)?){
        InterstitialAd.load(this,adUnitID, adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
                /*Log.d(TAG, adError?.message)
                mInterstitialAd = null*/
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
                onAdLoaded?.invoke(true)
                ///mInterstitialAd.fullScreenContentCallback
                /*Log.d(TAG, 'Ad was loaded.')
                mInterstitialAd = interstitialAd*/

                //showInterstitial(adUnitID)

            }
        })

    }

    fun showInterstitial(adUnitID: String) {
        if (mInterstitialAd != null) {
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    ///Log.d(TAG, "Ad was dismissed.")
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    mInterstitialAd = null
                    loadInterstitalAd(adUnitID,null)
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                    ///Log.d(TAG, "Ad failed to show.")
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    mInterstitialAd = null
                }

                override fun onAdShowedFullScreenContent() {
                    //Log.d(TAG, "Ad showed fullscreen content.")
                    // Called when ad is dismissed.
                }
            }
            mInterstitialAd?.show(this)
        } else {
            Toast.makeText(this, "Ad wasn't loaded yet.", Toast.LENGTH_SHORT).show()
            loadInterstitalAd(adUnitID,null)
        }
    }
    override fun onPause() {
        super.onPause()
        adView?.pause()
    }

    override fun onResume() {
        super.onResume()
        adView?.resume()
    }
    override fun onDestroy() {
        super.onDestroy()
        adView?.destroy()
        currentNativeAd?.destroy();
        ///_binding = null
    }

    fun getAdaptiveBannerSize():AdSize{
        val windowWidth = resources.configuration.screenWidthDp
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this,windowWidth)
    }

    fun loadBanner(frameContainer:FrameLayout,bannerAdUnit:String){
        if(bannerAdUnit.isNotEmpty()){
            adView = AdView(this)
            val adRequest = AdRequest.Builder().build()
            adView?.let {
                adView?.apply {
                    adUnitId = bannerAdUnit
                    adSize = getAdaptiveBannerSize()
                    loadAd(adRequest)

                }
                frameContainer.removeAllViews()
                frameContainer.addView(adView)
            }
        } else {
            if(BuildConfig.DEBUG){
                toast("Bro adUnit Id empty mil rahe hai")
            }
        }
    }

    //newly added
    fun addFragment(frameContainer:Int,fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .add(fragment,fragment.javaClass.canonicalName)
            .commit()
    }

    fun replaceFragment(frameContainer:Int,fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(frameContainer,fragment,fragment.javaClass.canonicalName)
            .commit()
    }

    private fun populateNativeAdView(nativeAd: NativeAd, adView: NativeAdView) {
        // Set the media view.
        adView.mediaView = adView.findViewById<MediaView>(R.id.ad_media)

        // Set other ad assets.
        adView.headlineView = adView.findViewById(R.id.ad_headline)
        adView.bodyView = adView.findViewById(R.id.ad_body)
        adView.callToActionView = adView.findViewById(R.id.ad_call_to_action)
        adView.iconView = adView.findViewById(R.id.ad_app_icon)
        adView.priceView = adView.findViewById(R.id.ad_price)
        adView.starRatingView = adView.findViewById(R.id.ad_stars)
        adView.storeView = adView.findViewById(R.id.ad_store)
        adView.advertiserView = adView.findViewById(R.id.ad_advertiser)

        // The headline and media content are guaranteed to be in every UnifiedNativeAd.
        (adView.headlineView as TextView).text = nativeAd.headline
        adView.mediaView.setMediaContent(nativeAd.mediaContent)

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.body == null) {
            adView.bodyView.visibility = View.INVISIBLE
        } else {
            adView.bodyView.visibility = View.VISIBLE
            (adView.bodyView as TextView).text = nativeAd.body
        }

        if (nativeAd.callToAction == null) {
            adView.callToActionView.visibility = View.INVISIBLE
        } else {
            adView.callToActionView.visibility = View.VISIBLE
            (adView.callToActionView as Button).text = nativeAd.callToAction
        }

        if (nativeAd.icon == null) {
            adView.iconView.visibility = View.GONE
        } else {
            (adView.iconView as ImageView).setImageDrawable(
                nativeAd.icon.drawable
            )
            adView.iconView.visibility = View.VISIBLE
        }

        if (nativeAd.price == null) {
            adView.priceView.visibility = View.INVISIBLE
        } else {
            adView.priceView.visibility = View.VISIBLE
            (adView.priceView as TextView).text = nativeAd.price
        }

        if (nativeAd.store == null) {
            adView.storeView.visibility = View.INVISIBLE
        } else {
            adView.storeView.visibility = View.VISIBLE
            (adView.storeView as TextView).text = nativeAd.store
        }

        if (nativeAd.starRating == null) {
            adView.starRatingView.visibility = View.INVISIBLE
        } else {
            (adView.starRatingView as RatingBar).rating = nativeAd.starRating!!.toFloat()
            adView.starRatingView.visibility = View.VISIBLE
        }

        if (nativeAd.advertiser == null) {
            adView.advertiserView.visibility = View.INVISIBLE
        } else {
            (adView.advertiserView as TextView).text = nativeAd.advertiser
            adView.advertiserView.visibility = View.VISIBLE
        }

        // This method tells the Google Mobile Ads SDK that you have finished populating your
        // native ad view with this native ad.
        adView.setNativeAd(nativeAd)

        // Get the video controller for the ad. One will always be provided, even if the ad doesn't
        // have a video asset.
        val vc = nativeAd.mediaContent.videoController

        // Updates the UI to say whether or not this ad has a video asset.
        if (vc.hasVideoContent()) {
            // Create a new VideoLifecycleCallbacks object and pass it to the VideoController. The
            // VideoController will call methods on this object when events occur in the video
            // lifecycle.
            vc.videoLifecycleCallbacks = object : VideoController.VideoLifecycleCallbacks() {
                override fun onVideoEnd() {
                    // Publishers should allow native ads to complete video playback before
                    // refreshing or replacing them with another ad in the same UI location.
                    ///refresh_button.isEnabled = true
                    ////videostatus_text.text = "Video status: Video playback has ended."
                    super.onVideoEnd()
                }
            }
        } else {
            ///videostatus_text.text = "Video status: Ad does not contain a video asset."
            ///refresh_button.isEnabled = true
        }
    }

    fun refreshAd(frameContainer: FrameLayout,ADMOB_AD_UNIT_ID:String) {
        ///refresh_button.isEnabled = false

        val builder = AdLoader.Builder(this, ADMOB_AD_UNIT_ID)

        builder.forNativeAd { nativeAd ->
            // OnUnifiedNativeAdLoadedListener implementation.
            // If this callback occurs after the activity is destroyed, you must call
            // destroy and return or you may get a memory leak.
            var activityDestroyed = false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                activityDestroyed = isDestroyed
            }
            if (activityDestroyed || isFinishing || isChangingConfigurations) {
                nativeAd.destroy()
                return@forNativeAd
            }
            // You must call destroy on old ads when you are done with them,
            // otherwise you will have a memory leak.
            currentNativeAd?.destroy()
            currentNativeAd = nativeAd
            val adView = layoutInflater
                .inflate(R.layout.ad_unified, null) as NativeAdView
            populateNativeAdView(nativeAd, adView)
            frameContainer.removeAllViews()
            frameContainer.addView(adView)
        }

        val videoOptions = VideoOptions.Builder()
            .setStartMuted(true)
            .build()

        val adOptions = NativeAdOptions.Builder()
            .setVideoOptions(videoOptions)
            .build()

        builder.withNativeAdOptions(adOptions)

        val adLoader = builder.withAdListener(object : AdListener() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                val error =
                    """
           domain: ${loadAdError.domain}, code: ${loadAdError.code}, message: ${loadAdError.message}
            """
            }
        }).build()

        adLoader.loadAd(AdRequest.Builder().build())

        ///videostatus_text.text = ""
    }
}