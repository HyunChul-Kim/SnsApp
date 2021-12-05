package com.chul.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chul.presentation.home.hometab.HomeTabFragment
import com.chul.presentation.home.phototab.PhotoTabFragment

class HomeTabAdapter(parentFragment: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(parentFragment, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeTabFragment()
            else -> PhotoTabFragment()
        }
    }

    fun getTitle(position: Int): String {
        return when(position) {
            0 -> "홈"
            else -> "사진피드"
        }
    }
}