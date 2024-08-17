package com.aplussoft.navigationapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Notes

import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector?) {

    object Notes : Screen("Notes", Icons.AutoMirrored.Filled.Notes)
    object Categories : Screen("Categories", Icons.Default.Category)
    object Favorites : Screen("Favorites", Icons.Default.Favorite)
    object Settings : Screen("Settings", Icons.Default.Settings)
    
    object NoteDetail : Screen("NoteDetailScreen", null)
    object CategoryDetail : Screen("CategoryDetailScreen", null)
    
    companion object{
        val navBarItems = listOf(
            Notes,
            Categories,
            Favorites,
            Settings
        )
    }

}