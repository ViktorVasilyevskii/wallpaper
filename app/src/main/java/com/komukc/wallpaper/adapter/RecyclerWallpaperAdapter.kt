package com.komukc.wallpaper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.komukc.wallpaper.R
import com.komukc.wallpaper.databinding.ItemWallpaperBinding
import com.komukc.wallpaper.model.ExampleWallpaper
import com.komukc.wallpaper.viewmodel.WallpaperViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.MaskTransformation

class RecyclerWallpaperAdapter(private val wallpaperViewModel: WallpaperViewModel) : ListAdapter<ExampleWallpaper, RecyclerWallpaperAdapter.WallpaperViewHolder>(ListWallpaperDiffCallback()){


    private lateinit var context: Context

    inner class WallpaperViewHolder(
        val binding: ItemWallpaperBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperViewHolder {
        context = parent.context
        return WallpaperViewHolder(
            ItemWallpaperBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
        val wallpaperItem = getItem(position)
        holder.binding.apply {
            val imageViewItemWallpaper = itemWallpaperList
            Picasso.get()
                .load(wallpaperItem.idImageWallpaper)
                .resize(context.resources.getDimension(R.dimen.weight_item_wallpaper).toInt(),
                    context.resources.getDimension(R.dimen.height_item_wallpaper).toInt())
                .transform(MaskTransformation(context, R.drawable.transform_item_wallpaper))
                .into(imageViewItemWallpaper)

            imageViewItemWallpaper.setOnClickListener { v ->
                wallpaperViewModel.updateWallpaperExample(wallpaperItem.idImageWallpaper)
            }
        }

    }
}