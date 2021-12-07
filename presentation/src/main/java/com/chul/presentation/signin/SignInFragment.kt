package com.chul.presentation.signin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.chul.presentation.databinding.FragmentSignInBinding
import com.chul.presentation.main.MainActivity
import com.chul.presentation.main.MainViewModel
import javax.inject.Inject

class SignInFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var signInBinding: FragmentSignInBinding
    private val signInViewModel: SignInViewModel by viewModels { viewModelFactory }
    private val mainViewModel: MainViewModel by activityViewModels { viewModelFactory }
    private lateinit var navController: NavController

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.signInComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signInBinding = FragmentSignInBinding.inflate(inflater, container, false).apply {
            viewModel = signInViewModel
        }
        return signInBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        setupViewModel()
    }

    private fun setupViewModel() {
        signInViewModel.isLogin.observe(viewLifecycleOwner) { isLogin ->
            if(isLogin) {
                mainViewModel.loadSignedUser()
                navController.popBackStack()
            }
        }
        signInViewModel.errorMsg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}