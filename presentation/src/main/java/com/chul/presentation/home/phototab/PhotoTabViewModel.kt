package com.chul.presentation.home.phototab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chul.domain.model.Card
import com.chul.domain.usecase.GetPhotoFeedUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoTabViewModel @Inject constructor(
    private val getPhotoFeedUseCase: GetPhotoFeedUseCase
): ViewModel() {

    private val _photoList = MutableLiveData<List<Card>>()
    val photoList: LiveData<List<Card>> get() = _photoList

    fun requestPhotoFeed() {
        viewModelScope.launch {
            val response = getPhotoFeedUseCase.invoke()
            _photoList.value = response.cards
        }
    }
}