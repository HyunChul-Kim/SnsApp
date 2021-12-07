package com.chul.presentation.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chul.domain.model.User
import com.chul.domain.usecase.GetInsertUserUseCase
import com.chul.domain.usecase.GetSignInUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val getSignInUseCase: GetSignInUseCase,
    private val getInsertUserUseCase: GetInsertUserUseCase
): ViewModel()
{
    val id = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> get() = _errorMsg

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> get() = _isLogin

    fun login() {
        viewModelScope.launch {
            val userId = id.value ?: return@launch
            val userPwd = pwd.value ?: return@launch
            val loginInfo = getSignInUseCase.invoke(userId, userPwd)
            if(loginInfo.isLogin) {
                getInsertUserUseCase.invoke(User("", "", loginInfo.userId))
                _isLogin.value = true
            } else {
                _errorMsg.value = loginInfo.errorMsg
            }
        }
    }
}