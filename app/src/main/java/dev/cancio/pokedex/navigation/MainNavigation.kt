package dev.cancio.pokedex.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.cancio.pokedex.ui.screen.HomeScreen
import dev.cancio.pokedex.ui.screen.LikedScreen
import dev.cancio.pokedex.ui.screen.SearchScreen
import dev.cancio.pokedex.ui.screen.WhoScreen
import dev.cancio.pokedex.navigation.BottomNavItem.*

@Composable
fun MainNavigation(navController: NavHostController, itemList: List<BaseNavItem>) {
    NavHost(navController = navController, startDestination = itemList.first().route) {
        itemList.forEach { item -> composable(item.route) { item.screen.invoke() } }
    }
}

sealed class PokedexRoutes(val itemList: List<BaseNavItem>){
    object MainRoute: PokedexRoutes(listOf(Home, Search, Likes, Who))
}

sealed class BottomNavItem(
    override val route: String,
    override val icon: ImageVector,
    override val title: String,
    override val screen: (@Composable () -> Unit)
) : BaseNavItem(route, icon, title, screen) {
    object Home : BottomNavItem("home", Icons.Filled.Home, "Home", { HomeScreen() })
    object Likes : BottomNavItem("likes", Icons.Filled.Favorite, "Likes", { LikedScreen() })
    object Search : BottomNavItem("search", Icons.Filled.Search, "Search", { SearchScreen() })
    object Who : BottomNavItem("who", Icons.Filled.Face, "Who", { WhoScreen() })
}