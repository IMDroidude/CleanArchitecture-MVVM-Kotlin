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
        val fruitList = mutableListOf<FruitBO>(FruitBO("apple"),FruitBO("mango"),
            FruitBO("Banana"), FruitBO("strawberry"),
            FruitBO("PineApple"), FruitBO("Peach"),
            FruitBO("Apricot"), FruitBO("Guava")
        )
        val genericFruitAdapter = GeneralItemAdapter<FruitBO, ItemFruitBinding>(R.layout.item_fruit,
            fruitList, object : GeneralItemBinder<FruitBO,ItemFruitBinding>{
            override fun onBindData(binding: ItemFruitBinding, itemView: View, position: Int, data: FruitBO) {
                binding.fruitNameTv.text = data.name
            }
            override fun onItemClicked(position: Int, item:FruitBO,mView: View) {
                toast("Clicked at $position ->   ${item.name}")
            }
        })
        recyclerView.adapter = genericFruitAdapter
    }

    // FIXME: 28/04/2021 create binding instead of passing layoutID
    class FruitAdapter(itemLayoutID:Int,fruits:List<FruitBO>,fruititemClicked : (pos: Int, aView: View) -> Unit):SingleTypeListAdapter<FruitBO>(
        itemLayoutID,fruits,fruititemClicked){
        override fun onBindViewHolder(holder: SingleTypeViewHolder<FruitBO>, position: Int) {
            // FIXME: 28/04/2021 add binding along with holder to set Data for all items

        }
    }
}