package xar.mvvm.xarlib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

//typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class XarFragment<DB: ViewDataBinding,VM: XarViewModel>(@LayoutRes val resLayoutID:Int) : Fragment() {

    private var _binding: DB? = null
    val mBinding get() = _binding!!
    abstract val mViewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,resLayoutID,container,false)//inflater.invoke(inflater, container, false)
        return mBinding.root
        ///return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}