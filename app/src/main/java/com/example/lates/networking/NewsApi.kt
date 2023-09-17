package com.example.lates.networking

import com.example.lates.networking.Article

data class NewsApi(val totalResults: Int, val articles: List<Article>)