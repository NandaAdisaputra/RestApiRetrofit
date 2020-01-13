package com.nandaadisaputra.restapiretrofit.network

import com.nandaadisaputra.restapiretrofit.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("api/barang")
    //take data dari api/barang
    fun getData(): Call<ArrayList<ProductModel>>

}