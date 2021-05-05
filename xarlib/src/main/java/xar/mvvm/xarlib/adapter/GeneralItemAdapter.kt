package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class GeneralItemAdapter<T,DB:ViewDataBinding>(val resLayoutID:Int,
                            protected val items: MutableList<T>,
                            val itemBinder: GeneralItemBinder<T,DB>) :
    RecyclerView.Adapter<GeneralItemViewHolder>() {

    lateinit var mBinding:DB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        mBinding = DataBindingUtil.inflate(layoutInflater,resLayoutID,parent,false)
        return GeneralItemViewHolder(mBinding){ pos, view ->
            itemBinder.onItemClicked(pos,items.get(pos),view)
        }
    }

    override fun onBindViewHolder(holder: GeneralItemViewHolder, position: Int) {
        itemBinder.onBindData(mBinding,holder.itemView,position,items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int = items.size


    fun setList(listItems: List<T>) {
        if (listItems.isNotEmpty()) {
            this.items.addAll(listItems)
            notifyDataSetChanged()
        }
    }

    fun replaceList(listItems: List<T>) {
        this.items.clear()
        this.items.addAll(listItems)
        notifyDataSetChanged()
    }

    fun clearList() {
        this.items.clear()
        notifyDataSetChanged()

    }


    fun T.removeItem() {
        if (items.isNotEmpty()) {
            this@GeneralItemAdapter.items.remove(this)
            notifyDataSetChanged()
        }
    }

}