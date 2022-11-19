package com.myapp.cinematracker.domain

import com.google.gson.Gson
import com.myapp.cinematracker.api.ApiResponse
import com.myapp.cinematracker.data.MovieData
import com.myapp.cinematracker.data.convertResponse
import com.myapp.cinematracker.data.staticResponse
import java.lang.RuntimeException

class MovieRepositoryImpl(private val gson: Gson) : MovieRepository {

    override fun getMovies(): ApiResponse<List<MovieData>> {
        return try {
            val response = staticResponse.convertResponse(gson)
            val movieList = response.movieList
            if (movieList.isNullOrEmpty().not()) {
                ApiResponse.success(movieList)
            } else {
                ApiResponse.error(NoSuchFieldException("No movies found!"))
            }
        } catch (ex: RuntimeException) {
            ApiResponse.error(ex)
        }
    }
}