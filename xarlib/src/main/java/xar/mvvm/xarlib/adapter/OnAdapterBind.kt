package xar.mvvm.xarlib.adapter

import android.view.View

interface OnAdapterBind<T> {
    ///GeneralViewHolder setViewHolder(ViewGroup parent,int viewType);
    fun onBindData(itemView: View?, position: Int,data: T)
    //fun setLayoutId(position: Int, obj: T): Int
    fun onItemClicked(position: Int, mView: View?)
}
