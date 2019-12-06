package com.example.android.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.Math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var bmiImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bmiImage = findViewById(R.id.imageViewProfile)
        val calculateBtn : Button = findViewById(R.id.buttonCalculate)
        calculateBtn.setOnClickListener{bmiCalculate()}

        val resetBtn : Button = findViewById(R.id.buttonReset)
        resetBtn.setOnClickListener{reset()}

    }

    private fun bmiCalculate() {

        val weight: EditText = findViewById(R.id.editTextWeight)
        val height: EditText = findViewById(R.id.editTextHeight)
        val resultText: TextView = findViewById(R.id.textViewBMI)
        val bmiImage : ImageView = findViewById(R.id.imageViewProfile)
        try{

            var BMI =  weight.text.toString().toDouble()/ pow(height.text.toString().toDouble()/100, 2.00)
            resultText.text = BMI.toString()//String.format("%.2f",BMI.toString())
            //set image
           val drawableResource = when{
               BMI.toString().toDouble() < 18.5 -> R.drawable.under
               BMI.toString().toDouble() > 18.5 && BMI.toString().toDouble() < 24.9 -> R.drawable.normal
               BMI.toString().toDouble() > 25 -> R.drawable.over
               else -> R.drawable.empty
           }
                bmiImage.setImageResource(drawableResource)

        }catch (nfe: NumberFormatException){
        }
    }

    private fun reset(){
        val weight: EditText = findViewById(R.id.editTextWeight)
        val height: EditText = findViewById(R.id.editTextHeight)
        val resultText: TextView = findViewById(R.id.textViewBMI)
        val bmiImage : ImageView = findViewById(R.id.imageViewProfile)
        weight.text = null
        height.text = null
        resultText.text = null
        bmiImage.setImageResource(R.drawable.empty)
    }
}
