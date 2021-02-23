package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter: Button = findViewById(R.id.btnEnter)

        btnEnter.setOnClickListener() {

            val name = findViewById<TextView>(R.id.name)

            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("personName", name.text.toString())

            startActivity(intent);

        }
    }
}