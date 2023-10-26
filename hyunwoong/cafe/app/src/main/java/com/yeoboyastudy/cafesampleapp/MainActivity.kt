package com.yeoboyastudy.cafesampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import com.yeoboyastudy.cafesampleapp.databinding.ActivityMainBinding
import com.yeoboyastudy.cafesampleapp.extension.addFragment
import com.yeoboyastudy.cafesampleapp.extension.showToast
import com.yeoboyastudy.cafesampleapp.ui.CafeFragment
import com.yeoboyastudy.cafesampleapp.ui.ChatFragment
import com.yeoboyastudy.cafesampleapp.ui.GalleryFragment
import com.yeoboyastudy.cafesampleapp.ui.TodoFragment

class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var mCafeFragment: CafeFragment? = null

    private var mGalleryFragment: GalleryFragment? = null
    private var mChatFragment: ChatFragment? = null
    private var mTodoFragment: TodoFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClick()
    }
    private fun setOnClick() = with(binding) {
        cafeButton.setOnClickListener {
            addCafeFragment()
        }

        galleryButton.setOnClickListener {
            addGalleryFragment()
        }

        chatButton.setOnClickListener {
            addChatFragment()
        }

        todoButton.setOnClickListener {
            todoChatFragment()
        }
    }



    private fun addCafeFragment() {
        mCafeFragment = CafeFragment().apply {
            arguments = bundleOf("woong" to "hi")
        }
        binding.container.isVisible = true

        addFragment(R.id.container, mCafeFragment, addBackStack = true)
    }

    private fun addGalleryFragment() {
        mGalleryFragment = GalleryFragment()
        binding.container.isVisible = true
        addFragment(R.id.container, mGalleryFragment, addBackStack = true)
    }

    private fun addChatFragment() {
        mChatFragment = ChatFragment()
        binding.container.isVisible = true
        addFragment(R.id.container, mChatFragment, addBackStack = true)
    }

    private fun todoChatFragment() {
        mTodoFragment = TodoFragment()
        binding.container.isVisible = true
        addFragment(R.id.container, mTodoFragment, addBackStack = true)
    }

    override fun onBackPressed() {
        if(mCafeFragment?.isVisible == true) {
            Log.d("woong", "${mCafeFragment?.childFragmentManager?.backStackEntryCount}")
            if (mCafeFragment?.childFragmentManager?.backStackEntryCount!! >= 1) {
                mCafeFragment?.childFragmentManager?.popBackStackImmediate()
            } else {
                super.onBackPressed()
            }
        }else{
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        mCafeFragment = null
        super.onDestroy()
    }
}