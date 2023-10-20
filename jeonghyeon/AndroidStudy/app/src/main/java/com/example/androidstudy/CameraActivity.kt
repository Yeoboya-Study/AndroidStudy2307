package com.example.androidstudy

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidstudy.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {

    private var _binding : ActivityCameraBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 1000
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkCameraPermission()
        onClick()
    }

    private fun checkCameraPermission() {
        if(allPermissionsGranted()){
            startCamera(binding.viewFinder)
        }else{
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("권한 인정", "b확인")
        if(requestCode == REQUEST_CODE_PERMISSIONS) {
            startCamera(binding.viewFinder)
        }else {
            Log.d("꺼버릴거야", "버렸다")
            finish()
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all{
        ContextCompat.checkSelfPermission(
            baseContext , it
        )== PackageManager.PERMISSION_GRANTED
    }

    private fun startCamera(viewFinder: PreviewView){
        Log.d("권한 인정", "확인")
    }


    private fun onClick() = with(binding) {

    }

}