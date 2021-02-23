package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

var bmiIndex: Double = 0.00

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        val tvName = findViewById<TextView>(R.id.btnEnter)

        val personName = intent?.getStringExtra("personName")
        tvName.text = personName


        if (savedInstanceState != null) {
            bmiIndex = savedInstanceState.getDouble("bmi")

            //Restore Data and status
            val tvStatus = findViewById<TextView>(R.id.tvStatus)
            tvStatus.setText(getStatus())
        }

        val btnCal = findViewById<Button>(R.id.btnCalculate)

        btnCal.setOnClickListener() {
            // Cannot put as View as View included button, ....
            val weight = findViewById<TextView>(R.id.weight).text.toString()
            val height = findViewById<TextView>(R.id.height).text.toString()

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            val tvstatus = findViewById<TextView>(R.id.tvStatus)
            tvstatus.setText(getStatus())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmi", bmiIndex)
    }

    fun getStatus():String{
        if(bmiIndex < 18.5)
            return "UnderWeight"
        else if (bmiIndex in 18.5..24.9)
            return "Normal Weight"
        else if (bmiIndex in 25.0..29.9 )
            return "OverWeight"
        else if (bmiIndex in 30.0..34.9 )
            return "Obesity Class I"
        else if (bmiIndex in 35.0..39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
    }
}