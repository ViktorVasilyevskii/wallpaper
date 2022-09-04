package com.komukc.wallpaper.view.screens

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.komukc.wallpaper.databinding.ExampleWallpaperFragmentBinding
import com.komukc.wallpaper.viewmodel.WallpaperViewModel

class ExampleWallpaperFragment : Fragment() {

    private lateinit var bindingExampleWallpaperFragment: ExampleWallpaperFragmentBinding
    private val wallpaperViewModel: WallpaperViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingExampleWallpaperFragment = ExampleWallpaperFragmentBinding.inflate(layoutInflater)
        return bindingExampleWallpaperFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wallpaperViewModel.getItemImageWallpaper().observe(viewLifecycleOwner, Observer { image ->
            AppCompatResources.getDrawable(view.context, image)
                ?.let { updateExampleWallpaper(it) }
        })
        onClickButtonChangeWallpaper(bindingExampleWallpaperFragment.exampleWallpaperImageView, view.context)
    }

    private fun updateExampleWallpaper(exampleImage: Drawable) {
        bindingExampleWallpaperFragment.exampleWallpaperImageView.setImageDrawable(exampleImage)
    }

    private fun onClickButtonChangeWallpaper(view: ImageView, context: Context) {
        bindingExampleWallpaperFragment.buttonChangeWallpaper.setOnClickListener {
            wallpaperViewModel.updateWallpaperDevice(view, context)
        }
    }
}