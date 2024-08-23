package com.example.calculator

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbarMain: Toolbar
    private lateinit var inputTime1ET: EditText
    private lateinit var inputTime2ET: EditText
    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        toolbarMain.title = resources.getString(R.string.titleOfProg)
        toolbarMain.subtitle = "Почему меню лезет вверх?"
        toolbarMain.setLogo(R.drawable.baseline_insert_emoticon_24)

        inputTime1ET = findViewById(R.id.inputTime1ET)
        inputTime2ET = findViewById(R.id.inputTime2ET)
        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.resetMAinMenu -> {
                inputTime1ET.text.clear()
                inputTime2ET.text.clear()
                Toast.makeText(
                    applicationContext,
                    HtmlCompat.fromHtml(
                        "<font color='#8B0000'><b>Данные сброшены.</b></font>",
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ),
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.exitMAinMenu -> {
                Toast.makeText(
                    applicationContext,
                    HtmlCompat.fromHtml(
                        "<font color='#8B0000'><b>Приложение закрыто.</b></font>",
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ),
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(per: View?) {
        var time01 = inputTime1ET.text.toString().replace(" ", "")
        var time02 = inputTime2ET.text.toString().replace(" ", "")
        if (testOfString(time01) == false || testOfString(time02) == false) {
            Toast.makeText(
                applicationContext,
                HtmlCompat.fromHtml(
                    "<font color='#FF0000'><b>Ошибочный ввод.</b></font>",
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                ),
                Toast.LENGTH_LONG
            ).show()
        } else {
            when (per?.id) {
                R.id.buttonSumBTN -> {
                    Toast.makeText(
                        applicationContext,
                        HtmlCompat.fromHtml(
                            "<font color='#8B0000'><b>Результат: ${
                                Action(
                                    time01,
                                    time02
                                ).sum()
                            }</b></font>",
                            HtmlCompat.FROM_HTML_MODE_LEGACY
                        ),
                        Toast.LENGTH_LONG
                    ).show()
                }

                R.id.buttonDifBTN -> {
                    Toast.makeText(
                        applicationContext,
                        HtmlCompat.fromHtml(
                            "<font color='#8B0000'><b>Результат: ${
                                Action(
                                    time01,
                                    time02
                                ).dif()
                            }</b></font>",
                            HtmlCompat.FROM_HTML_MODE_LEGACY
                        ),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}

