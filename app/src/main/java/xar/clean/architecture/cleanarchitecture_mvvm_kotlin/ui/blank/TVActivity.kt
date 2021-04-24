package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.blank

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.TVActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TVActivity : XarActivity<TVActivityBinding, TVViewModel>(R.layout.t_v_activity) {
    override val mViewModel: TVViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel


        mViewModel.t_vCommands.listen(this) {
            when (it) {

            }
        }
    }
}
