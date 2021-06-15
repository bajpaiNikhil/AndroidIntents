package com.example.androidintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

class ColorActivity : AppCompatActivity() {

    var selectedColor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

    }

    fun rbClicked(view: View) {
        val rButton = view as RadioButton

        selectedColor = rButton.text.toString()
        Toast.makeText(this , "selected color is $selectedColor" , Toast.LENGTH_SHORT).show()

    }

    override fun onBackPressed() {

        // return data to the parent

        val i = Intent()
        i.putExtra("color" , selectedColor)
        setResult(RESULT_OK, i)

        super.onBackPressed()
    }
}