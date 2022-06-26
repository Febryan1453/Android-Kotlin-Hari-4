package com.febryan.idnnews.api

import com.febryan.idnnews.model.ResponseNewsIdn
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("list_artikel.php")
    fun getNewsIdn(): Call<ResponseNewsIdn>

}