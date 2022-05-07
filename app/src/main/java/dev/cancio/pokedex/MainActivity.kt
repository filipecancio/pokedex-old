@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package dev.cancio.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.cancio.pokedex.theme.PokedexTheme
import dev.cancio.pokedex.ui.component.BottomBar
import dev.cancio.pokedex.ui.component.NavItem
import dev.cancio.pokedex.ui.screen.HomeScreen
import dev.cancio.pokedex.ui.screen.LikedScreen
import dev.cancio.pokedex.ui.screen.SearchScreen
import dev.cancio.pokedex.ui.screen.WhoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavItem.Home.route){
        composable(NavItem.Home.route) { HomeScreen()}
        composable(NavItem.Likes.route) { LikedScreen() }
        composable(NavItem.Search.route) { SearchScreen() }
        composable(NavItem.Who.route) { WhoScreen() }
    }
}
