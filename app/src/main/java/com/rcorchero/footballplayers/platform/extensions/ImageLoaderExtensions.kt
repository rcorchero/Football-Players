package com.rcorchero.footballplayers.platform.extensions

import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso

fun AppCompatImageView.loadImage(url: String, placeholderId: Int) {
    Picasso.get()
        .load(url)
        .placeholder(placeholderId)
        .into(this)
}