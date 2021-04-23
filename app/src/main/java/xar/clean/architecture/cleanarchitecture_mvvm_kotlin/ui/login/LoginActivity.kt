package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.LoginActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : XarActivity<LoginActivityBinding, LoginViewModel>(R.layout.login_activity) {
    override val mViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel
    }

    override fun setAdUnitID(): String = ""
}
