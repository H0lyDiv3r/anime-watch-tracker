package com.example.anime_list.ui.auth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AuthScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ){

        composable(route = "login") {
            LoginScreen(modifier = modifier, navController=navController)
        }
        composable(
            route = "signup"
        ) {
           SignupScreen(navController = navController)
        }
        composable (route = "home" ) {
            Text("home")
        }
    }



}