package com.myapp.cinematracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapp.cinematracker.domain.MovieRepository
import java.lang.IllegalArgumentException

class MovieViewModelFactory(
    private val movieRepository: MovieRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java))
            MovieViewModel(movieRepository) as T
        else
            throw IllegalArgumentException("Unknown ViewModel Class")
    }
}