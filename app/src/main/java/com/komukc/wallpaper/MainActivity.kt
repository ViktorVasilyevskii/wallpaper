package com.komukc.wallpaper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.komukc.wallpaper.databinding.ActivityMainBinding
import com.komukc.wallpaper.view.screens.ExampleWallpaperFragment
import com.komukc.wallpaper.view.screens.ListWallpaperFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFragment(R.id.list_wallpaper_fragment, ListWallpaperFragment())
        startFragment(R.id.example_wallpaper_fragment, ExampleWallpaperFragment())
    }

    private fun startFragment(idFragment: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(idFragment, fragment).addToBackStack(null).commit()
    }

}