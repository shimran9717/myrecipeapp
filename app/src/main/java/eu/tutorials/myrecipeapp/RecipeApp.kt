package eu.tutorials.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.tutorials.myrecipeapp.Screen.RecipeScreen.route

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel:MainViewModel= viewModel()
    val viewstate by recipeViewModel.categoriesState
//    NavHost(navController = , startDestination = 
//    NavHost(navController = , startDestination =   )
@Composable
fun MyNavHost(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route=Screen.RecipeScreen.route) {
            // Your first screen content
            RecipeScreen(viewstate =viewstate, navigateToDetails = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                    navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route=Screen.DetailScreen.route) {
            // Your second screen content
            val category=navController.previousBackStackEntry?.savedStateHandle?.
                    get<Category>("cat")?:Category("","","","")
            CategoryDetailScreen(category=category)
        }
        // Add more screens here as needed
    }
}

    MyNavHost(navController =navController , startDestination = Screen.RecipeScreen.route)
}



