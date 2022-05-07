package dev.cancio.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BaseNavItem(
    open val route: String,
    open val icon: ImageVector,
    open val title: String,
    open val screen: (@Composable () -> Unit)
)