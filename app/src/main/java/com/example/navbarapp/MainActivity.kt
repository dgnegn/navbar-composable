package com.example.navbarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navbarapp.ui.navigation.Screen
import com.example.navbarapp.ui.navigation.Screen.Companion.routes
import com.example.navbarapp.ui.screens.CategoriesScreen
import com.example.navbarapp.ui.screens.NotesScreen
import com.example.navbarapp.ui.screens.SettingsScreen
import com.example.navbarapp.ui.theme.NavbarAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavbarAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
                val currentDestination = currentBackStackEntryAsState?.destination

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            routes.forEach { screen ->
                                NavigationBarItem(
                                    icon = { Icon(screen.icon, contentDescription = screen.route) },
                                    label = { Text(text = screen.route) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            // Pop up to the start destination of the graph to
                                            // avoid building up a large stack of destinations
                                            // on the back stack as users select items
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                                                               saveState = true
                                            }
                                            // Avoid multiple copies of the same destination when
                                            // reselecting the same item
                                            launchSingleTop = true

                                        }
                                    }
                                )
                            }

                        }
                    }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Notes.route,
                        Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Notes.route) {
                            NotesScreen(navController = navController)
                        }

                        composable(Screen.Categories.route) {
                            CategoriesScreen(navController = navController)
                        }

                        composable(Screen.Settings.route) {
                            SettingsScreen(navController = navController)
                        }


                    }

                }

            }
        }
    }
}

