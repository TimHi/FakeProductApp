package com.example.fakeproductapp.feature_product_list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.fakeproductapp.feature_product_list.domain.model.ProductListModel
import com.example.fakeproductapp.feature_product_list.domain.use_case.ProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productListUseCase: ProductListUseCase) :
    ViewModel() {
    val products : LiveData<ProductListModel> = getCharacterLiveData()

    private fun getCharacterLiveData() = liveData {
        emit(productListUseCase())
    }

    fun filterProducts(position: String) {

    }
}