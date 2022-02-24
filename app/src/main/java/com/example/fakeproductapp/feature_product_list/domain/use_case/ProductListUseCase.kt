package com.example.fakeproductapp.feature_product_list.domain.use_case

import com.example.fakeproductapp.feature_product_list.data.APIs
import com.example.fakeproductapp.feature_product_list.domain.model.ProductListModel
import com.google.gson.Gson
import javax.inject.Inject

class ProductListUseCase @Inject constructor(
    private val apIs: APIs
) {
    suspend operator fun invoke(): ProductListModel {
        val resultList = apIs.getProducts()

        return Gson().fromJson(resultList, ProductListModel::class.java)
    }
}