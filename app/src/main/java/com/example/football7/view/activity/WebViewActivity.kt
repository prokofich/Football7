package com.example.football7.view.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.football7.R
import com.example.football7.databinding.ActivityMainBinding
import com.example.football7.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private var webView: WebView? = null
    private var binding:ActivityWebViewBinding? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        val url = intent.getStringExtra("url")!!

        webView = binding?.idWebview
        webView?.webViewClient = WebViewClient()
        webView?.loadUrl(url)
        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.setSupportZoom(true)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (webView?.canGoBack() == true)
            webView?.goBack()
        else finishAffinity()
    }

}