package ru.kmosunoff.sEstateTest.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.kmosunoff.sEstateTest.SEstateTestApplication
import ru.kmosunoff.sEstateTest.dao.Joke
import ru.kmosunoff.sEstateTest.dao.JokesDao
import ru.kmosunoff.sEstateTest.views.JokesView
import javax.inject.Inject

@InjectViewState
class JokesPresenter: MvpPresenter<JokesView>() {

    init {
        SEstateTestApplication.graph.inject(this)
    }


    var listOfJokes = ArrayList<Joke>()

    @Inject
    lateinit var mJokesDao: JokesDao

    fun onReloadButtonWasClicked(amount: Int) {
        viewState.hideError()
        viewState.hideJokes()
        viewState.showProgress()

        mJokesDao.loadJokes(this, amount)
    }

    fun onJokesLoaded(jokes: List<Joke>?) {
        listOfJokes.clear()
        jokes?.let {
            listOfJokes.addAll(jokes)
        }

        viewState.hideError()
        viewState.hideProgress()
        viewState.showJokes()
    }

    fun onLoadFailure() {
        viewState.hideProgress()
        viewState.hideJokes()
        viewState.showError()
    }
}