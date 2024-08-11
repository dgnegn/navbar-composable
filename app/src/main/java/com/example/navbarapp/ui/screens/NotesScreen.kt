package com.example.navbarapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navbarapp.ui.navigation.Screen

@Composable
fun NotesScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Note Screen")
        Spacer(Modifier.heightIn(16.dp))
        Button(onClick = { navController.navigate(Screen.Categories.route) }) {
            Text("Go to Categories")
        }

    }
}
