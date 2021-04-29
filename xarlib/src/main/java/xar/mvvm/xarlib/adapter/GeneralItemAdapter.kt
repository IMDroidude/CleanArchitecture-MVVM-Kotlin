package xar.mvvm.xarlib.adapter

import android.view.ViewGroup
import androidx.databinding.DataBinderMapper
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import xar.mvvm.xarlib.DataBinderMapperImpl

// FIXME: 28/04/2021 add binding to the adapter
class GeneralItemAdapter<T>(//val itemResLayoutID: Int,
                            val binding: ViewDataBinding,
                            protected val items: List<T>,
                            val generlItemBinder: GeneralItemBinder<T>) : 
    RecyclerView.Adapter<GeneralItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralItemViewHolder {

        /*DataBindingUtil.
        DataBinderMapper
        DataBinderMapperImpl*/
        return GeneralItemViewHolder(binding)
        //return GeneralItemViewHolder(parent,itemResLayoutID)
    }

    override fun onBindViewHolder(holder: GeneralItemViewHolder, position: Int) {
        generlItemBinder.onBindData(binding,holder.itemView,position,items[position])
    }

    override fun getItemCount(): Int = items.size
}