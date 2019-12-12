package com.xtendbiz.projectdemo.repository

import androidx.lifecycle.LiveData
import com.xtendbiz.projectdemo.R
import com.xtendbiz.projectdemo.ui.product.ProductData

class IProductRepoImpl : IProductRepo {
    override suspend fun getProducts(): List<ProductData> {
        return getRecentItem()
    }

    private fun getRecentItem(): List<ProductData>{
        val recentItemList = ArrayList<ProductData>()
        recentItemList.add(ProductData(300, R.drawable.blue_shirt, "V-T-Shirt", "$34.98"))
        recentItemList.add(ProductData(301, R.drawable.shoe, "Back Pack", "$20.00"))
        recentItemList.add(ProductData(302, R.drawable.normal_t_shirt, "U shape T shirt", "$11.23"))
        recentItemList.add(ProductData(303, R.drawable.blue_shirt, "Ankle Boot", "$34.98"))
        recentItemList.add(ProductData(304, R.drawable.shoe, "Normal T Shirt", "$20.00"))
        recentItemList.add(ProductData(305, R.drawable.normal_t_shirt, "Red Scarf", "$11.23"))
        return recentItemList
    }
}