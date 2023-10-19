package com.yeoboyastudy.cafesampleapp.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.yeoboyastudy.cafesampleapp.databinding.FragmentBottomMenuBinding
import com.yeoboyastudy.cafesampleapp.dialog.GalleryDialog
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChatBottomFragment: Fragment() {

    private var _binding: FragmentBottomMenuBinding? = null
    private val binding get() = _binding!!

    var bottomResult: ((String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
    }

    private fun setOnClick() = with(binding) {
        btnGallery.setOnClickListener {
            GalleryDialog().apply {
                result = {
                    bottomResult?.invoke(it)
                }
            }.show(childFragmentManager, null)
        }

        btnCamera.setOnClickListener {
            // 카메라 권한이 허용되어 있는지 확인
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private val cameraPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            openCamera()
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.CAMERA)) {
                openCamera()
            }
        }
    }

    private val cameraResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == Activity.RESULT_OK){
            extraOutputFile?.let { bottomResult?.invoke(it.path) }
        }
    }

    private var extraOutputFile: File? = null
    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureIntent.resolveActivity(requireContext().packageManager)?.let {
            val dateTime = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            extraOutputFile = createCacheFile("${dateTime}.jpg")                // (3)
            val uri = FileProvider.getUriForFile(requireContext(), "${requireContext().packageName}.fileprovider", extraOutputFile!!) // (4)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            cameraResult.launch(takePictureIntent)
        }
    }

    private fun createCacheFile(fileName: String): File {
        val storageDir = requireContext().externalCacheDir
        storageDir?.let {
            if (!storageDir.exists())
                storageDir.mkdir()
        }
        return File(storageDir, fileName)
    }
}