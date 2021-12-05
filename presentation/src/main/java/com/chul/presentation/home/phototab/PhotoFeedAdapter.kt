package com.chul.presentation.home.phototab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chul.domain.model.Card
import com.chul.presentation.databinding.ViewPhotoFeedItemBinding
import com.chul.presentation.home.hometab.CardDiffCallback

class PhotoFeedAdapter: ListAdapter<Card, PhotoFeedViewHolder>(CardDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoFeedViewHolder {
        val binding = ViewPhotoFeedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoFeedViewHolder, position: Int) {
        holder.itemBinding.card = getItem(position)
    }
}

class PhotoFeedViewHolder(val itemBinding: ViewPhotoFeedItemBinding): RecyclerView.ViewHolder(itemBinding.root)