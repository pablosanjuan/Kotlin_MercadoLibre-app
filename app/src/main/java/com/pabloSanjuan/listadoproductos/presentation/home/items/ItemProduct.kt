package com.pabloSanjuan.listadoproductos.presentation.home.items

import com.bumptech.glide.Glide
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.data.models.Result
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.item_product.view.*

class ItemProduct(val result: Result) : Item<ViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.item_product
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.product_title.text = result.title

        Glide.with(viewHolder.itemView)
            .load(result.thumbnail)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(viewHolder.itemView.product_thumbnail)
    }
}