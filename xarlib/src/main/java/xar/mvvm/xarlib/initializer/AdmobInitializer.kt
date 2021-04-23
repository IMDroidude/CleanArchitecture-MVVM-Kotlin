package xar.mvvm.xarlib.initializer

import android.content.Context
import androidx.startup.Initializer
import com.google.android.gms.ads.MobileAds

class AdmobInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        MobileAds.initialize(context) { }

    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
    /*override fun create(context: Context): WorkManager {
        val configuration = Configuration.Builder().build()
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }
    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }*/
}