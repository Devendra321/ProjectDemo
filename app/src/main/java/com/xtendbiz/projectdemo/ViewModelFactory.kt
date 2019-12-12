package com.xtendbiz.projectdemo


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xtendbiz.projectdemo.repository.IProductRepo
import com.xtendbiz.projectdemo.ui.product.ProductViewModel


class ViewModelFactory constructor(
    private var repo: IProductRepo

) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(ProductViewModel::class.java) ->
                    ProductViewModel(repo)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T


}