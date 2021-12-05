package com.chul.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:image")
fun ImageView.setImage(url: String?) {
    Glide.with(this).load(url).into(this)
}