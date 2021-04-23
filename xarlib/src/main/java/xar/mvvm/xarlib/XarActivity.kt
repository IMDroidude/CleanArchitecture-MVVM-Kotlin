package xar.mvvm.xarlib

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.BuildConfig
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import xar.mvvm.xarlib.adapter.OnAdapterBind
import xar.mvvm.xarlib.adapter.SingleTypeListAdapter
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

    lateinit var recyclerView:RecyclerView

    var adView: AdView? = null

    abstract fun setAdUnitID():String

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
        ///_binding = null
    }

    fun getAdaptiveBannerSize():AdSize{
        val windowWidth = resources.configuration.screenWidthDp
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this,windowWidth)
    }

    fun loadBanner(frameContainer:FrameLayout){
        if(setAdUnitID().isNotEmpty()){
            adView = AdView(this)
            val adRequest = AdRequest.Builder().build()
            adView?.let {
                adView?.apply {
                    adUnitId = setAdUnitID()
                    adSize = getAdaptiveBannerSize()
                    loadAd(adRequest)

                }
                frameContainer.removeAllViews()
                frameContainer.addView(adView)
            }
        } else {
            if(BuildConfig.DEBUG){
                toast("Bhai jan adUnit empty di hue hai")
            }
        }

    }
}