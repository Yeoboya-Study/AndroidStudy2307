package com.example.androidstudy.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Camera
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.example.androidstudy.CameraActivity
import com.example.androidstudy.MainActivity
import com.example.androidstudy.R
import com.example.androidstudy.databinding.FragmentAddBinding

class AddFragment(
    private val setDialog: () -> Unit
) : Fragment() {

    private var _binding: FragmentAddBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() = with(binding) {
        setPhotoDialogButton.setOnClickListener {
            setDialog.invoke()
            parentFragmentManager.popBackStack()
        }
        setCameraButton.setOnClickListener {
//            childFragmentManager.beginTransaction()
//                .add(R.id.cameraFragmentContainer, CameraFragment())
//                .addToBackStack(null)
//                .commit()
            val intent = Intent(requireContext(), CameraActivity::class.java)
            startActivity(intent)
        }
    }
}