package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.test

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.TestActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TestActivity : XarActivity<TestActivityBinding, TestViewModel>(R.layout.test_activity) {
    override val mViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel

    }
}
