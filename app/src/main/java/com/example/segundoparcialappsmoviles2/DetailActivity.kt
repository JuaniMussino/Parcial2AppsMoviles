package com.example.segundoparcialappsmoviles2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    private lateinit var textName: TextView
    private lateinit var textStatus: TextView
    private lateinit var textSpecies: TextView
    private lateinit var textGender: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras


        val nombre  = bundle?.getString("CharacterName", "")
        val status = bundle?.getString("CharacterStatus", "")
        val specie = bundle?.getString("CharacterSpecies", "")
        val genero = bundle?.getString("CharacterGender",  "")


        textName = findViewById(R.id.tvName)
        textStatus = findViewById(R.id.tvStatus)
        textSpecies  = findViewById(R.id.tvSpecies)
        textGender = findViewById(R.id.tvGender)
        backButton  = findViewById(R.id.buttonBack)

        textName.text = nombre
        textStatus.text = "Status: $status"
        textSpecies.text = "Species: $specie"
        textGender.text = "Gender: $genero"

        backButton.setOnClickListener{

            val intent = Intent(this, listViewActivity::class.java)
            startActivity(intent)
        }







    }
}