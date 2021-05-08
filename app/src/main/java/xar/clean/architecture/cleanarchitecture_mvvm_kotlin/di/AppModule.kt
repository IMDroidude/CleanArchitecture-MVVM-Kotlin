package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import xar.mvvm.xarlib.prefs.PrefStore
import xar.mvvm.xarlib.prefs.SharedPrefStore

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providePrefContext(@ApplicationContext context: Context): PrefStore {
        return SharedPrefStore(context)
    }
}