package ru.kmosunoff.sEstateTest

import android.app.Application
import ru.kmosunoff.sEstateTest.diComponents.AppComponent
import ru.kmosunoff.sEstateTest.diComponents.DaggerAppComponent
import ru.kmosunoff.sEstateTest.diModules.JokesDaoModule

class SEstateTestApplication: Application() {

    companion object {
        lateinit var INSTANCE: SEstateTestApplication
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
        graph = DaggerAppComponent.builder().jokesDaoModule(JokesDaoModule()).build()
    }
}