package xar.mvvm.xarlib.test

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import xar.mvvm.xarlib.generics.GenericAdapter

data class FruitBO(val name:String)
class TestGenericAdapter : GenericAdapter<FruitBO>() {
    override fun getLayoutId(position: Int, obj: FruitBO): Int {
        TODO("Not yet implemented")
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }
}