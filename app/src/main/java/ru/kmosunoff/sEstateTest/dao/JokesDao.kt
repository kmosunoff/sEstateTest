package ru.kmosunoff.sEstateTest.dao

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import ru.kmosunoff.sEstateTest.presenters.JokesPresenter

class JokesDao {
    fun loadJokes(jokesPresenter: JokesPresenter, amount: Int) {
        val apiService = JokesApiService.create()
        apiService.getJokes(amount).enqueue(object : retrofit2.Callback<RandomJokesResponse> {

            override fun onResponse(call: Call<RandomJokesResponse>, response: Response<RandomJokesResponse>) {
                val jokes = response.body()?.value
                jokesPresenter.onJokesLoaded(jokes)
            }

            override fun onFailure(call: Call<RandomJokesResponse>, t: Throwable) {
                jokesPresenter.onLoadFailure()
                Log.e("Dao error", t.message.toString())
            }

        })
    }
}