package ${packageName}

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import xar.mvvm.xarlib.XarViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

@HiltViewModel
class ${viewModelName} @Inject constructor(

) : XarViewModel() //change it to AppViewModel when upgrade
{
    
	private val _${classToResource(activityClass)}Commands = MutableLiveData<${viewModelName}Commands>()
    val ${classToResource(activityClass)}Commands : LiveData<${viewModelName}Commands> get() = _${classToResource(activityClass)}Commands
	
	

	sealed class ${viewModelName}Commands {
        class OpenNextScreen(val className: KClass<*>) : ${viewModelName}Commands()
        class ShowToast(val title:String):${viewModelName}Commands()
	}
}