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

    override fun setAdUnitID() = AppConstants.Banner
}

```

