package com.komukc.wallpaper.logic

import android.content.Context
import android.content.res.Resources

class DefineSizeDisplay {

    companion object {
        private const val TAG = "DefineSizeDisplay"
        private var width = 0
        private var height = 0
        fun defineSizeDisplay(context: Context) {
            width = Resources.getSystem().displayMetrics.widthPixels
            height = Resources.getSystem().displayMetrics.heightPixels
        }

        fun getWidth(): Int {
            return width
        }

        fun getHeight(): Int {
            return height
        }
    }
}