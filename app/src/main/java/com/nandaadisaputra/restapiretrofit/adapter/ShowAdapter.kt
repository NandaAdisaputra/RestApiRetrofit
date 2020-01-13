package com.nandaadisaputra.restapiretrofit.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nandaadisaputra.restapiretrofit.R
import com.nandaadisaputra.restapiretrofit.activity.ProductDetailActivity
import com.nandaadisaputra.restapiretrofit.model.ProductModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class ShowAdapter(
    private val context: Activity?,
    private val productModel: ArrayList<ProductModel>
)
    : RecyclerView.Adapter<ShowAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list, parent,
                false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        productModel[position].let { holder.bindItem(it) }
    }
    override fun getItemCount(): Int = productModel.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(productModel: ProductModel) {
            itemView.tv_name.text = productModel.namaBarang
            itemView.tv_prices.text = productModel.hargaBarang
            productModel.imageBarang?.let { Picasso.get().load(it).into(itemView.iv_product) }

            itemView.onClick {
                itemView.context?.startActivity(
                    itemView.context.intentFor<ProductDetailActivity>(
                        "ID_PRODUCT" to productModel.idBarang,
                        "NAME_PRODUCT" to productModel.namaBarang,
                        "IMAGE_PRODUCT" to productModel.imageBarang,
                        "DESCRIPTION_PRODUCT" to productModel.deskripsiBarang,
                        "PRICE_PRODUCT" to productModel.hargaBarang,
                        "PRICE_PRODUCT" to productModel.hargaBarang,
                        "STOCK_PRODUCT" to productModel.stokBarang
                    )
                )
            }
        }

    }
}