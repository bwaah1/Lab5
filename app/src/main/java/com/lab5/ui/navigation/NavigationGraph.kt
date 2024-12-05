package com.lab5.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lab5.ui.screens.subjectDetails.SubjectDetailsScreen
import com.lab5.ui.screens.subjectsList.SubjectsListScreen

const val SCREEN_SUBJECTS_LIST = "subjectsList"
const val SCREEN_SUBJECT_DETAILS = "subjectDetails"

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = SCREEN_SUBJECTS_LIST,
        modifier = modifier
    ) {
        // Subjects List Screen
        composable(route = SCREEN_SUBJECTS_LIST) {
            SubjectsListScreen(onDetailsScreen = { id ->
                navController.navigate("$SCREEN_SUBJECT_DETAILS/$id")
            })
        }

        composable(
            route = "$SCREEN_SUBJECT_DETAILS/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            SubjectDetailsScreen(id = id)
        }
    }
}
