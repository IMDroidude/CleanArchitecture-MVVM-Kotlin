package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.temp2

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.DeleteActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DeleteActivity :
    XarActivity<DeleteActivityBinding, DeleteViewModel>(R.layout.delete_activity) {
    override val mViewModel: DeleteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel


        mViewModel.deleteCommands.listen(this) {
            when (it) {

            }
        }
    }
}
