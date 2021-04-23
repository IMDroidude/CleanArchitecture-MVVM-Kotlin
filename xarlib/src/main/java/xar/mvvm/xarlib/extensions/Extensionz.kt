package xar.mvvm.xarlib.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.*
import kotlin.reflect.KClass


typealias ClassLiveData = MutableLiveData<KClass<*>>


inline fun <T> LiveData<T>.listen(
    lifecycleOwner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T) {
            observer.invoke(t)
            ///removeObserver(this)
        }
    })
}

// https://medium.com/hongbeomi-dev/using-extension-function-livedata-713441495d0d
inline fun <T> LiveData<T>.observeOnce(
    lifecycleOwner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T) {
            observer.invoke(t)
            removeObserver(this)
        }
    })
}

// https://medium.com/hongbeomi-dev/using-extension-function-livedata-713441495d0d
inline fun <T, S> MediatorLiveData<T>.combineSourceData(
    vararg sources: LiveData<S>,
    crossinline observer: () -> T
) {
    sources.forEach {
        this.addSource(it) { value = observer.invoke() }
    }
}

inline fun Context.toast(message:String,durationLong:Boolean = true){
    Toast.makeText(this, message , if(durationLong)Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}


// https://medium.com/android-news/launching-activities-in-easier-way-using-kotlin-extensions-121a8175220c

inline fun <reified T : Activity> Context.launchActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}


fun <T> Context.launchActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}