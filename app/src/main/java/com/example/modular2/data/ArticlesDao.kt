

package com.example.modular2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<Article>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(article: Response<ResponseArticles>)


    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()
}