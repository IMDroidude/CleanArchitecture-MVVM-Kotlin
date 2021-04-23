package xar.mvvm.xarlib.prefs

import com.google.gson.reflect.TypeToken

interface PrefStore {

    fun getString(key: String, def: String = ""): String
    fun getBoolean(key: String, def: Boolean = false): Boolean

    fun saveString(key: String, value: String?)
    fun saveBoolean(key: String, value: Boolean?)

    fun getInt(key: String, value: Int = 0): Int
    fun saveInt(key: String, value: Int)

    fun <T> getObject(key: String,typeToken: TypeToken<T>): T?
    fun <T> saveObject(key: String,value:T?)

    fun <T> getList(key: String, typeToken: TypeToken<List<T>>): List<T?>
    fun <T> saveList(key: String,value:List<T?>)

    fun remove(key: String)

}