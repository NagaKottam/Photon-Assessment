package com.Assessment.photon.view.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.Assessment.photon.view.NewYorkSchoolDetails
import com.Assessment.photon.view.NewYorkSchoolListScreen
import com.Assessment.photon.viewmodel.NewYorkSchoolViewModel

@Composable
fun NavGraph (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.SchoolList.route
    ) {
        // NewYork School List Composable
        composable(route = ScreenRoute.SchoolList.route){
            val viewModel = viewModel<NewYorkSchoolViewModel>()
            NewYorkSchoolListScreen(navController = navController, viewModel = viewModel)
        }

        // NewYork School Details Composable
        composable(route = ScreenRoute.SchoolDetails.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                type = NavType.StringType
            })){
            val details = it.arguments?.getString(DETAILS_ARGUMENT_KEY)
            if (details != null) {
                NewYorkSchoolDetails(navController = navController, schoolDetails = details)
            } else {
                NewYorkSchoolDetails(navController = navController, schoolDetails = "Details is null")
            }
        }
    }
}