package com.aplussoft.navigationapp.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aplussoft.navigationapp.ui.navigation.Screen.Companion.navBarItems
import kotlin.collections.any
import kotlin.collections.forEach

@Composable
fun MyBottomNavigationBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = navBarItems.any { it.route == currentRoute }
    if (showBottomBar)
        NavigationBar {
            navBarItems.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    icon = {if (item.icon != null) Icon(item.icon, contentDescription = item.route) },
                    label = { Text(text = item.route) }
                )
            }
        }

}