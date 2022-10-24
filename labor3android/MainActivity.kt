package com.example.quiz_3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.name_input).text
        Log.i("Test","Logcat Test")
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            if(text.isNotBlank()) {
//                val toast = Toast.makeText(applicationContext,text,Toast.LENGTH_LONG)
//                toast.show()}
                val snack = Snackbar.make(button, text, Snackbar.LENGTH_LONG)
                snack.show()
                Log.i("Test","Logcat Test")
            }
        }


    }
}