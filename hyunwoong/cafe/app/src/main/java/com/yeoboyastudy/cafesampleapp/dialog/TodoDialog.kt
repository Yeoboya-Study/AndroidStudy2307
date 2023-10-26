package com.yeoboyastudy.cafesampleapp.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.yeoboyastudy.cafesampleapp.R
import com.yeoboyastudy.cafesampleapp.databinding.DialogTodoBinding
import com.yeoboyastudy.cafesampleapp.databinding.FragmentTodoBinding

class TodoDialog: DialogFragment() {
    private var _binding: DialogTodoBinding? = null
    private val binding get() = _binding!!

    var result: ((String) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogCornerRadius)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DialogTodoBinding.inflate(inflater).apply {
        _binding = this
        initDataBinding()
    }.root

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

     private fun initDataBinding() = with(binding) {
         btnAdd.setOnClickListener {
             val todo = etTodo.text.toString()
             if(todo.isNotEmpty()) {
                 result?.invoke(todo)
                 dismiss()
             }
         }
     }

}