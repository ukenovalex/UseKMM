package ru.ukenov.food2forkkmm.android.presentation.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import ru.ukenov.food2forkkmm.android.presentation.recipe_detail.RecipeDetailScreen
import ru.ukenov.food2forkkmm.android.presentation.recipe_detail.RecipeDetailViewModel
import ru.ukenov.food2forkkmm.android.presentation.recipe_list.RecipeListScreen
import ru.ukenov.food2forkkmm.android.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val owner = navController.getViewModelStoreOwner(navController.graph.id)
            val viewModel: RecipeListViewModel = viewModel(
                owner,
                "RecipeListViewModel",
                factory
            )
            RecipeListScreen(onSelectRecipe = { recipeId ->
                navController.navigate(Screen.RecipeDetail.route + "/$recipeId")
            })
        }
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
                type = NavType.IntType
            }),
        ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val owner = navController.getViewModelStoreOwner(navController.graph.id)
            val viewModel: RecipeDetailViewModel = viewModel(
                owner,
                "RecipeDetailViewModel",
                factory
            )

            println(viewModel.recipeId)
            println(navBackStackEntry.arguments)

            RecipeDetailScreen(
                recipeId = viewModel.recipeId.value
            )
        }
    }
}
