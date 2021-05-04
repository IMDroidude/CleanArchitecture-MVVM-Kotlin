package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.splash

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.SplashActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.main.MainActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.utils.AppConstants
import xar.mvvm.xarlib.extensions.launchActivity
import xar.mvvm.xarlib.extensions.listen
import xar.mvvm.xarlib.extensions.toast

@AndroidEntryPoint
class SplashActivity : XarActivity<SplashActivityBinding, SplashViewModel>(R.layout.splash_activity) {
    override val mViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel

        ///lifecycle.addObserver(SplashActivity.class:jav)
        lifecycleScope.launchWhenStarted {
            mViewModel.commandFlow.collect {
                when (it) {
                    is SplashViewModel.SplashCommand.OpenNextScreen -> launchActivity(it.className.java)
                    is SplashViewModel.SplashCommand.ShowToast -> toast(it.title)
                    ////is SplashViewModel.SplashCommand.NetworkErro -> {}
                }
            }
        }

    }
}
