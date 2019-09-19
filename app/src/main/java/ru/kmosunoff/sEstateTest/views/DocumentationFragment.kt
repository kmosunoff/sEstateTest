package ru.kmosunoff.sEstateTest.views

import android.content.Context
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_documentation.*

import ru.kmosunoff.sEstateTest.R
import ru.kmosunoff.sEstateTest.presenters.DocumentationPresenter

class DocumentationFragment : MvpAppCompatFragment(), DocumentationView {

    @InjectPresenter
    lateinit var mDocumentationPresenter: DocumentationPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_documentation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

        }
        webView.loadUrl("http://www.icndb.com/api/")
    }
}
