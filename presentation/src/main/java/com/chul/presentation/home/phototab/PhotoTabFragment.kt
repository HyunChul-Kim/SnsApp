package com.chul.presentation.home.phototab

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import androidx.paging.LoadState
import com.chul.presentation.R
import com.chul.presentation.databinding.FragmentPhotoTabBinding
import com.chul.presentation.home.HomeFragment
import com.chul.presentation.home.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoTabFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var photoTabBinding: FragmentPhotoTabBinding
    private val photoTabViewModel: PhotoTabViewModel by navGraphViewModels(R.id.nav_graph) { viewModelFactory }
    private val feedAdapter = PhotoFeedAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (parentFragment as HomeFragment).homeComponent.photoTabComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        photoTabBinding = FragmentPhotoTabBinding.inflate(inflater, container, false)
        setupUI()
        return photoTabBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupUI() {
        photoTabBinding.photoTabListView.adapter = feedAdapter
        photoTabBinding.photoTabRefreshLayout.setOnRefreshListener {
            feedAdapter.refresh()
        }
        viewLifecycleOwner.lifecycleScope.launch {
            feedAdapter.loadStateFlow.collectLatest { state ->
                photoTabBinding.photoTabRefreshLayout.isRefreshing = state.refresh is LoadState.Loading
            }
        }
    }

    private fun setupViewModel() {
        photoTabViewModel.cardList.observe(viewLifecycleOwner) { list ->
            viewLifecycleOwner.lifecycleScope.launch {
                feedAdapter.submitData(lifecycle, list)
            }
        }
    }
}