# CleanArchitecture-MVVM-Kotlin

-🐔🐔🐔 **CleanArchitecture-MVVM-Kotlin** Library to speed up work
- Code Templates Video attached. Auto build Activity,ViewModel along with it's binding. See Video
- 

## Project Features
- 100% Kotlin
- Modern Architecture
- MVVM (Model-View-ViewModel)
- Single-activity Architecture using Navigation
- implements separation of concern practices
- Material design guidelines
- Kotlin Coroutines
- REST API
Libraries Used
Retrofit - networking
Android Jetpack - Navigation, ViewModel, LifeCycle, LiveData
Kotlin Coroutines - for background processing
Moshi - for JSON parsing
Timber - logging
Room - data caching and offline data (coded but not implemented yet)
License




## Features
- MVVM JetPack Components：LiveData、ViewModel、Lifecycle、Navigation
- Co-routine, Kotlin, Admob Integration
- Hilt integrated
- Added Extensions


  <b>Automatic viewBinding and viewModel in activity like</b>
  
  ```
   @AndroidEntryPoint
   class SplashActivity : XarActivity<SplashActivityBinding, SplashViewModel>(R.layout.splash_activity) {
       override val mViewModel: SplashViewModel by viewModels()

       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           mBinding.mViewModel = this.mViewModel

           mViewModel.splashCommands.listen(this) {
               when (it) {
                   is SplashViewModel.SplashCommand.OpenNextScreen -> launchActivity(it.className.java)
                   is SplashViewModel.SplashCommand.ShowToast -> toast(it.title)
               }
           }
       }
   }

```

@HiltViewModel
class SplashViewModel @Inject constructor(
   @ApplicationContext val context:Context) : XarViewModel() 
{
    private val _splashCommands = MutableLiveData<SplashCommand>()
    val splashCommands : LiveData<SplashCommand> get() = _splashCommands
   
    init {
        viewModelScope.launch {
		   _splashCommands.postValue(SplashCommand.ShowToast("Welcome User"))
           delay(2000)
           _splashCommands.postValue(SplashCommand.OpenNextScreen(MainActivity::class))  
        }
    }

    sealed class SplashCommand {
        class OpenNextScreen(val className: KClass<*>) : SplashCommand()
        class ShowToast(val title:String):SplashCommand()
    }
}


## Pre-requiste -

	_ Add meta data of google appllcationID
	<meta-data
		android:name="com.google.android.gms.ads.APPLICATION_ID"
		android:value="@string/your_app_id" />
		
		
	multiDexEnabled true  
	dont' forge to add
	api project(path: ':xarlib') at your app level


```

## Things to implement
  - Interstitial Ads  - DONE
  - Force Update
  - Rating Dialog
  - Generic Adapter DONE
  - Add acivity to manifest if possible using templates 
  - Facebook Ads
  - Android Billing
