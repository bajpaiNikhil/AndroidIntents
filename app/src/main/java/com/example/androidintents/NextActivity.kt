package com.example.androidintents

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class NextActivity : AppCompatActivity() {

    lateinit var nameT : TextView
    lateinit var cLayout : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val showText = findViewById<TextView>(R.id.showT)
        cLayout = findViewById(R.id.layoutC)

        val name = intent.getStringExtra("uname") ?: "welcome"
        Toast.makeText(this,"here is the name $name" , Toast.LENGTH_SHORT).show()
        showText.text = name
    }

    fun chooseClick(view: View) {
        val i = Intent(this, ColorActivity::class.java)
        startActivityForResult(i,1)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        Log.d("NextActivity" ,"child transfering data back")

        if(requestCode == 1){
            //received data from color activity .
            if (resultCode == RESULT_OK){
                //
                val clr = data?.getStringExtra("color")
                Toast.makeText(this , "COlor : $clr" , Toast.LENGTH_SHORT).show()

                when(clr){
                    "Red" -> cLayout.setBackgroundColor(Color.RED)
                    "Blue" -> cLayout.setBackgroundColor(Color.BLUE)
                    "Green" -> cLayout.setBackgroundColor(Color.GREEN)
                    else -> cLayout.setBackgroundColor(Color.GRAY)

                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}