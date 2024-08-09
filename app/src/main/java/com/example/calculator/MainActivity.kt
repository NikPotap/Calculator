package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputTime1ET: EditText
    private lateinit var inputTime2ET: EditText
    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button
    private lateinit var resetBTN: Button
    private lateinit var closeBTN: Button
    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inputTime1ET = findViewById(R.id.inputTime1ET)
        inputTime2ET = findViewById(R.id.inputTime2ET)
        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        resetBTN = findViewById(R.id.resetBTN)
        closeBTN = findViewById(R.id.closeBTN)
        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
        resetBTN.setOnClickListener(this)
        closeBTN.setOnClickListener(this)
    }

    override fun onClick(per: View?) {
        var time01 = inputTime1ET.text.toString()
        var time02 = inputTime2ET.text.toString()
        var result = ""
        var testOfString = true
        if (testOfString(time01) == false || testOfString(time02) == false) testOfString = false
        when (per?.id) {
            R.id.buttonSumBTN -> {
                if (testOfString) result = Action(time01, time02).sum()
                else result = "Ошибочный ввод."
            }
            R.id.buttonDifBTN -> {
                if (testOfString) result = Action(time01, time02).dif()
                else result = "Ошибочный ввод."
            }
            R.id.resetBTN -> {
                inputTime1ET.text.clear()
                inputTime2ET.text.clear()
                result = ""
            }
            R.id.closeBTN -> finish()
            else -> result = ""
        }
        resultTV.text = result
    }
}