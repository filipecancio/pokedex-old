package dev.cancio.pokedex.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import dev.cancio.pokedex.ui.screen.HomeScreen

@Composable
fun BottomBar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    val itemList: List<NavItem> = listOf(
        NavItem.Home,
        NavItem.Search,
        NavItem.Likes,
        NavItem.Who
    )

    NavigationBar {
        itemList.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}


sealed class NavItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavItem("home", Icons.Filled.Home, "Home")
    object Likes : NavItem("likes", Icons.Filled.Favorite, "Likes")
    object Search : NavItem("search", Icons.Filled.Search, "Search")
    object Who : NavItem("who", Icons.Filled.Face, "Who")
}