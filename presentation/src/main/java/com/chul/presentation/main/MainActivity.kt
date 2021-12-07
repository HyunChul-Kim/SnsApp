package com.chul.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.chul.presentation.R
import com.chul.presentation.SnsApplication
import com.chul.presentation.databinding.ActivityMainBinding
import com.chul.presentation.main.di.MainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainComponent: MainComponent
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (applicationContext as SnsApplication).appComponent.mainComponent().create()
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.mainHeader.headerSignIn.setOnClickListener {
            navController.navigate(R.id.action_global_signInFragment)
        }
        setupViewModel()
        setupUI()
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.loadSignedUser()
    }

    private fun setupUI() {
        binding.mainHeader.headerSignOut.setOnClickListener {
            mainViewModel.logout()
        }
    }

    private fun setupViewModel() {
        mainViewModel.isSigned.observe(this) { isSigned ->
            binding.isSigned = isSigned
        }
    }
}