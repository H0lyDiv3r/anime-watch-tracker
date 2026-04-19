package com.example.anime_list.ui.Home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.anime_list.MainContainer
import com.example.anime_list.data.JikanRepository
import com.example.anime_list.model.Anime
import com.example.anime_list.model.SeasonNowResponse
import kotlinx.coroutines.launch
import okio.IOException


sealed interface HomeUiState{
    data class Success(val animes: List<Anime>? ): HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

class HomeViewModel( private val jikanRepository: JikanRepository): ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set


    init {
        getSeasonNow()
    }

    fun getSeasonNow() {
        viewModelScope.launch {

            homeUiState = HomeUiState.Loading
            homeUiState = try {
                HomeUiState.Success(jikanRepository.getThisSeaon().body()?.data)
            } catch(e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException){
                HomeUiState.Error
            }
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MainContainer)
                val jikanRepository = application.container.jikanRepository
                HomeViewModel(jikanRepository)
            }
        }
    }

}