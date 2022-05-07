@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package dev.cancio.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dev.cancio.pokedex.navigation.MainNavigation
import dev.cancio.pokedex.navigation.BottomNavItem.*
import dev.cancio.pokedex.theme.PokedexTheme
import dev.cancio.pokedex.component.BottomBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    PokedexTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            val itemList = listOf(Home, Search, Likes, Who)
            Scaffold(
                bottomBar = { BottomBar(navController, itemList) }
            ) {
                MainNavigation(navController, itemList )
            }
        }
    }
}


