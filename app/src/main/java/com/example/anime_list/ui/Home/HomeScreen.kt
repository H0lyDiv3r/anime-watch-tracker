package com.example.anime_list.ui.Home

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.anime_list.model.Anime
import com.example.anime_list.ui.auth.AuthViewModel
import io.github.jan.supabase.auth.auth

@Composable
fun HomeScreen(navController: NavController) {
    val authViewModel: AuthViewModel = viewModel()
    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    val uiState by authViewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {

        val user =authViewModel.supabase.auth.currentUserOrNull()
        if(user == null){
         navController.navigate("login")
        }

    }

    Column() {

        when (homeViewModel.homeUiState) {
            is HomeUiState.Loading -> Text("loading")
            is HomeUiState.Success -> Show(animes= (homeViewModel.homeUiState as HomeUiState.Success).animes)
            is HomeUiState.Error -> Text("error")
        }
    }
}

@Composable
fun Show(animes: List<Anime>?){

    val pagerState = rememberPagerState(pageCount = { animes?.size ?: 0 })



    HorizontalPager (
        state = pagerState,
    ) { page ->

        val anime = animes?.getOrNull(page)
        anime?.let { AnimeCard(it,
            modifier =  Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(8.dp)
            ) }
//        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text("Page $page")
//        }
    }
//    LazyRow () {
//        items(items = animes ?: emptyList() ){ anime: Anime ->
//
////            Text(text = anime.title ?: "")
//
//            AnimeCard(
//                anime,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(250.dp)  // Fixed total height - adjust as needed
//                    .padding(8.dp)
//
//            )
//
//        }
//    }
}


@Composable
fun AnimeCard(anime: Anime, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(anime.images?.jpg?.image_url ?: anime.images?.webp?.image_url)
                    .crossfade(true)
                    .build(),
                contentDescription = anime.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = anime.title ?: anime.title_english ?: "Unknown",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    anime.title_japanese?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray,
                            maxLines = 1
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    anime.score?.let {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("★", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(String.format("%.1f", it), style = MaterialTheme.typography.bodySmall)
                        }
                    }
                    anime.type?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}