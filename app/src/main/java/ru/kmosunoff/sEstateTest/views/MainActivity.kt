package ru.kmosunoff.sEstateTest.views

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_documentation.*
import ru.kmosunoff.sEstateTest.R
import ru.kmosunoff.sEstateTest.presenters.MainPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mMainPresenter: MainPresenter

    private lateinit var jokesFragment: JokesFragment
    private lateinit var documentationFragment: DocumentationFragment

    enum class Tab {
        JOKES_TAB, DOCUMENTATION_TAB
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_jokes -> {
                mMainPresenter.onTabWasSelected(Tab.JOKES_TAB)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_documentation -> {
                mMainPresenter.onTabWasSelected(Tab.DOCUMENTATION_TAB)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        android:background="?android:attr/windowBackground"

        app:defaultNavHost="true"

        android:name="androidx.navigation.fragment.NavHostFragment"

        app:navGraph="@navigation/mobile_navigation"
        */

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val jf = supportFragmentManager.findFragmentByTag(Tab.JOKES_TAB.toString()) as JokesFragment?
        if (jf == null) {
            jokesFragment = JokesFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.mainContainer, jokesFragment, Tab.JOKES_TAB.toString())
                .hide(jokesFragment)
                .commit()

        }
        else {
            jokesFragment = jf
        }

        val df = supportFragmentManager.findFragmentByTag(Tab.DOCUMENTATION_TAB.toString()) as DocumentationFragment?
        if (df == null) {
            documentationFragment = DocumentationFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.mainContainer, documentationFragment, Tab.DOCUMENTATION_TAB.toString())
                .hide(documentationFragment)
                .commit()

        }
        else {
            documentationFragment = df
        }

        mMainPresenter.onTabWasSelected(mMainPresenter.getActiveTab())
    }

    override fun showTab(tab: Tab, activeTab: Tab) {

        val activeFragment: MvpAppCompatFragment = when (activeTab) {
            Tab.JOKES_TAB -> jokesFragment
            Tab.DOCUMENTATION_TAB -> documentationFragment
        }

        val newFragment: MvpAppCompatFragment = when (tab) {
            Tab.JOKES_TAB -> jokesFragment
            Tab.DOCUMENTATION_TAB -> documentationFragment
        }

        val newTitle: Int = when (tab) {
            Tab.JOKES_TAB -> R.string.title_jokes
            Tab.DOCUMENTATION_TAB -> R.string.title_documentation
        }

        setTitle(newTitle)

        supportFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(newFragment)
            .commit()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean
    {
        if (mMainPresenter.getActiveTab() == Tab.DOCUMENTATION_TAB
            && keyCode == KeyEvent.KEYCODE_BACK
            && documentationFragment.webView.canGoBack()
        ) {
            documentationFragment.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
