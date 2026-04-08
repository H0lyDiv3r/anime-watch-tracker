package com.example.anime_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    object Discover: Screen("discover")

    object List: Screen("list")

    object Profile: Screen("profile")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavTree() {

    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = currentRoute in listOf(
        Screen.Home.route,
        Screen.Discover.route,
        Screen.List.route,
        Screen.Profile.route
    )


    Scaffold(modifier = Modifier.fillMaxSize(),

        topBar = { CenterAlignedTopAppBar(

            title = {
                Text(text="home", fontSize = 12.sp)
            }


        ) },

        bottomBar = {
        if(showBottomBar){
            BottomNav(navController)
        }
    }) {innerPadding ->

        NavHost(
            modifier = Modifier.padding(innerPadding),
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
            composable (route = Screen.Discover.route) {
                Text("discover")
            }
            composable (route= Screen.List.route) {
                Text("list")
            }
            composable (route = Screen.Profile.route) {
                Text("profile")
            }
        }


    }


}