package com.xtendbiz.projectdemo.ui.product

import com.bumptech.glide.Glide
import com.xtendbiz.projectdemo.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.single_product_item.view.*

class ProductItem(
    recentItem: ProductData
) : Item() {
    var recent = recentItem
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            updateImage()
            itemView.searchItemTitle.text = recent.ItemName
            itemView.searchItemCost.text = recent.ItemCost

        }
    }

    override fun getLayout() = R.layout.single_product_item

    private fun ViewHolder.updateImage() {
        Glide.with(this.containerView)
            .load(recent.Image)
            .into(containerView.searchItemImage)
    }

    override fun getSpanSize(spanCount: Int, position: Int) = spanCount / 2
}