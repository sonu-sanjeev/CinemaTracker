package com.myapp.cinematracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.gson.Gson
import com.myapp.cinematracker.data.MovieData
import com.myapp.cinematracker.domain.MovieRepositoryImpl
import com.myapp.cinematracker.ui.theme.CinemaTrackerTheme
import com.myapp.cinematracker.ui.viewmodel.MovieViewModel
import com.myapp.cinematracker.ui.viewmodel.MovieViewModelFactory
import com.myapp.cinematracker.util.Event

class MainActivity : ComponentActivity() {
    private val movieRepository = MovieRepositoryImpl(Gson())
    private val movieViewModelFactory = MovieViewModelFactory(movieRepository)
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaTrackerTheme {
                movieViewModel =
                    ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen(
                        movieViewModel = movieViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(movieViewModel: MovieViewModel) {
    val isLoading by movieViewModel.isLoading.observeAsState(false)
    val movies by movieViewModel.movies.observeAsState(listOf())
    val error by movieViewModel.error.observeAsState(Event(""))

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.app_name)) })
        },
        content = {
            when {
                isLoading -> {
                    CenterProgressBar()
                }
                (error.getContentIfNotHandled()?.isNotBlank() == true) -> {
                    Toast.makeText(LocalContext.current, error.peekContent(), Toast.LENGTH_SHORT)
                        .show()
                }
                else -> MovieListScreen(movies = movies)
            }
        }
    )
}

@Composable
fun MovieListScreen(movies: List<MovieData>) {
    LazyColumn {
        itemsIndexed(movies) { _, movie ->
            MovieCard(movie = movie)
        }
    }
}

@Composable
fun CenterProgressBar() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCard(movie: MovieData) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                model = "", contentDescription = stringResource(R.string.movie_banner),
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = movie.movieTitle,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${stringResource(id = R.string.release_date)} ${
                        movie.releaseDate
                    }",
                    style = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${stringResource(id = R.string.rating)} ${movie.rating}",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

