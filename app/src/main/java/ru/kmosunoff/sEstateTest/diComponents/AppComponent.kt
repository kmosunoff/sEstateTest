package ru.kmosunoff.sEstateTest.diComponents

import dagger.Component
import ru.kmosunoff.sEstateTest.dao.JokesDao
import ru.kmosunoff.sEstateTest.diModules.JokesDaoModule
import ru.kmosunoff.sEstateTest.presenters.DocumentationPresenter
import ru.kmosunoff.sEstateTest.presenters.JokesPresenter
import ru.kmosunoff.sEstateTest.presenters.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(JokesDaoModule::class))
interface AppComponent {

    fun inject(mainPresenter: MainPresenter)

    fun inject(jokesPresenter: JokesPresenter)

    fun inject(documentationPresenter: DocumentationPresenter)

}