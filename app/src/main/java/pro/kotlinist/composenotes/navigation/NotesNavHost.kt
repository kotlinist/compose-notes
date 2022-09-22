package pro.kotlinist.composenotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pro.kotlinist.composenotes.screens.Add
import pro.kotlinist.composenotes.screens.Main
import pro.kotlinist.composenotes.screens.Note
import pro.kotlinist.composenotes.screens.Start

sealed class NavRoute(val route: String) {
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { Start(navController) }
        composable(NavRoute.Main.route) { Main(navController) }
        composable(NavRoute.Add.route) { Add(navController) }
        composable(NavRoute.Note.route) { Note(navController) }
    }

}