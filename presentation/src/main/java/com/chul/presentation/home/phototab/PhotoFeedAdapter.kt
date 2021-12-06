package com.chul.presentation.home.phototab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chul.domain.model.Card
import com.chul.presentation.databinding.ViewPhotoFeedItemBinding
import com.chul.presentation.home.HomeFragmentDirections
import com.chul.presentation.home.hometab.CardDiffCallback
import com.chul.presentation.home.hometab.CardParentType
import com.chul.presentation.photodetail.PhotoDetailFragmentDirections

class PhotoFeedAdapter: PagingDataAdapter<Card, PhotoFeedViewHolder>(CardDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoFeedViewHolder {
        val binding = ViewPhotoFeedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoFeedViewHolder, position: Int) {
        holder.itemBinding.card = getItem(position)
    }
}

class PhotoFeedViewHolder(val itemBinding: ViewPhotoFeedItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

    init {
        itemBinding.root.setOnClickListener { view ->
            itemBinding.card?.let { card ->
                navigateDetail(card, view)
            }
        }
    }

    private fun navigateDetail(card: Card, view: View) {
        val direction = HomeFragmentDirections.actionHomeFragmentToPhotoDetailFragment(card.id)
        view.findNavController().navigate(direction)
    }
}