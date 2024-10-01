package com.example.lab32

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val names = listOf("John", "Emily", "Michael", "Sarah", "David", "Sophia")
    private val surnames = listOf("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewSurname: TextView = findViewById(R.id.textViewSurname)
        val buttonGenerate: Button = findViewById(R.id.buttonGenerate)

        buttonGenerate.setOnClickListener {
            val randomName = names.random()
            val randomSurname = surnames.random()

            textViewName.text = randomName
            textViewSurname.text = randomSurname
        }
    }
}