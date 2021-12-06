package com.chul.presentation.photodetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chul.domain.model.Card
import com.chul.domain.model.PhotoDetail
import com.chul.domain.usecase.GetPhotoDetailUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoDetailViewModel @Inject constructor(
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase
): ViewModel() {

    private val _photoDetail = MutableLiveData<PhotoDetail>()
    val photoDetail: LiveData<PhotoDetail> get() = _photoDetail

    private val _isRefresh = MutableLiveData<Boolean>()
    val isRefresh: LiveData<Boolean> get() = _isRefresh

    private var cardId = 0

    fun requestPhotoDetail(id: Int) {
        cardId = id
        _isRefresh.value = true
        viewModelScope.launch {
            _photoDetail.value = getPhotoDetailUseCase.invoke(id)
            _isRefresh.value = false
        }
    }

    fun onRefresh() {
        requestPhotoDetail(cardId)
    }

    fun hasData(): Boolean = photoDetail.value != null
}