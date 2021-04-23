package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.authentication

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
///import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.AuthActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.utils.AppConstants
import xar.mvvm.xarlib.extensions.listen


@AndroidEntryPoint
class AuthActivity : XarActivity<AuthActivityBinding, AuthViewModel>(R.layout.auth_activity) {
    override val mViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel

        ///mBinding.userBo = UserBo()
        mViewModel.authCommands.listen(this){
            when(it){
                is AuthViewModel.AuthAction.ShowLoader -> {

                }
                is AuthViewModel.AuthAction.AuthSuccess -> {
                    it.response
                }
                is AuthViewModel.AuthAction.UserNameOrEmailInvalid -> {
                    if(it.lengthInvalid){

                    }
                }
                is AuthViewModel.AuthAction.AuthorizationTokenExpire -> {

                }
            }
        }
    }

    override fun setAdUnitID() = AppConstants.Banner
}
