package ru.kmosunoff.sEstateTest.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.kmosunoff.sEstateTest.SEstateTestApplication
import ru.kmosunoff.sEstateTest.views.MainActivity
import ru.kmosunoff.sEstateTest.views.MainView

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    init {
        SEstateTestApplication.graph.inject(this)
    }

    private var activeTab: MainActivity.Tab = MainActivity.Tab.JOKES_TAB

    fun onTabWasSelected(tab: MainActivity.Tab) {
        viewState.showTab(tab, activeTab)
        activeTab = tab
    }

    fun getActiveTab() = activeTab


}