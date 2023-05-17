package com.example.football7.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.football7.R

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = intent.getStringExtra("url")!!


        webView = findViewById(R.id.id_webview)
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)


        webView.settings.javaScriptEnabled = true


        webView.settings.setSupportZoom(true)


    }

    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else finishAffinity()
    }


}