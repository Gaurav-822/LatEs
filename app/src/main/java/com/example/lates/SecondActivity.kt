package com.example.lates

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val intent = intent
        val headline = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val img = intent.getStringExtra("image")
        val src = intent.getStringExtra("source")

        // Forwarding to web_view
        val intent_web = Intent(this, WebActivity::class.java)

        // Image
        val imageView: ImageView = findViewById(R.id.image)
        Glide.with(this)
            .load(img)
            .into(imageView);
        imageView.setOnClickListener {
            intent_web.putExtra("src", img)
            startActivity(intent_web)
        }

        // Headline
        val textView: TextView = findViewById(R.id.headline)
        textView.text = headline
        textView.setOnClickListener {
            intent_web.putExtra("src", src)
            startActivity(intent_web)
        }

        // Description
        val textViewDescription: TextView = findViewById(R.id.details)
        textViewDescription.text = description
    }
}