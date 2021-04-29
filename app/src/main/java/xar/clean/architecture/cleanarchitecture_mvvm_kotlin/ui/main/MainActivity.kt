package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.ItemFruitBinding
import xar.mvvm.xarlib.adapter.*

class MainActivity : AppCompatActivity() {
    data class FruitBO(val name:String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruitList = listOf<FruitBO>(FruitBO("apple"),FruitBO("mango"))
        val fruitAdapter = FruitAdapter(R.layout.item_fruit,fruitList){ pos, aView ->

        }

        // FIXME: 28/04/2021 instead of passing layout set binding in a callback which is an attribute of GeneralItemViewHolder
        // FIXME: 28/04/2021 or pass binding in constructor and return same binding in onBindData. you are good to go
        ///val generalFruitAdapter = GeneralItemAdapter(R.layout.item_fruit,fruitList,object : GeneralItemBinder<FruitBO> {
        val itemFruitBinding = DataBindingUtil.inflate<ItemFruitBinding>(layoutInflater,R.layout.item_fruit,null,false)
        val generalFruitAdapter = GeneralItemAdapter(itemFruitBinding,fruitList,object : GeneralItemBinder<FruitBO> {


            override fun onBindData(binding: ViewDataBinding,itemView: View?, position: Int, data: FruitBO) {

            }
            override fun onItemClicked(position: Int, mView: View?) {

            }
        })
    }

    // FIXME: 28/04/2021 create binding instead of passing layoutID
    class FruitAdapter(itemLayoutID:Int,fruits:List<FruitBO>,fruititemClicked : (pos: Int, aView: View) -> Unit):SingleTypeListAdapter<FruitBO>(
        itemLayoutID,fruits,fruititemClicked){
        override fun onBindViewHolder(holder: SingleTypeViewHolder<FruitBO>, position: Int) {
            // FIXME: 28/04/2021 add binding along with holder to set Data for all items

        }
    }
}