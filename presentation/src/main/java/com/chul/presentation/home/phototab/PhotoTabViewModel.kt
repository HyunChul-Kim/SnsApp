package com.chul.presentation.home.phototab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.chul.data.repository.CardPagingRepository
import com.chul.data.source.remote.card.CardPagingSource
import com.chul.domain.model.Card
import com.chul.domain.usecase.GetPhotoFeedUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoTabViewModel @Inject constructor(
    private val cardPagingRepository: CardPagingRepository
): ViewModel() {

    val cardList: LiveData<PagingData<Card>> get() = cardPagingRepository.getCards().cachedIn(viewModelScope)
}