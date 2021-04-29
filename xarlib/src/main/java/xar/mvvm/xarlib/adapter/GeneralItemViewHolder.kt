package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

///class GeneralItemViewHolder(parent: ViewGroup, layoutId: Int) : RecyclerView.ViewHolder(
class GeneralItemViewHolder(binding:ViewDataBinding) : RecyclerView.ViewHolder(
    binding.root
    //LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
}