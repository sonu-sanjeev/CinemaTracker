package com.myapp.cinematracker.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.myapp.cinematracker.api.ApiResponse
import com.myapp.cinematracker.data.MovieData
import com.myapp.cinematracker.domain.MovieRepository
import com.myapp.cinematracker.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieData>>()
    val movies: LiveData<List<MovieData>> = _movies

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<Event<String>>()
    val error: LiveData<Event<String>>
        get() = _error

    init {
        getMoviesListFromServer()
    }

    private fun getMoviesListFromServer() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val result = movieRepository.getMovies()
            _isLoading.value = false
            when(result) {
                is ApiResponse.Success -> {
                    _movies.postValue(result.data)
                }

                is ApiResponse.Error -> {
                    _error.postValue(Event(result.message))
                }
            }
        }
    }
}