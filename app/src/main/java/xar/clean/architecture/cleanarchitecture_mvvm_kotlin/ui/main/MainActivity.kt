package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.ItemFruitBinding
import xar.mvvm.xarlib.adapter.*
import xar.mvvm.xarlib.extensions.toast

class MainActivity : AppCompatActivity() {
    data class FruitBO(val name:String)
    lateinit var recyclerView: RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val fruitList = listOf<FruitBO>(FruitBO("apple"),FruitBO("mango"),
            FruitBO("Banana"), FruitBO("strawberry")
        )
        /*val fruitAdapter = FruitAdapter(R.layout.item_fruit,fruitList){ pos, aView ->

        }*/

        // FIXME: 28/04/2021 instead of passing layout set binding in a callback which is an attribute of GeneralItemViewHolder
        // FIXME: 28/04/2021 or pass binding in constructor and return same binding in onBindData. you are good to go
        ///val generalFruitAdapter = GeneralItemAdapter(R.layout.item_fruit,fruitList,object : GeneralItemBinder<FruitBO> {
        ///val itemFruitBinding = DataBindingUtil.inflate<ItemFruitBinding>(layoutInflater,R.layout.item_fruit,null,false)
        val genericFruitAdapter = GeneralItemAdapter<FruitBO,ItemFruitBinding>(R.layout.item_fruit,fruitList,
        object : GeneralItemBinder<FruitBO,ItemFruitBinding>{
            override fun onBindData(binding: ItemFruitBinding, itemView: View, position: Int, data: FruitBO) {
                binding.fruitNameTv.text = data.name
            }

            override fun onItemClicked(position: Int, mView: View) {
                toast("Clicked at $position")
            }
        })
        recyclerView.adapter = genericFruitAdapter


        /*val generalFruitAdapter = GeneralItemAdapter(itemFruitBinding,fruitList,object : GeneralItemBinder<FruitBO> {

            override fun onBindData(binding: ViewDataBinding,itemView: View?, position: Int, data: FruitBO) {
            }
            override fun onItemClicked(position: Int, mView: View?) {
            }
        })*/
    }

    // FIXME: 28/04/2021 create binding instead of passing layoutID
    class FruitAdapter(itemLayoutID:Int,fruits:List<FruitBO>,fruititemClicked : (pos: Int, aView: View) -> Unit):SingleTypeListAdapter<FruitBO>(
        itemLayoutID,fruits,fruititemClicked){
        override fun onBindViewHolder(holder: SingleTypeViewHolder<FruitBO>, position: Int) {
            // FIXME: 28/04/2021 add binding along with holder to set Data for all items

        }
    }
}