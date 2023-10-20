package com.example.androidstudy.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.FocusFinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.androidstudy.MainActivity
import com.example.androidstudy.databinding.FragmentCameraBinding
import java.security.PermissionCollection
import java.util.concurrent.ExecutorService



class CameraFragment : Fragment() {
////
//    private var _binding : FragmentCameraBinding? = null
//    private val binding get() = _binding!!
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentCameraBinding.inflate(inflater, container, false)
//
//        return binding.root
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        onClick()
//    }
//
//
//
//
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
}