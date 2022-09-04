package com.komukc.wallpaper.viewmodel

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.komukc.wallpaper.R
import com.komukc.wallpaper.logic.DefineSizeDisplay

class WallpaperViewModel : ViewModel() {

    companion object {
        private const val TAG = "WallpaperViewModel"
    }

    private var _itemImageWallpaper = MutableLiveData(R.drawable.wallpaper_one);
    fun getItemImageWallpaper(): LiveData<Int> {
        return _itemImageWallpaper
    }

    fun updateWallpaperExample(newWallpaperExample : Int) {
        _itemImageWallpaper.value = newWallpaperExample
    }


    fun updateWallpaperDevice(imageView: ImageView, context: Context) {
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        if (bitmap != null) {
            val scaleBitmap = Bitmap.createScaledBitmap(bitmap, DefineSizeDisplay.getWidth(), DefineSizeDisplay.getHeight(), false)
            val wallpaperManager = WallpaperManager.getInstance(context)
            wallpaperManager.setBitmap(scaleBitmap)
            wallpaperManager.suggestDesiredDimensions(DefineSizeDisplay.getWidth(), DefineSizeDisplay.getHeight())
        }
    }


}