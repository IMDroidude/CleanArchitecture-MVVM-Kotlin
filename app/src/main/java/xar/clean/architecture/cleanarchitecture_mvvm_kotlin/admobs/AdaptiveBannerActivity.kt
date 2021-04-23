package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.admobs

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.AdaptiveBannerActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.utils.AppConstants


@AndroidEntryPoint
class AdaptiveBannerActivity :
    XarActivity<AdaptiveBannerActivityBinding, AdaptiveBannerViewModel>(R.layout.adaptive_banner_activity) {
    override val mViewModel: AdaptiveBannerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel

        mBinding.frameAdContainer.postDelayed({
            loadBanner(mBinding.frameAdContainer, AppConstants.admobID)
        }, 1000)
    }

}