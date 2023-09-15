package com.example.lates

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
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

        // Headline
        val textView: TextView = findViewById(R.id.headline)
        textView.text = headline

        // Description
        val textViewDescription: TextView = findViewById(R.id.details)
        textViewDescription.text = description

        // Source Link
        val source: TextView = findViewById(R.id.source)
        source.text = src
        source.movementMethod = LinkMovementMethod.getInstance()
    }
}