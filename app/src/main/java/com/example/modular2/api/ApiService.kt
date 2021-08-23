package com.example.modular2.api

import com.example.modular2.helper.Constants
import com.example.modular2.data.ResponseArticles
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getArticles() : Response<ResponseArticles>

}