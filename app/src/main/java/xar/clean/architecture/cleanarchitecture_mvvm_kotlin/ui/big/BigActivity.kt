package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.big

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.BigActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BigActivity : XarActivity<BigActivityBinding, BigViewModel>(R.layout.big_activity) {
    override val mViewModel: BigViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel


        mViewModel.bigCommands.listen(this) {
            when (it) {

            }
        }
    }
}
