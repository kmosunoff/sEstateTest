package ru.kmosunoff.sEstateTest.dao

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface JokesApiService {

    @GET(value = "random/{amount}")
    fun getJokes(@Path("amount") amount: Int) : Call<RandomJokesResponse>

    companion object Factory {
        fun create(): JokesApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.icndb.com/jokes/")
                .build()
            return retrofit.create(JokesApiService::class.java)
        }
    }
}