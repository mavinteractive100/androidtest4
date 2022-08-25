package com.example.androiddata.data

import retrofit2.Response
import retrofit2.http.GET

interface FilmService {
    @GET("/films")
    suspend fun getFilmData(): Response<List<Film>>
}