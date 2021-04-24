package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.templates

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.TemplatezActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TemplatezActivity :
    XarActivity<TemplatezActivityBinding, TemplatezViewModel>(R.layout.templatez_activity) {
    override val mViewModel: TemplatezViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel


    }
}
