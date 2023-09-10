package com.example.lates.data

import com.example.lates.R
import com.example.lates.model.News

class Datasource {
    fun loadNews(): List<News> {
        return listOf<News> (
            News(R.string.news1),
            News(R.string.news2),
            News(R.string.news3),
            News(R.string.news4),
            News(R.string.news5),
            News(R.string.news6),
            News(R.string.news7),
            News(R.string.news8),
            News(R.string.news9),
            News(R.string.news10)
        )
    }
}