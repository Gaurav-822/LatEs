package com.example.lates

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ImageView
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

        // Image
        val imageView: ImageView = findViewById(R.id.image)
        Glide.with(this)
            .load(img)
            .into(imageView);
        imageView.setOnClickListener {
            // Create an Intent with the ACTION_VIEW action and the URL that you want to open.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(img))

            // Call startActivity() to open the URL.
            startActivity(intent)
        }

        // Headline
        val textView: TextView = findViewById(R.id.headline)
        textView.text = headline
        textView.setOnClickListener {
            // Create an Intent with the ACTION_VIEW action and the URL that you want to open.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(src))

            // Call startActivity() to open the URL.
            startActivity(intent)
        }

        // Description
        val textViewDescription: TextView = findViewById(R.id.details)
        textViewDescription.text = description
    }
}