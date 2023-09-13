package com.example.lates.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class News(
    @StringRes val stringResourceId: Int,
    val imageUrl: String,
//    @DrawableRes val imageUrl: Int,
    )
