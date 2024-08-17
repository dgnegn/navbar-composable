package com.aplussoft.navigationapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable


import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost



@Composable
fun MyNavigation(navController: NavHostController) {

    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = { MyBottomNavigationBar(navController) }
    ) {
        NavHost(
            navController,
            startDestination = Screen.Notes.route,
            Modifier.padding(it),

            ) {
            notesGraph(navController)
        }
    }
}



