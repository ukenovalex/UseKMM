package ru.ukenov.food2forkkmm.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) { navBackStackEntry ->
            Column {
                Text("RecipeListScreen")
                Divider()
                Button(onClick = {navController.navigate(Screen.RecipeDetail.route)}) {
                    Text("Go to RecipeDetail")
                }
            }
        }
        composable(route = Screen.RecipeDetail.route) { navBackStackEntry ->
            Text("RecipeDetailScreen")
        }
    }
}