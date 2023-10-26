package com.yeoboyastudy.cafesampleapp.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeoboyastudy.cafesampleapp.data.TodoData
import com.yeoboyastudy.cafesampleapp.databinding.ItemTodoBinding

class TodoAdapter: RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    val adapterList = mutableListOf<TodoData>()

    fun set(list: List<TodoData>) {
        adapterList.clear()
        adapterList.addAll(list)
        notifyDataSetChanged()
    }

    fun addTodo(todo: TodoData) {
        adapterList.add(todo)
        notifyItemInserted(adapterList.lastIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = adapterList.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) = with(binding) {
            val data = adapterList[position]
            tvTodo.text = data.todo
            checkbox.isChecked = data.check

            checkbox.setOnCheckedChangeListener { _, isChecked ->
                data.check = isChecked
                if(isChecked)
                    tvTodo.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                else tvTodo.paintFlags = 0
            }
        }
    }
}