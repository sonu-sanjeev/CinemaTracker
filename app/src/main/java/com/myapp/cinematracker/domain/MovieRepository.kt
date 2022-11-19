package com.myapp.cinematracker.domain

import com.myapp.cinematracker.api.ApiResponse
import com.myapp.cinematracker.data.MovieData

interface MovieRepository {
    fun getMovies(): ApiResponse<List<MovieData>>
}