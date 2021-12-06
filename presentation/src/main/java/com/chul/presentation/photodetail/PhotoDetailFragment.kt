package com.chul.presentation.photodetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.chul.presentation.databinding.FragmentPhotoDetailBinding
import com.chul.presentation.home.hometab.CardAdapter
import com.chul.presentation.home.hometab.CardParentType
import com.chul.presentation.main.MainActivity
import javax.inject.Inject

class PhotoDetailFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var photoDetailBinding: FragmentPhotoDetailBinding
    private val photoDetailViewModel: PhotoDetailViewModel by viewModels { viewModelFactory }
    private val args: PhotoDetailFragmentArgs by navArgs()
    private val cardAdapter = CardAdapter(CardParentType.PHOTO_DETAIL)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.photoDetailComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(!this::photoDetailBinding.isInitialized) {
            photoDetailBinding =
                FragmentPhotoDetailBinding.inflate(inflater, container, false).apply {
                    viewModel = photoDetailViewModel
                }
        }
        return photoDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!photoDetailViewModel.hasData()) {
            setupListView()
            setupViewModel()
            val id = args.cardId
            photoDetailViewModel.requestPhotoDetail(id)
        }
    }

    private fun setupListView() {
        photoDetailBinding.photoDetailRecommendListView.adapter = cardAdapter
    }

    private fun setupViewModel() {
        photoDetailViewModel.photoDetail.observe(viewLifecycleOwner) { photoDetail ->
            cardAdapter.submitList(photoDetail.recommendCards)
            photoDetailBinding.photoDetail = photoDetail
        }
        photoDetailViewModel.isRefresh.observe(viewLifecycleOwner) { isRefresh ->
            photoDetailBinding.photoDetailRefreshLayout.isRefreshing = isRefresh
        }
    }
}