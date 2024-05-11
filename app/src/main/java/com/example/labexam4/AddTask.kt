package com.example.labexam4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.labexam4.databinding.ActivityAddTaskBinding
import com.example.labexam4.databinding.ActivityMainBinding

class AddTask : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db: TaskDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDbHelper(this)

        binding.saveButton.setOnClickListener {
            val task = binding.taskEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val t = Task(0, task, content)
            db.insertTask(t)
            finish()
            Toast.makeText(this, "Task Saved", Toast.LENGTH_SHORT).show()
        }
    }
}