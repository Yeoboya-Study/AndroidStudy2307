package com.yeoboyastudy.cafesampleapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yeoboyastudy.cafesampleapp.adapter.TodoAdapter
import com.yeoboyastudy.cafesampleapp.data.TodoData
import com.yeoboyastudy.cafesampleapp.databinding.FragmentTodoBinding
import com.yeoboyastudy.cafesampleapp.dialog.TodoDialog

class TodoFragment: Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private val todoAdapter by lazy { TodoAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
        bindRecyclerView()
    }

    private fun setOnClick() = with(binding) {
        btnPlus.setOnClickListener {
            TodoDialog().apply {
                result = {
                    todoAdapter.addTodo(TodoData(it))
                }
            }.show(childFragmentManager, null)
        }
    }

    private fun bindRecyclerView() = with(binding) {
        recyclerView.adapter = todoAdapter
        todoAdapter.set(emptyList())
    }
}