package com.rcorchero.footballplayers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView

class CustomArrayAdapter(
    private val mContext: Context,
    @LayoutRes private val mResource: Int,
    objects: List<Int>) : ArrayAdapter<Int>(mContext, mResource, android.R.id.text1, objects) {

    private var images: List<Int> = objects

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View =
        createItemView(position, parent)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View =
        createItemView(position, parent)

    private fun createItemView(position: Int, parent: ViewGroup): View {
        val view = LayoutInflater.from(mContext).inflate(mResource, parent, false)

        val image = this.images[position]

        val imageLeague = view.findViewById(R.id.imageLeague) as AppCompatImageView
        imageLeague.setImageResource(image)

        return view
    }
}