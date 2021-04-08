package com.example.sharedpreferencesapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        bt_button.setOnClickListener {
            saveData()
        }
    }
    private fun saveData(){
        val insertedText = et_text.text.toString()
        val insertedText1 = et_text1.text.toString()
        val insertedText2 = et_text2.text.toString()
        tv_text.text = insertedText
        tv_text1.text = insertedText1
        tv_text2.text = insertedText2

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertedText)
            putString("STRING_KEY1",insertedText1)
            putString("STRING_KEY2",insertedText2)

        }.apply()
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
    }
    private fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)
        val savedString1 = sharedPreferences.getString("STRING_KEY1",null)
        val savedString2 = sharedPreferences.getString("STRING_KEY2",null)

        tv_text.text = savedString
        tv_text1.text = savedString1
        tv_text2.text = savedString2
    }
}