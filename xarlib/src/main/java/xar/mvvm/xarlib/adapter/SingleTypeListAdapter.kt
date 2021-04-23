package xar.mvvm.xarlib.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SingleTypeListAdapter<T>(protected val items: List<T>, val adapterBind: OnAdapterBind<T>)
    : RecyclerView.Adapter<SingleTypeViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleTypeViewHolder<T> = SingleTypeViewHolder(parent, viewType
        ) { position, mView ->
            adapterBind.onItemClicked(position, mView)
        }

    override fun getItemCount(): Int = items.size
    //override fun getItemViewType(position: Int): Int = adapterBind.setLayoutId(position, items[position]);

    override fun onBindViewHolder(holder: SingleTypeViewHolder<T>, position: Int) {
        adapterBind.onBindData(holder.itemView, position,items[position])
    }
}