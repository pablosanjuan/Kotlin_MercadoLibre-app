package com.pabloSanjuan.listadoproductos.presentation.home.items

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.data.models.Result
import com.pabloSanjuan.listadoproductos.presentation.details.DetailsFragment.Companion.RESULT_DATA
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.item_product.view.*

class ItemProduct(val result: Result) : Item<ViewHolder>() {

    /**
     * Pablo Sanjuan
     *
     * Por medio de la libreria GROUPIE evito crear viewHolder ya que esta libreria me provee
     * na instancias de ello y solo requiero implementar el BIND
     *
     * haciendo uso de GLIDE para cargar las imagenes
     */

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

        viewHolder.itemView.product_ver_mas.setOnClickListener{
            val bundle = bundleOf(RESULT_DATA to result)
            it.findNavController().navigate(R.id.action_homeFragment2_to_detailsFragment, bundle)
        }
    }
}