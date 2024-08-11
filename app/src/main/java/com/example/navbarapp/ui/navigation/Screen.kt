package com.example.navbarapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector) {
    data object Notes : Screen("Notes", Icons.Default.Home)
    data object Categories : Screen("Categories", Icons.Default.MailOutline)
    data object Settings : Screen("Settings", Icons.Default.Settings)

    companion object {
        val routes = listOf(Notes, Categories, Settings)
    }

}