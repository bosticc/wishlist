package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var emails : MutableList<Email> = ArrayList()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        // Fetch the list of emails
        // Create adapter passing in the list of emails
        val adapter = EmailAdapter(emails)
        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter
        // Set layout manager to position the items
        emailsRv.layoutManager = LinearLayoutManager(this)

        val inputTextField = findViewById<EditText>(R.id.editText)
        val inputTextField2 = findViewById<EditText>(R.id.editText2)
        val inputTextField3 = findViewById<EditText>(R.id.editText3)
        findViewById<Button>(R.id.button).setOnClickListener {
            val userInputtedTask =  inputTextField.text.toString()
            val userInputtedTask2 =  inputTextField2.text.toString()
            val userInputtedTask3 =  inputTextField3.text.toString()

            val email = Email(userInputtedTask2, userInputtedTask3,userInputtedTask)
            emails.add(email)
            adapter.notifyItemInserted(emails.size -1)
        }
    }
}
