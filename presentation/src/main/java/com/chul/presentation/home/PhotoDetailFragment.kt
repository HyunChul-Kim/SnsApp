package com.chul.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chul.presentation.databinding.FragmentPhotoDetailBinding

class PhotoDetailFragment: Fragment() {

    private lateinit var photoDetailBinding: FragmentPhotoDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        photoDetailBinding = FragmentPhotoDetailBinding.inflate(inflater, container, false)
        return photoDetailBinding.root
    }
}