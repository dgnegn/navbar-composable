package com.aplussoft.navigationapp.ui.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.aplussoft.navigationapp.ui.screens.CategoriesDetailScreen
import com.aplussoft.navigationapp.ui.screens.CategoriesScreen
import com.aplussoft.navigationapp.ui.screens.FavoritesScreen
import com.aplussoft.navigationapp.ui.screens.NotesDetailScreen
import com.aplussoft.navigationapp.ui.screens.NotesScreen
import com.aplussoft.navigationapp.ui.screens.SettingsScreen


fun NavGraphBuilder.notesGraph(navController: NavHostController) {

    composable(route = Screen.Notes.route) {
        NotesScreen(navController)
    }
    navigation(
        route = MyGraph.CategoriesGraph.route,
        startDestination = Screen.Categories.route
    ) {
        composable(route = Screen.Categories.route) {
            CategoriesScreen(navController = navController)
        }
        composable(route = Screen.CategoryDetail.route) {
            CategoriesDetailScreen(navController)
        }
    }

    composable(route = Screen.Favorites.route) {
        FavoritesScreen(navController)
    }

    composable(Screen.Settings.route) {
        SettingsScreen(navController)
    }
    navigation(
        route = MyGraph.NotesGraph.route,
        startDestination = Screen.Notes.route
    ) {
        composable(route = Screen.Notes.route) {
            NotesScreen(navController)
        }
        composable(route = Screen.NoteDetail.route) {
            NotesDetailScreen(navController)
        }
    }

}