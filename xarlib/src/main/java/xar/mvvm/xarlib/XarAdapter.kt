package xar.mvvm.xarlib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class XarAdapter<T, DB : ViewDataBinding>(
    @LayoutRes val itemResLayoutID: Int,
    protected val items: List<T>,
    val clicked: (pos: Int, aView: View,data: T) -> Unit
) : RecyclerView.Adapter<XarViewHolder<T, DB>>() {

    lateinit var mBinding: DB

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): XarViewHolder<T, DB> {
        val layoutInflater = LayoutInflater.from(parent.context)
        mBinding = DataBindingUtil.inflate(layoutInflater, itemResLayoutID, parent, false)
        return XarViewHolder(mBinding) { pos, view ->
            clicked.invoke(pos,view,items.get(pos))
            ///itemBinder.onItemClicked(pos,items.get(pos),view)
        }
    }

    /*override fun onBindViewHolder(holder: XarViewHolder<T>, position: Int) {
    }*/
    /*override fun onBindViewHolder(holder: XarViewHolder<T>, position: Int) {
        holder.bindData(items.get(position))
    }*/
}