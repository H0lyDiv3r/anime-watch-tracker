package com.example.anime_list.ui.auth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AuthScreen(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {


    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ){

        composable(route = "login") {
            LoginScreen(modifier = modifier, navController=navController, authViewModel = authViewModel)
        }
        composable(
            route = "signup"
        ) {
           SignupScreen(navController = navController, authViewModel = authViewModel)
        }
        composable (route = "home" ) {
            Button(onClick = {
                authViewModel.SignOut()
            }
            ){
                Text("logout")
            }
        }
    }



}