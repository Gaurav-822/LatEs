package com.example.lates

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lates.adapter.ItemAdapter
import com.example.lates.networking.NewsApi
import com.example.lates.networking.NewsService
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var adapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pageNum: Int = 1
        getNews()
    }
    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object:retrofit2.Callback<NewsApi> {
            override fun onResponse(call: Call<NewsApi>, response: Response<NewsApi>) {
                Log.d("GBK", "Success!")
                val news = response.body()
                if (news != null) {
                    Log.d("GBK", news.toString())
                    adapter = ItemAdapter(this@MainActivity, news.articles)
                    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<NewsApi>, t: Throwable) {
                Log.d("GBK", "Failure!")
            }
        })
    }
}