package com.example.lates

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lates.adapter.ItemAdapter
import com.example.lates.data.Datasource
import com.example.lates.model.News

class MainActivity : AppCompatActivity() {
    // Api :
//     https://newsapi.org/v2/everything?q=tesla&from=2023-08-12&sortBy=publishedAt&apiKey=39ca51cf12cc47eda925bc10c16db603
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize data
        val myDataset = Datasource().loadNews()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
    }
}