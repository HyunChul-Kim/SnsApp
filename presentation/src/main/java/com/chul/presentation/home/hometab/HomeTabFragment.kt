package com.chul.presentation.home.hometab

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.chul.presentation.databinding.FragmentHomeTabBinding
import com.chul.presentation.home.HomeFragment
import com.chul.presentation.home.HomeViewModel
import com.chul.presentation.home.phototab.UserAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeTabFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeTabBinding: FragmentHomeTabBinding
    private val homeTabViewModel: HomeTabViewModel by viewModels { viewModelFactory }
    private val homeViewModel: HomeViewModel by viewModels({requireParentFragment()}, {viewModelFactory})

    private val cardAdapter = CardAdapter()
    private val userAdapter = UserAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (parentFragment as HomeFragment).homeComponent.homeTabComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeTabBinding = FragmentHomeTabBinding.inflate(inflater, container, false)
        return homeTabBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListView()
        setupViewModel()
        homeTabViewModel.requestHomeData()
    }

    private fun setupListView() {
        homeTabBinding.homeTabCardListView.adapter = cardAdapter
        homeTabBinding.homeTabUserListView.adapter = userAdapter
    }

    private fun setupViewModel() {
        homeTabViewModel.cardList.observe(viewLifecycleOwner) { list ->
            cardAdapter.submitList(list)
        }
        homeTabViewModel.userList.observe(viewLifecycleOwner) { list ->
            userAdapter.submitList(list)
        }
    }
}