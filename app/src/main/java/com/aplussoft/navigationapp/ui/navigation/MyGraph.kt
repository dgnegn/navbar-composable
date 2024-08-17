package com.aplussoft.navigationapp.ui.navigation

sealed class MyGraph(val route: String) {
    object NotesGraph : MyGraph("notes_graph")
    object CategoriesGraph : MyGraph("categories_graph")
    object FavoritesGraph : MyGraph("favorites_graph")
    object SettingsGraph : MyGraph("settings_graph")
}
