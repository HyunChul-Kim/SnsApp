package com.chul.presentation.home.hometab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chul.domain.model.Card
import com.chul.presentation.databinding.ViewCardItemBinding

class CardAdapter: ListAdapter<Card, CardViewHolder>(CardDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ViewCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemBinding.card = getItem(position)
    }
}

class CardViewHolder(val itemBinding: ViewCardItemBinding): RecyclerView.ViewHolder(itemBinding.root)

class CardDiffCallback: DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }

}