package ru.kmosunoff.sEstateTest.dao

data class RandomJokesResponse(
    val type: String,
    val value: List<Joke>
)