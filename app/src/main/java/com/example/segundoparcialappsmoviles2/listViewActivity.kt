package com.example.segundoparcialappsmoviles2

import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.widget.ListView
import android.widget.Spinner

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class listViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter


    private var listCharacters = mutableListOf<Results>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        recyclerView = findViewById(R.id.recyV)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(listCharacters)
        recyclerView.adapter = adapter

        adapter.onItemClickListener = { selectedCharacter ->
            val intent =  Intent(this, DetailActivity::class.java)

            intent.putExtra("CharacterName", selectedCharacter.name)
            intent.putExtra("CharacterStatus", selectedCharacter.status)
            intent.putExtra("CharacterSpecies", selectedCharacter.species)
            intent.putExtra("CharacterGender", selectedCharacter.gender)

            startActivity(intent)

        }





getCharacters()



    }

    private fun getCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val call =
                getRetrofit().create(ServiceApi::class.java).getCharacters("character")
            val response = call.body()


            runOnUiThread {
                if(call.isSuccessful) {
                    val characters = response?.results

                    characters?.forEach {
                        listCharacters.add(it)
                    }

                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

            private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }






}