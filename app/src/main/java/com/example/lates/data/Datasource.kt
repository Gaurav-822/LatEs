package com.example.lates.data

import com.example.lates.R
import com.example.lates.model.News

class Datasource {
    fun loadNews(): List<News> {
        return listOf<News> (
            News(R.string.news1, R.drawable.image1),
            News(R.string.news2, R.drawable.image2),
            News(R.string.news3, R.drawable.image3),
            News(R.string.news4, R.drawable.image4),
            News(R.string.news5, R.drawable.image5),
            News(R.string.news6, R.drawable.image6),
            News(R.string.news7, R.drawable.image7),
            News(R.string.news8, R.drawable.image8),
            News(R.string.news9, R.drawable.image9),
            News(R.string.news10, R.drawable.image10)
        )
    }
}