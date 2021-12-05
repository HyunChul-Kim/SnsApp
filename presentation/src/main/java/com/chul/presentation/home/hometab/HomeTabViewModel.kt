package com.chul.presentation.home.hometab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chul.domain.model.Card
import com.chul.domain.model.User
import com.chul.domain.usecase.GetHomeUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeTabViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
): ViewModel() {

    private val _cardList = MutableLiveData<List<Card>>()
    val cardList: LiveData<List<Card>> get() = _cardList

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

    fun requestHomeData() {
        viewModelScope.launch {
            val homeData = getHomeUseCase.invoke()
            _cardList.value = homeData.popularCards
            _userList.value = homeData.popularUsers
        }
    }
}