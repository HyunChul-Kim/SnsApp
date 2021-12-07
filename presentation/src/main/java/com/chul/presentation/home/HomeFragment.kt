package com.chul.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chul.presentation.databinding.FragmentHomeBinding
import com.chul.presentation.home.di.HomeComponent
import com.chul.presentation.main.MainActivity
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class HomeFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var homeComponent: HomeComponent
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var adapter: HomeTabAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeComponent = (activity as MainActivity).mainComponent.homeComponent().create()
        homeComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val tabLayout = homeBinding.homeTabLayout
        val viewPager = homeBinding.homeViewPager
        adapter = HomeTabAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
    }
}