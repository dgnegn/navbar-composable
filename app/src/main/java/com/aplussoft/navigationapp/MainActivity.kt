package com.aplussoft.navigationapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.aplussoft.navigationapp.ui.navigation.MyNavigation
import com.aplussoft.navigationapp.ui.theme.NavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAppTheme (darkTheme = false, dynamicColor = true) {
                val navController = rememberNavController();
                MyNavigation(navController)
            }
        }
    }

}
