package com.example.anime_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.anime_list.ui.Home.HomeScreen
import com.example.anime_list.ui.auth.AuthViewModel
import com.example.anime_list.ui.auth.LoginScreen
import com.example.anime_list.ui.auth.SignupScreen
import com.example.anime_list.ui.shared.BottomNav
//import com.example.anime_list.ui.shared.Screen
import kotlin.collections.contains



sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Home : Screen("home")
}
@Composable
fun NavTree() {

    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = currentRoute in listOf(
        Screen.Home.route
    )


    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        if(showBottomBar){
            BottomNav(navController)
        }
    }) {innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Login.route
        ){

            composable(route = Screen.Login.route) {
                LoginScreen(navController=navController, authViewModel = authViewModel)
            }
            composable(
                route = Screen.Signup.route
            ) {
                SignupScreen(navController = navController, authViewModel = authViewModel)
            }
            composable (route = Screen.Home.route ) {
                HomeScreen(navController)
            }
        }


    }


}