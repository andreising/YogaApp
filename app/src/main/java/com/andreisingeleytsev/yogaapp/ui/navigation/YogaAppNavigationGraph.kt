package com.andreisingeleytsev.yogaapp.ui.navigation


import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.yogaapp.ui.screens.detail_screen.DetailScreen
import com.andreisingeleytsev.yogaapp.ui.screens.menu_screen.MenuScreen
import com.andreisingeleytsev.yogaapp.ui.screens.practice_screen.PracticeScreen
import com.andreisingeleytsev.yogaapp.ui.screens.settiings_screen.SettingsScreen
import com.andreisingeleytsev.yogaapp.ui.screens.start_screen.StartScreen
import com.andreisingeleytsev.yogaapp.ui.utils.Routes


@Composable
fun YogaAppNavigationGraph(mediaPlayer: MediaPlayer?) {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Routes.START_SCREEN) {
        composable(Routes.START_SCREEN){
            StartScreen(navHostController)
        }
        composable(Routes.DETAILS_SCREEN){
            DetailScreen(navHostController)
        }
        composable(Routes.MENU_SCREEN){
            MenuScreen(navHostController)
        }
        composable(Routes.PRACTICE_SCREEN){
            PracticeScreen(navHostController)
        }
        composable(Routes.SETTINGS_SCREEN){
            SettingsScreen(mediaPlayer, navHostController)
        }
    }
}
