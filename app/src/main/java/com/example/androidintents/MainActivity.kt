package com.example.androidintents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var nameEdit : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEdit = findViewById(R.id.nameE)
    }

    fun buttonClick(view: View) {

        when(view.id){
            R.id.okB ->{
                //
                val name = nameEdit.text.toString()
                Toast.makeText(this,"Name is $name" , Toast.LENGTH_SHORT).show()

                val i =Intent(this, NextActivity::class.java)
                if(!name.isEmpty()) {
                    i.putExtra("uname", name)
                    startActivity(i)
                }

            }
            R.id.contactB ->{
                //launch CONTACT app , pick one from the list
                // implicit intent
                val contactIntent = Intent(Intent.ACTION_PICK , ContactsContract.Contacts.CONTENT_URI)
                startActivityForResult(contactIntent , 1)

            }
            R.id.callB ->{
                //launch dialar to call a number
                val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9232374237"))
                Toast.makeText(this , "THis is the way",Toast.LENGTH_SHORT).show()
                Log.d("MainACtivity" ,  "This is the way")

                startActivity(phoneIntent)
            }

            R.id.visitB ->{
                //launch the browser and oad the company page

                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))


//                var e = webIntent.resolveActivity(packageManager)
//                e = null
                if(webIntent.resolveActivity(packageManager) != null){
                    startActivity(webIntent)
                }else{
                    Toast.makeText(this, "Download the appication first you bot" , Toast.LENGTH_SHORT).show()
                }
            }
            R.id.mapB ->{

                val mapIntent = Intent(Intent.ACTION_VIEW , Uri.parse("geo:12.4454 , 33.3245"))
                startActivity(mapIntent)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 1){
            if (resultCode == RESULT_OK){
                val selection = data?.dataString
                Log.d("MainACtivivity" , "selected Contact : $selection")
                Toast.makeText(this, "selected Constact : $selection" , Toast.LENGTH_SHORT).show()
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this , "NOthing.....",Toast.LENGTH_SHORT).show()
            }
    }
        super.onActivityResult(requestCode, resultCode, data)
    }

}