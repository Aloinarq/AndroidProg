package com.example.quiz_3

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

const val LOG_I_MAIN = "MainActivity"

class MainActivity : AppCompatActivity(){
    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK){
            val cursor: Cursor = result.data!!.data?.let {contentResolver.query(it, null, null, null, null)}!!
                cursor.moveToFirst()
                val displayName =
                    cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))
                Log.d(LOG_I_MAIN, displayName)
                val editText = findViewById<EditText>(R.id.name_input)
                editText.setText(displayName)
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button);
        val contactsButton: Button = findViewById<Button>(R.id.contacts_button)
        val nameInput = findViewById<EditText>(R.id.name_input);
        val toast = Toast.makeText(this, "Please provide a name!", Toast.LENGTH_LONG)
        button.setOnClickListener {
            val name = nameInput.text.toString()
            if (name.isNotBlank()) {
                val intent = Intent(this, GetStartedActivity::class.java).apply {
                    putExtra("NAME", name)
                }
                startActivity(intent);
            } else {
                toast.show()
            }
        }
        contactsButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            getContent.launch(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume()")

    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy()")
    }



}
