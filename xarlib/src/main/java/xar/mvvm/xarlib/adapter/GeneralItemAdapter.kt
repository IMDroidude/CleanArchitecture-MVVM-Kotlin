package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class GeneralItemAdapter<T,DB:ViewDataBinding>(val resLayoutID:Int,
                            protected val items: List<T>,
                            val generlItemBinder: GeneralItemBinder<T,DB>) :
    RecyclerView.Adapter<GeneralItemViewHolder>() {

    lateinit var mBinding:DB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        mBinding = DataBindingUtil.inflate(layoutInflater,resLayoutID,parent,false)
        return GeneralItemViewHolder(mBinding){ pos, view ->
            generlItemBinder.onItemClicked(pos,view)
        }
    }

    override fun onBindViewHolder(holder: GeneralItemViewHolder, position: Int) {
        generlItemBinder.onBindData(mBinding,holder.itemView,position,items[position])
    }

    override fun getItemCount(): Int = items.size
}