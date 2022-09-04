package com.komukc.wallpaper.adapter

import androidx.recyclerview.widget.DiffUtil
import com.komukc.wallpaper.model.ExampleWallpaper

class ListWallpaperDiffCallback : DiffUtil.ItemCallback<ExampleWallpaper>() {
    override fun areItemsTheSame(oldItem: ExampleWallpaper, newItem: ExampleWallpaper): Boolean {
        return oldItem.idImageWallpaper == newItem.idImageWallpaper
    }

    override fun areContentsTheSame(oldItem: ExampleWallpaper, newItem: ExampleWallpaper): Boolean {
        return oldItem.idImageWallpaper == newItem.idImageWallpaper
    }
}