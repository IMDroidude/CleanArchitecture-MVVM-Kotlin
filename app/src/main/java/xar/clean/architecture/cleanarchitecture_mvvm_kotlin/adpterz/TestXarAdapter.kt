package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.adpterz

import android.view.View
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.ItemFruitBinding
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.main.MainActivity
import xar.mvvm.xarlib.XarAdapter
import xar.mvvm.xarlib.XarViewHolder

class TestXarAdapter(
    resID: Int, val fruitList: List<MainActivity.FruitBO>,
    clicking: (pos: Int, mView: View, fruitBO: MainActivity.FruitBO) -> Unit
) : XarAdapter<MainActivity.FruitBO, ItemFruitBinding>(resID, fruitList, clicking) {
    override fun onBindViewHolder(
        holder: XarViewHolder<MainActivity.FruitBO, ItemFruitBinding>, position: Int
    ) {
        with(holder) {
            mBinding.modelItem = fruitList.get(position)
        }
    }
}