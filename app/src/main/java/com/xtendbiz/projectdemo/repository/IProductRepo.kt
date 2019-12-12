package com.xtendbiz.projectdemo.repository

import androidx.lifecycle.LiveData
import com.xtendbiz.projectdemo.ui.product.ProductData

interface IProductRepo {
    suspend fun getProducts(): List<ProductData>
}