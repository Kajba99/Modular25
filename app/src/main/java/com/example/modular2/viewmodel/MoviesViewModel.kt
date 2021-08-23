package com.example.modular2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.asLiveData
import com.example.modular2.data.ResponseArticles
import com.example.modular2.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject




@HiltViewModel
class MoviesViewModel  @Inject constructor (private val repository: ArticlesRepository) : ViewModel(){

   val article = repository.get().asLiveData()





/*
    private val _response = MutableLiveData<ResponseArticles>()
    val responseMovies: LiveData<ResponseArticles> = _response

    init {
        getAllMovies()
    }

    private fun getAllMovies() = viewModelScope.launch {
        repository.getArt().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            } else {
                Log.d("tag" , "${response.code()}")
                // stavi alert dialog
            }
        }
    }
*/

}