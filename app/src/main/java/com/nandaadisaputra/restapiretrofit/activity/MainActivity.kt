package com.nandaadisaputra.restapiretrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nandaadisaputra.restapiretrofit.R
import com.nandaadisaputra.restapiretrofit.adapter.ShowAdapter
import com.nandaadisaputra.restapiretrofit.model.ProductModel
import com.nandaadisaputra.restapiretrofit.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var productModels: ArrayList<ProductModel>? = null
    var showAdapter: ShowAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productModels  = ArrayList()
        getData()
    }
    private fun getData() {
        val apiService = ApiClient.getApiService()
        apiService.getData().enqueue(object : Callback<ArrayList<ProductModel>> {
            override fun onResponse(
                call: Call<ArrayList<ProductModel>>,
                response: Response<ArrayList<ProductModel>>
            ) {
                if (response.isSuccessful) {
                    productModels = response.body()
                    showAdapter = productModels?.let {
                        ShowAdapter(this@MainActivity, it) }
                    rvProduct.adapter = showAdapter
                    rvProduct.layoutManager = GridLayoutManager(
                        this@MainActivity, 2)
                    showAdapter?.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<ArrayList<ProductModel>>, t: Throwable) {
                toast("There is no internet network")
            }
        })
    }
}