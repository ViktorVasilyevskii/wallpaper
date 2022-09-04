package com.komukc.wallpaper.app

import android.app.Application
import com.komukc.wallpaper.logic.DefineSizeDisplay

class App : Application() {

    init {
        DefineSizeDisplay.defineSizeDisplay(this)
    }
}