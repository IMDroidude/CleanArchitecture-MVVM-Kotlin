package xar.mvvm.xarlib.adapter

import android.view.View
import androidx.databinding.ViewDataBinding

interface GeneralItemBinder<T,DB:ViewDataBinding> {
    fun onBindData(binding: DB,itemView: View, position: Int, data: T)
    fun onItemClicked(position: Int, item: T,mView: View)

}