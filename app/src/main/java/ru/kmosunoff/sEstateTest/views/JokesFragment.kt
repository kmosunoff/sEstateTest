package ru.kmosunoff.sEstateTest.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_jokes.*

import ru.kmosunoff.sEstateTest.R
import ru.kmosunoff.sEstateTest.dao.Joke
import ru.kmosunoff.sEstateTest.dao.JokesAdapter
import ru.kmosunoff.sEstateTest.presenters.JokesPresenter

class JokesFragment : MvpAppCompatFragment(), JokesView {

    @InjectPresenter
    lateinit var mJokesPresenter: JokesPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reloadButton.setOnClickListener() {
            var amount = when (countEditText.text.toString()) {
                "" -> 1
                else -> countEditText.text.toString().toInt()
            }
            mJokesPresenter.onReloadButtonWasClicked(amount)
        }

        jokesRecyclerView.layoutManager = LinearLayoutManager(context)
        jokesRecyclerView.adapter = JokesAdapter(mJokesPresenter.listOfJokes, context)
    }

    override fun showJokes() {
        jokesRecyclerView.adapter?.notifyDataSetChanged()
        jokesRecyclerView.visibility = View.VISIBLE
    }

    override fun hideJokes() {
        jokesRecyclerView.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showError() {
        errorMessage.visibility = View.VISIBLE
    }

    override fun hideError() {
        errorMessage.visibility = View.GONE
    }
}
