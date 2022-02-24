package com.example.fakeproductapp.feature_product_list.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeproductapp.databinding.ProductRowBinding
import com.example.fakeproductapp.feature_product_list.domain.model.ProductListModel

class ProductListAdapter (private val onClickListener: OnClickListener) : ListAdapter<ProductListModel.ProductListModelItem, RecyclerView.ViewHolder>(ProductDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharacterViewHolder(
            ProductRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class OnClickListener(val clickListener: (character: ProductListModel.ProductListModelItem) -> Unit) {
        fun onClick(character: ProductListModel.ProductListModelItem) = clickListener(character)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(character)
        }
        (holder as CharacterViewHolder).bind(character)

    }

    class CharacterViewHolder(
        private val binding: ProductRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductListModel.ProductListModelItem) {
            binding.apply {
                product = item
                executePendingBindings()
            }
        }
    }
}

private class ProductDiffCallback : DiffUtil.ItemCallback<ProductListModel.ProductListModelItem>() {

    override fun areItemsTheSame(oldItem: ProductListModel.ProductListModelItem, newItem: ProductListModel.ProductListModelItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductListModel.ProductListModelItem, newItem: ProductListModel.ProductListModelItem): Boolean {
        return oldItem == newItem
    }
}