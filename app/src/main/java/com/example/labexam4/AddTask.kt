package com.example.labexam4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.labexam4.databinding.ActivityAddTaskBinding
import com.example.labexam4.databinding.ActivityMainBinding

class AddTask : AppCompatActivity() {

    //declare binding variable
    private lateinit var binding: ActivityAddTaskBinding

    //declare a variable for db helper
    private lateinit var db: TaskDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflate the layout
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize db helper
        db = TaskDbHelper(this)

        binding.saveButton.setOnClickListener {
            //retrieve task name and content
            val task = binding.taskEditText.text.toString()
            val content = binding.contentEditText.text.toString()

            //create task object
            val t = Task(0, task, content)

            //insert task object to db
            db.insertTask(t)
            finish()
            Toast.makeText(this, "Task Saved", Toast.LENGTH_SHORT).show()
        }
    }
}