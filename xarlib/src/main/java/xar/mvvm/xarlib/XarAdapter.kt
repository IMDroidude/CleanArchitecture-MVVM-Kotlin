package xar.mvvm.xarlib

import androidx.recyclerview.widget.RecyclerView

abstract class XarAdapter<T>(protected val items: List<T>) : RecyclerView.Adapter<XarViewHolder<T>>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: XarViewHolder<T>, position: Int) {
        holder.bindData(items.get(position))
    }
}