package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SingleTypeViewHolder<T>(parent: ViewGroup, layoutId: Int, clicklistener : (pos: Int, aView: View) -> Unit) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)){

    init {
        itemView.setOnClickListener{
            clicklistener.invoke(adapterPosition,itemView)
        }
    }
}