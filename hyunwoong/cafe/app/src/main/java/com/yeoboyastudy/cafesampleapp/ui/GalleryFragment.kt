package com.yeoboyastudy.cafesampleapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.yeoboyastudy.cafesampleapp.adapter.ImageAdapter
import com.yeoboyastudy.cafesampleapp.databinding.FragmentGalleryBinding
import com.yeoboyastudy.cafesampleapp.rest.UnsplashApiClient
import kotlinx.coroutines.launch

class GalleryFragment: Fragment() {


    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private val imageAdapter by lazy { ImageAdapter(){} }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
        bindRecyclerView()
        getRandomPhoto()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun getRandomPhoto(query: String? = null) = lifecycleScope.launch {
        UnsplashApiClient.getRandomPhotos(query)?.let { photoList ->
            imageAdapter.set(photoList)
        }
    }

    private fun bindRecyclerView() = with(binding) {
        recyclerView.apply {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    private fun searchRandomPhoto() = with(binding) {
        val searchText = editText.text.toString()
        getRandomPhoto(searchText)
    }

    private fun setOnClick() = with(binding) {

        searchButton.setOnClickListener {
            searchRandomPhoto()
            val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            inputMethodManager?.hideSoftInputFromWindow(it.windowToken, 0)
            editText.apply {
                text.clear()
                clearFocus()
            }
        }
    }
}