package com.example.anime_list.ui.Home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.anime_list.ui.auth.AuthViewModel
import io.github.jan.supabase.auth.auth

@Composable
fun HomeScreen(navController: NavController) {
    val authViewModel: AuthViewModel = viewModel()
    val uiState by authViewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {

        val user =authViewModel.supabase.auth.currentUserOrNull()
        if(user == null){
         navController.navigate("login")
        }

    }
    Button(onClick = {
        authViewModel.SignOut()
    }
    ){
        Text("logout")
    }
}