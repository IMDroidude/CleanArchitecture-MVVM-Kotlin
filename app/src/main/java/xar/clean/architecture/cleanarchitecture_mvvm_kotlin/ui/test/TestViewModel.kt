package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.test

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

@HiltViewModel
class TestViewModel @Inject constructor(

) : XarViewModel() //change it to AppViewModel when upgrade
{


}
