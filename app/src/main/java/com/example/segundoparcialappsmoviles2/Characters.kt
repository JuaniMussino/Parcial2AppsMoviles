package com.example.segundoparcialappsmoviles2

data class Characters(
    val info: Info,
    val results: List<Results>
)

data class Info(
    val pages: Int,
    val count:  Int
)

data class Results(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin

)

data class Origin(
    val name: String
)


