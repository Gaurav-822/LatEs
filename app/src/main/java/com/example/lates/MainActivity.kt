package com.example.lates

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.lates.adapter.ItemAdapter
import com.example.lates.networking.NewsApi
import com.example.lates.networking.NewsService
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var adapter: ItemAdapter
    lateinit var shimmerFrameLayout: ShimmerFrameLayout
    lateinit var recyclerView: RecyclerView
    lateinit var refreshLayout: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Shimmer
        shimmerFrameLayout = findViewById(R.id.shimmer)
        recyclerView = findViewById(R.id.recycler_view)
        shimmerFrameLayout.startShimmer()

        // Refresh
        refreshLayout = findViewById(R.id.refresh)

        getNews()

        refreshLayout.setOnRefreshListener {
            shimmerFrameLayout.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
            shimmerFrameLayout.startShimmer()
            getNews()
            refreshLayout.isRefreshing = false
        }
    }
    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object:retrofit2.Callback<NewsApi> {
            override fun onResponse(call: Call<NewsApi>, response: Response<NewsApi>) {
                Log.d("GBK", "Success!")
                shimmerFrameLayout.stopShimmer()
                shimmerFrameLayout.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE

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
                Log.d("GBK", "Retrying!")
                getNews()
            }
        })
    }
}