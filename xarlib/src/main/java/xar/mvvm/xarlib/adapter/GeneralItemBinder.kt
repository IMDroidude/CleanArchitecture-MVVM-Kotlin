package xar.mvvm.xarlib.adapter

import android.view.View
import androidx.databinding.ViewDataBinding

interface GeneralItemBinder<T> {
    fun onBindData(binding: ViewDataBinding,itemView: View?, position: Int, data: T)
    fun onItemClicked(position: Int, mView: View?)

}