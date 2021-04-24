package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.blank

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.NewActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewActivity : XarActivity<NewActivityBinding, NewViewModel>(R.layout.new_activity) {
    override val mViewModel: NewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel


        mViewModel.newCommands.listen(this) {
            when (it) {

            }
        }
    }
}
