package com.yeoboyastudy.cafesampleapp.dialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.yeoboyastudy.cafesampleapp.R
import com.yeoboyastudy.cafesampleapp.adapter.ImageAdapter
import com.yeoboyastudy.cafesampleapp.databinding.FragmentGalleryBinding
import com.yeoboyastudy.cafesampleapp.rest.UnsplashApiClient
import kotlinx.coroutines.launch

class GalleryDialog: DialogFragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    var result: ((String) -> Unit)? = null

    private val imageAdapter by lazy { ImageAdapter() {
        result?.invoke(it)
        dismiss()
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogFullScreen)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentGalleryBinding.inflate(inflater).apply {
        _binding = this
        initDataBinding()
    }.root

    private fun initDataBinding() {
        setAdapter()
        setOnClick()
        getRandomPhoto()
    }

    private fun setAdapter() = with(binding) {
        recyclerView.adapter = imageAdapter
        recyclerView.layoutManager = GridLayoutManager(context, 3)

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

    private fun getRandomPhoto(query: String? = null) = lifecycleScope.launch {
        UnsplashApiClient.getRandomPhotos(query)?.let { photoList ->
            imageAdapter.set(photoList)
        }
    }

    private fun searchRandomPhoto() = with(binding) {
        val searchText = editText.text.toString()
        getRandomPhoto(searchText)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}