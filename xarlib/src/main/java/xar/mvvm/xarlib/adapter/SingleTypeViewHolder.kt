package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class SingleTypeViewHolder<T,DB : ViewDataBinding>(binding: DB, val clicked:(pos:Int, view:View) -> Unit) : RecyclerView.ViewHolder(
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
class SingleTypeViewHolder<T>(parent: ViewGroup, layoutId: Int, clicklistener : (pos: Int, aView: View) -> Unit) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)){

    init {
        itemView.setOnClickListener{
            clicklistener.invoke(adapterPosition,itemView)
        }
    }
}*/

/*class SingleTypeViewHolder(binding: ViewDataBinding, val clicked:(pos:Int, view:View) -> Unit) : RecyclerView.ViewHolder(
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
}*/

