package com.example.segundoparcialappsmoviles2


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ServiceApi {

    @GET
    suspend fun getCharacters(@Url url: String) : Response<Characters>


}