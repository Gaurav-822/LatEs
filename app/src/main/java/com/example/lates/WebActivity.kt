package com.example.lates

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_activity)

        val intent = intent
        val src = intent.getStringExtra("src")

        val web_view = findViewById<WebView>(R.id.web_view)
        if (src != null) {
            web_view.loadUrl(src)
        };
    }
}