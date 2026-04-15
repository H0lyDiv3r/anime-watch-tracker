package com.example.anime_list.ui.Home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_list.data.JikanRepository
import com.example.anime_list.model.Anime
import com.example.anime_list.model.SeasonNowResponse
import kotlinx.coroutines.launch


sealed interface HomeUiState{
    data class Success(val animes: List<Anime> ): HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

class HomeViewModel( private val jikanRepository: JikanRepository): ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    fun getSeasonNow() {
        viewModelScope.launch {

        }
    }

}