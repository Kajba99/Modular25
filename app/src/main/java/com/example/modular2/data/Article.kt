package com.example.modular2.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
data class Article(
    @PrimaryKey var description: String,
    val title: String,
    val url: String,
    val urlToImage: String
)