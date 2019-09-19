package ru.kmosunoff.sEstateTest.diModules

import dagger.Module
import dagger.Provides
import ru.kmosunoff.sEstateTest.dao.JokesDao
import javax.inject.Singleton

@Module
class JokesDaoModule {

    @Provides
    @Singleton
    fun provideJokesDao() = JokesDao()
}