package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

///class GeneralItemViewHolder(parent: ViewGroup, layoutId: Int) : RecyclerView.ViewHolder(
class GeneralItemViewHolder(binding:ViewDataBinding,val clicked:(pos:Int,view:View) -> Unit) : RecyclerView.ViewHolder(
    binding.root
    //LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    init {
        itemView.setOnClickListener {
            it?.let {
                clicked.invoke(adapterPosition,it)
            }
        }
    }
}