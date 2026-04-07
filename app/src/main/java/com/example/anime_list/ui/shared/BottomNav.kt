package com.example.anime_list.ui.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Discover : BottomNavItem("discover", "Discover", Icons.Default.Place)
    object List: BottomNavItem("list", label = "list", Icons.Default.List)
    object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}

@Composable
fun BottomNav(navController: NavController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Discover,
        BottomNavItem.List,
        BottomNavItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar() {
        items.forEach { item->

            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {

                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label) }
            )



        }
    }

}