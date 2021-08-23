package com.example.modular2.helper

sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    // <T> to put any kind of data inside
    class Success<T>(data : T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : Resource<T>(data, throwable)
}

