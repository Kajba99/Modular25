package com.example.modular2.di

import android.app.Application
import androidx.room.Room
import com.example.modular2.api.ApiService
import com.example.modular2.data.ArticlesDatabase
import com.example.modular2.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL : String) : ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : ArticlesDatabase =
        Room.databaseBuilder(app, ArticlesDatabase::class.java, "articles_database")
            .build()


}