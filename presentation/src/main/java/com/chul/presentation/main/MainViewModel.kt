package com.chul.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chul.domain.model.User
import com.chul.domain.usecase.GetSignOutUseCase
import com.chul.domain.usecase.GetSignedUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getSignedUserUseCase: GetSignedUserUseCase,
    private val getSignOutUseCase: GetSignOutUseCase
): ViewModel() {

    private val _isSigned = MutableLiveData<Boolean>()
    val isSigned: LiveData<Boolean> get() = _isSigned

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun loadSignedUser() {
        viewModelScope.launch {
            val user = getSignedUserUseCase.invoke()
            _user.value = user
            _isSigned.value = user != null
        }
    }

    fun logout() {
        viewModelScope.launch {
            user.value?.let {
                getSignOutUseCase.invoke(it)
                _user.value = null
                _isSigned.value = false
            }
        }
    }
}