package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import xar.mvvm.xarlib.prefs.PrefStore
import xar.mvvm.xarlib.prefs.SharedPrefStore

@Module
@InstallIn(ViewModelComponent::class)
abstract class UtilModule {

    @Binds
    abstract fun bindPrefStore(
        sharedPrefStore: SharedPrefStore
    ): PrefStore
}