package com.chul.presentation.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chul.presentation.databinding.FragmentSignInBinding

class SignInFragment: Fragment() {

    private lateinit var signInBinding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signInBinding = FragmentSignInBinding.inflate(inflater, container, false)
        return signInBinding.root
    }
}