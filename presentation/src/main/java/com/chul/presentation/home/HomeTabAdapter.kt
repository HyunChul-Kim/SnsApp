package com.chul.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chul.presentation.home.hometab.HomeTabFragment
import com.chul.presentation.home.phototab.PhotoTabFragment

class HomeTabAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    private val tabFragments = listOf(
        HomeTabFragment(),
        PhotoTabFragment()
    )

    override fun getItemCount(): Int = tabFragments.size

    override fun createFragment(position: Int): Fragment {
        return tabFragments[position]
    }

    fun getTitle(position: Int): String {
        return when(position) {
            0 -> "홈"
            else -> "사진피드"
        }
    }
}