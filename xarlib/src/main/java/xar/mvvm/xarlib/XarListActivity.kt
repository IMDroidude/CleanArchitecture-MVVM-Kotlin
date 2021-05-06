package xar.mvvm.xarlib

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class XarListActivity<DB: ViewDataBinding,VM: XarViewModel,T:XarModel>(@LayoutRes val resLayoutID:Int) : AppCompatActivity(
    resLayoutID) {

    lateinit var mBinding:DB
    abstract val mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,resLayoutID)
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)


    }
}