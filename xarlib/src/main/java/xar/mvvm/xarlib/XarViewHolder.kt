package xar.mvvm.xarlib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
abstract class XarViewHolder<T>(parent: ViewGroup, layoutId: Int,
                                val onItemClicked: (pos:Int,view:View) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)) {

    init {
        itemView.setOnClickListener{
            onItemClicked.invoke(adapterPosition,itemView)
        }
    }
    abstract fun bindData(data:T)
}