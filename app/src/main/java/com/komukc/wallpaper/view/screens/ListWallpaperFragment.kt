package com.komukc.wallpaper.view.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.komukc.wallpaper.adapter.RecyclerWallpaperAdapter
import com.komukc.wallpaper.databinding.ListWallpaperFragmentBinding
import com.komukc.wallpaper.model.ListWallpaper
import com.komukc.wallpaper.viewmodel.WallpaperViewModel

class ListWallpaperFragment : Fragment() {

    private lateinit var bindingListWallpaperFragment: ListWallpaperFragmentBinding
    private lateinit var recyclerWallpaperAdapter: RecyclerWallpaperAdapter
    private val wallpaperViewModel: WallpaperViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingListWallpaperFragment = ListWallpaperFragmentBinding.inflate(layoutInflater)
        return bindingListWallpaperFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewWallpaper()
    }

    private fun initRecyclerViewWallpaper() {
        recyclerWallpaperAdapter = RecyclerWallpaperAdapter(wallpaperViewModel)
        bindingListWallpaperFragment.recyclerListWallpaper.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false)
            setHasFixedSize(true)
            adapter = recyclerWallpaperAdapter
        }
        recyclerWallpaperAdapter.submitList(ListWallpaper.arrayListWallpaper)
    }
}