package com.chul.presentation.home.hometab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chul.domain.model.Card
import com.chul.presentation.R
import com.chul.presentation.databinding.ViewCardItemBinding
import com.chul.presentation.home.HomeFragmentDirections
import com.chul.presentation.photodetail.PhotoDetailFragmentDirections

class CardAdapter(private val type: CardParentType): ListAdapter<Card, CardViewHolder>(CardDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ViewCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding, type)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemBinding.card = getItem(position)
    }
}

class CardViewHolder(
    val itemBinding: ViewCardItemBinding,
    private val type: CardParentType
): RecyclerView.ViewHolder(itemBinding.root) {
    init {
        itemBinding.root.setOnClickListener { view ->
            itemBinding.card?.let { card ->
                navigateDetail(card, view, type)
            }
        }
    }

    private fun navigateDetail(card: Card, view: View, type: CardParentType) {
        val direction = if(type == CardParentType.HOME) {
            HomeFragmentDirections.actionHomeFragmentToPhotoDetailFragment(card.id)
        } else {
            PhotoDetailFragmentDirections.actionPhotoDetailFragmentSelf(card.id)
        }
        view.findNavController().navigate(direction)
    }
}

class CardDiffCallback: DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }

}

enum class CardParentType {
    HOME, PHOTO_DETAIL
}