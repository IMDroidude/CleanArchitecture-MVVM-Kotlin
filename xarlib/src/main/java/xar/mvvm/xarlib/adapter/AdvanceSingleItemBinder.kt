package xar.mvvm.xarlib.adapter

import android.view.View
import androidx.databinding.ViewDataBinding

interface AdvanceSingleItemBinder<T, DB : ViewDataBinding> {
    fun onItemClicked(position: Int, item: T, mView: View)
}