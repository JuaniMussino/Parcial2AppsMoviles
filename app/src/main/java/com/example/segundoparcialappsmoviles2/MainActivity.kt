package com.example.segundoparcialappsmoviles2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToAction: Button
    private lateinit var textViewName: TextView
    private lateinit var editTextUserNameLogin: EditText
    private lateinit var editTextPassworLogin: EditText
    private lateinit var imageView: ImageView


    private  lateinit var buttonRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonToAction = findViewById(R.id.buttonLogin)
        textViewName = findViewById(R.id.textViewNombre)
        editTextPassworLogin = findViewById(R.id.editTextPasswordLogin)
        editTextUserNameLogin = findViewById(R.id.editTextNameLogin)
        imageView = findViewById(R.id.imageView)

        buttonRegistrar = findViewById(R.id.buttonRegis)

        val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
        val userNamePref = preferences.getString("name", "")
        val passwordPref = preferences.getString("pass", "")

        if (userNamePref != null && passwordPref != null) {
            if (userNamePref.isEmpty()) {
                buttonToAction.text = "register"
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

        buttonToAction.setOnClickListener {
            if (editTextUserNameLogin.text.isNullOrEmpty() && editTextPassworLogin.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter username and password", Toast.LENGTH_SHORT).show()
            } else {
                val name = editTextUserNameLogin.text.toString()
                val pass = editTextPassworLogin.text.toString()

                if (name == userNamePref && pass == passwordPref) {
                    val intent = Intent(this, listViewActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        buttonRegistrar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
    }
}