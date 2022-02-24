package com.example.fakeproductapp.feature_product_list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fakeproductapp.databinding.ProductListBinding
import com.example.fakeproductapp.feature_product_list.presentation.adapter.ProductListAdapter
import com.example.fakeproductapp.feature_product_list.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentCharacterList : Fragment() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ProductListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = ProductListAdapter(ProductListAdapter.OnClickListener
        { product ->

            Toast.makeText(this.context, product.title, Toast.LENGTH_SHORT).show()

        })

        binding.productList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: ProductListAdapter) {
        viewModel.products.observe(viewLifecycleOwner) { products ->
            adapter.submitList(products)
        }
    }
}