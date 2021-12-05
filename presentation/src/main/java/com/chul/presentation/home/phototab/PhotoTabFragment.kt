package com.chul.presentation.home.phototab

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.chul.presentation.databinding.FragmentPhotoTabBinding
import com.chul.presentation.home.HomeFragment
import com.chul.presentation.home.HomeViewModel
import javax.inject.Inject

class PhotoTabFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var photoTabBinding: FragmentPhotoTabBinding
    private val photoTabViewModel: PhotoTabViewModel by viewModels { viewModelFactory }
    private val homeViewModel: HomeViewModel by viewModels( {requireParentFragment()}, {viewModelFactory})
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
        return photoTabBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListView()
        setupViewModel()
        photoTabViewModel.requestPhotoFeed()
    }

    private fun setupListView() {
        photoTabBinding.photoTabListView.adapter = feedAdapter
    }

    private fun setupViewModel() {
        photoTabViewModel.photoList.observe(viewLifecycleOwner) { list ->
            feedAdapter.submitList(list)
        }
    }
}