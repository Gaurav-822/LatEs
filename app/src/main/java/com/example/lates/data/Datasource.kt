package com.example.lates.data

import android.content.res.Resources
import android.widget.TextView
import com.example.lates.R
import com.example.lates.model.News


class Datasource {
    private fun urlFormatter(url: Int): String {
        return Resources.getSystem().getString(url)
    }
    fun loadNews(): List<News> {
        return listOf<News> (
            News(R.string.news1, urlFormatter(R.string.url1)),
            News(R.string.news2, urlFormatter(R.string.url2)),
            News(R.string.news3, urlFormatter(R.string.url1)),
        )
    }
}