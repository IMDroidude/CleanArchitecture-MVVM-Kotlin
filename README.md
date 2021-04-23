# CleanArchitecture-MVVM-Kotlin

-🐔🐔🐔 CleanArchitecture-MVVM-Kotlin Library to speed up work
- I will also add code templates to speed up work.

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
                is SplashViewModel.SplashCommand.OpenNextScreen -> {
                    launchActivity(it.className.java)
                }
                is SplashViewModel.SplashCommand.ShowToast -> {
                    toast(it.title)
                }
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


```
