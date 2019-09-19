package ru.kmosunoff.sEstateTest.presenters

import com.arellomobile.mvp.MvpPresenter
import ru.kmosunoff.sEstateTest.SEstateTestApplication
import ru.kmosunoff.sEstateTest.views.DocumentationView

class DocumentationPresenter: MvpPresenter<DocumentationView>() {

    init {
        SEstateTestApplication.graph.inject(this)
    }

}