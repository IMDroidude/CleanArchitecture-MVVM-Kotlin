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

class XarFragment<DB: ViewDataBinding,VM: XarViewModel>(@LayoutRes val resLayoutID:Int) : Fragment() {

    private var _binding: DB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,resLayoutID,container,false)//inflater.invoke(inflater, container, false)
        return binding.root
        ///return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}