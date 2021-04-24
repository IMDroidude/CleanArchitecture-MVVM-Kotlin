package ${packageName}

import android.os.Bundle
import androidx.activity.viewModels
import ${applicationPackage}.R
///import ${applicationPackage}.base.AppActivity
import xar.mvvm.xarlib.XarActivity
import ${applicationPackage}.databinding.${layoutName?replace('_', ' ')?capitalize?replace(' ','')}Binding
import dagger.hilt.android.AndroidEntryPoint
import xar.mvvm.xarlib.extensions.listen


@AndroidEntryPoint
class ${activityClass} : XarActivity<${layoutName?replace('_', ' ')?capitalize?replace(' ','')}Binding,${viewModelName}>(R.layout.${layoutName}) {
	override val mViewModel: ${viewModelName} by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel
		
		
		mViewModel.${classToResource(activityClass)}Commands.listen(this) {
            when (it) {
                
            }
        }
    }
}
