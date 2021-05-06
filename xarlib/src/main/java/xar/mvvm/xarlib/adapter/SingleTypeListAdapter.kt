package xar.mvvm.xarlib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class SingleTypeListAdapter<T,DB: ViewDataBinding>(val resLayoutID:Int, protected val items: MutableList<T>) :
    RecyclerView.Adapter<SingleTypeViewHolder<T,DB>>() {

    lateinit var mBinding:DB
    var clickListener : ((pos:Int,item:T,mView:View) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleTypeViewHolder<T,DB> {
        val layoutInflater = LayoutInflater.from(parent.context)
        mBinding = DataBindingUtil.inflate(layoutInflater,resLayoutID,parent,false)
        return SingleTypeViewHolder(mBinding){ pos, view ->
            clickListener?.invoke(pos,items.get(pos),view)
        }
    }

    fun setOnItemClickListener(mClickListener:(position: Int, item: T,mView: View) -> Unit){
        clickListener = mClickListener
    }
    /*override fun onBindViewHolder(holder: SingleTypeViewHolder, position: Int) {
        ///itemBinder.onBindData(mBinding,holder.itemView,position,items[position])
    }*/

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
            this@SingleTypeListAdapter.items.remove(this)
            notifyDataSetChanged()
        }
    }

}