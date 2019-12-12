package com.xtendbiz.projectdemo.ui.product

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.xtendbiz.projectdemo.R
import com.xtendbiz.projectdemo.ViewModelFactory
import com.xtendbiz.projectdemo.base.ScopedActivity
import com.xtendbiz.projectdemo.base.obtainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance


class ProductActivity : ScopedActivity(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: ViewModelFactory by instance()
    lateinit var productViewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        productViewModel = vm
        getProducts()

    }

    private val vm by lazy {
        obtainViewModel(ProductViewModel::class.java, viewModelFactory)
    }

    private fun getProducts() = launch {
        val result = productViewModel.getProducts.await()
        initProductRecyclerView(result.map {
            ProductItem(it)
        })
    }

    private fun initProductRecyclerView(items: List<ProductItem>) {
        val searchGroupAdapter = GroupAdapter<ViewHolder>()
            .apply {
                spanCount = 2
                addAll(items)
            }

        productRecyclerView.apply {
            layoutManager = GridLayoutManager(context, searchGroupAdapter.spanCount).apply {
                spanSizeLookup = searchGroupAdapter.spanSizeLookup
            }
            adapter = searchGroupAdapter
        }

        searchGroupAdapter.setOnItemClickListener { item, _ ->
            (item as? ProductItem)?.let {
                Toast.makeText(this, "You clicked: ${it.recent.ItemName}", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
