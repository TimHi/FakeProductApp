package com.example.fakeproductapp.feature_product_list.data

import com.google.gson.JsonArray
import retrofit2.http.GET

interface APIs {
    @GET("products")
    suspend fun getProducts(): JsonArray
}
