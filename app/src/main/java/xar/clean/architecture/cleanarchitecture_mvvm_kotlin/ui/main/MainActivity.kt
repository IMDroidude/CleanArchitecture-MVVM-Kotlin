package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.adpterz.TestXarAdapter
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
        //TODO first way to handle adapter
        /*val testXarAdapter = TestXarAdapter(R.layout.item_fruit,fruitList){pos, mView,item ->
            toast("Clicked at $pos ->   ${item.name}")
        }
        recyclerView.adapter = testXarAdapter*/

        //TODO second way to handle adapter
        val singleTypeListAdapter = object : SingleTypeListAdapter<FruitBO,ItemFruitBinding>(R.layout.item_fruit,fruitList){
            override fun onBindViewHolder(holder: SingleTypeViewHolder<FruitBO,ItemFruitBinding>, position: Int) {
                holder.mBinding.modelItem = fruitList.get(position)
            }
        }
        singleTypeListAdapter.setOnItemClickListener{ position, item, mView ->
            toast("Clicked at $position ->   ${item.name}")
        }
        recyclerView.adapter = singleTypeListAdapter

        //TODO third way to handle adapter
        /*val genericFruitAdapter = GeneralItemAdapter<FruitBO, ItemFruitBinding>(R.layout.item_fruit,
            fruitList, object : GeneralItemBinder<FruitBO,ItemFruitBinding>{
            override fun onBindData(binding: ItemFruitBinding, itemView: View, position: Int, data: FruitBO) {
                binding.modelItem = data
                ///binding.fruitNameTv.text = data.name
            }
            override fun onItemClicked(position: Int, item:FruitBO,mView: View) {
                mView.findViewById<TextView>(R.id.fruit_name_tv).setOnClickListener {
                    toast("Clicked at $position ->   ${item.name}")
                }
            }
        })
        recyclerView.adapter = genericFruitAdapter*/
    }
}