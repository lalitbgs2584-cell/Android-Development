package com.example.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Call the XML layout
        setContentView(R.layout.main_activity)

        // Access UI elements
        val tvHello = findViewById<TextView>(R.id.HelloWorld)
        val btnClick = findViewById<Button>(R.id.submitButton)

        // Handle button click
        btnClick.setOnClickListener {
            tvHello.text = "Button Clicked!"
        }
    }
}
