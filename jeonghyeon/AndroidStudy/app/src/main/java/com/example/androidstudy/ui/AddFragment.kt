package com.example.androidstudy.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.androidstudy.CameraActivity
import com.example.androidstudy.LocalActivity
import com.example.androidstudy.databinding.FragmentAddBinding

class AddFragment(
    private val setDialog: () -> Unit,
    private val setLocalImg : (String)-> Unit
) : Fragment() {

    private var _binding: FragmentAddBinding? = null
    val binding get() = _binding!!
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            //todo : Activity 에서 실행한 결과물 가져 오기
            Log.d("반환은 성공?", result.data?.getStringExtra(LocalActivity.LOCAL_ACTIVITY_RESULT_KEY).toString())
            when (result.resultCode) {
                LocalActivity.LOCAL_ACTIVITY_RESULT_CODE -> {
                    val value = result.data?.getStringExtra(LocalActivity.LOCAL_ACTIVITY_RESULT_KEY)
                    Log.d("value", value.toString())
                    setLocalImg.invoke(value.toString())
                }
            }
        }

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
            val intent = Intent(requireContext(), CameraActivity::class.java)
            startActivity(intent)
        }
        setGalleryButton.setOnClickListener {
            val intent = Intent(requireContext(), LocalActivity::class.java)
            startForResult.launch(intent)
        }
        setVideoButton.setOnClickListener {

        }
    }
}