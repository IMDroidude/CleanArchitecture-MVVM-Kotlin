package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
///import xar.mvvm.xarlib.BR

class AdvanceSingleItemAdapter<T,DB: ViewDataBinding>(val resLayoutID:Int, protected val items: List<T>,
val itemClicked:(pos:Int,current:T,view:View) -> Unit) :
    RecyclerView.Adapter<GeneralItemViewHolder>() {

    lateinit var mItemBinding:DB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        mItemBinding = DataBindingUtil.inflate(layoutInflater,resLayoutID,parent,false)
        return GeneralItemViewHolder(mItemBinding){ pos, view ->
            itemClicked.invoke(pos,items[pos],view)
        }
    }

    override fun onBindViewHolder(holder: GeneralItemViewHolder, position: Int) {
        //mItemBinding.setVariable(BR.modelItem,items.get(position))
        ///mItemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = items.size
}