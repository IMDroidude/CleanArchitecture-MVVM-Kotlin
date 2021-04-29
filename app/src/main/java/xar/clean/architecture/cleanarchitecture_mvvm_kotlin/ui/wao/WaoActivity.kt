package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.wao

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.WaoActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WaoActivity : XarActivity<WaoActivityBinding, WaoViewModel>(R.layout.wao_activity) {
    override val mViewModel: WaoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel

    }
}
