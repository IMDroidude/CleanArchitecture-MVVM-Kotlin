package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.temp2

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.TempFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import xar.mvvm.xarlib.extensions.listen


@AndroidEntryPoint
class TempFragment :
    XarActivity<TempFragmentBinding, TempFragmentViewModel>(R.layout.temp_fragment) {
    override val mViewModel: TempFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel


        mViewModel.tempCommands.listen(this) {
            when (it) {

            }
        }
    }
}

