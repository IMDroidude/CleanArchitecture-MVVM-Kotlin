package xar.mvvm.xarlib

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class XarViewHolder<T,DB : ViewDataBinding>(binding: DB, val clicked:(pos:Int, view:View) -> Unit) : RecyclerView.ViewHolder(
    binding.root
    //LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    lateinit var mBinding: DB
    //val binding = ItemListBinding.bind(view)

    init {
        mBinding = binding
        itemView.setOnClickListener {
            it?.let { clicked.invoke(adapterPosition,it) }
        }
        /*itemView.setOnClickListener {
            it?.let {
                clicked.invoke(adapterPosition,it)
            }
        }*/
    }
}

/*
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
}*/
