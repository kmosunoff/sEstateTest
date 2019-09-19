package ru.kmosunoff.sEstateTest.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.kmosunoff.sEstateTest.dao.Joke

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface JokesView: MvpView {

    fun showJokes()
    fun hideJokes()

    fun showProgress()
    fun hideProgress()

    fun showError()
    fun hideError()
}