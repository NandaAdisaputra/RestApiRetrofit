package com.nandaadisaputra.restapiretrofit.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.nandaadisaputra.restapiretrofit.R
import kotlinx.android.synthetic.main.activity_product_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ProductDetailActivity : AppCompatActivity() {
    private var idProduct: String? = null
    private var nameProduct: String? = null
    private var imageProduct: String? = null
    private var descriptionProduct: String? = null
    private var priceProduct: String? = null
    private var stockProduct: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        idProduct = intent.getStringExtra("ID_PRODUCT")
        nameProduct = intent.getStringExtra("NAME_PRODUCT")
        imageProduct = intent.getStringExtra("IMAGE_PRODUCT")
        descriptionProduct = intent.getStringExtra("DESCRIPTION_PRODUCT")
        priceProduct = intent.getStringExtra("PRICE_PRODUCT")
        stockProduct = intent.getStringExtra("STOCK_PRODUCT")
        supportActionBar?.title = nameProduct
        Glide.with(this).load(imageProduct).override(512, 512)
            .into(iv_product)
        Glide.with(this).load(imageProduct).override(512, 512)
            .into(iv_backdrop)
        tv_prices?.text = priceProduct
        tv_stock_product?.text = stockProduct
        tv_description_product?.text = descriptionProduct
        btn_edit?.onClick {
            val message = "https://api.whatsapp.com/send?phone=6282141730797" +
                    "&text=Permisi,%20Perkenalan%20nama%20saya"
            val i = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(message)
            )
            startActivity(i)
        }
    }
}