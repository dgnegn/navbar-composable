package com.aplussoft.navigationapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.aplussoft.navigationapp.ui.navigation.Screen

@Composable
fun CategoriesDetailScreen(navController: NavHostController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Categories Detail Screen")
        IconButton(onClick = { navController.navigate(Screen.Categories.route){
            popUpTo(Screen.Categories.route)
            launchSingleTop = true
            restoreState = true

        } }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Arrow_Back")

        }

    }

}