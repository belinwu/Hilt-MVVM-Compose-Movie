package com.piashcse.hilt_mvvm_compose_movie.ui.screens.tvseries.airing_today

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.piashcse.hilt_mvvm_compose_movie.data.model.GenreId
import com.piashcse.hilt_mvvm_compose_movie.data.model.moviedetail.Genre
import com.piashcse.hilt_mvvm_compose_movie.ui.component.TvSeries

@Composable
fun AiringTodayTvSeries(
    navController: NavController,
    genres: List<Genre>? = null,
) {
    val airingTodayViewModel = hiltViewModel<AiringTodayTvSeriesViewModel>()
    TvSeries (
        navController = navController,
        tvSeries = airingTodayViewModel.airingTodayTvSeries.collectAsLazyPagingItems(),
        genres = genres,
        selectedName = airingTodayViewModel.selectedGenre.value
    ){
        airingTodayViewModel.filterData.value = GenreId(it?.id.toString())
        it?.let {
            airingTodayViewModel.selectedGenre.value = it
        }
    }
}