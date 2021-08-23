package com.example.modular2.repository

import androidx.room.withTransaction
import com.example.modular2.api.ApiService
import com.example.modular2.data.ArticlesDatabase
import com.example.modular2.helper.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val apiService : ApiService,
    private val db: ArticlesDatabase)
{
    private val articleDao = db.articlesDao()


    //suspend fun getArt() = apiService.getArticles()

    fun get() = networkBoundResource(
        query = {
            articleDao.getAllArticles()
        },
        fetch = {
            delay(2000)
            apiService.getArticles()
        },
        saveFetchResult = { article ->
            db.withTransaction {
                articleDao.deleteAllArticles()
                articleDao.insertArticles(article)
            }

        }
    )

}