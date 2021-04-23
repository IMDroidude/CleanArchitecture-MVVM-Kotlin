package xar.mvvm.xarlib.prefs

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject


class SharedPrefStore @Inject constructor(context: Context) : PrefStore {

    private val sharedPrefs = context.getSharedPreferences("west_mark_prefs", Context.MODE_PRIVATE)

    override fun getInt(key: String, value: Int): Int = sharedPrefs.getInt(key, value)

    override fun saveInt(key: String, value: Int) {
        sharedPrefs.edit().putInt(key, value).apply()
    }

    override fun getBoolean(key: String, def: Boolean): Boolean {
        return sharedPrefs.getBoolean(key, def)
    }
    override fun saveBoolean(key: String, value: Boolean?) {
        sharedPrefs.edit().putBoolean(key, value ?: false).apply()
    }

    override fun getString(key: String, def: String): String {
        return sharedPrefs.getString(key, def) ?: def
    }
    override fun saveString(key: String, value: String?) {
        sharedPrefs.edit().putString(key, value).apply()
    }

    override fun remove(key: String) {
        sharedPrefs.edit().remove(key).apply()
    }

    override fun <T> getObject(key: String,typeToken: TypeToken<T>): T? {
        val json: String = getString(key, "{}")
        return Gson().fromJson(json, typeToken.type)
    }
    override fun <T> saveObject(key: String, value: T?) {
        val json = Gson().toJson(value)
        saveString(key,json)
    }

    override fun <T> getList(key: String, typeToken: TypeToken<List<T>>): List<T?> {
        return Gson().fromJson(getString(key, "[]"), typeToken.getType())
    }

    override fun <T> saveList(key: String, mList: List<T?>) {
        val gson = GsonBuilder().create()
        val jsonArray = gson.toJsonTree(mList).asJsonArray
        saveString(key,jsonArray.toString())
    }
}