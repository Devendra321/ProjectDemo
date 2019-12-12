package com.xtendbiz.projectdemo.ui.product

import androidx.lifecycle.ViewModel
import com.xtendbiz.projectdemo.base.lazyDeferred
import com.xtendbiz.projectdemo.repository.IProductRepo

class ProductViewModel(
    private val repo: IProductRepo
) : ViewModel() {
    val getProducts by lazyDeferred {
        repo.getProducts()
    }
}