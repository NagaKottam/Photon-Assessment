package com.Assessment.photon.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Assessment.photon.view.Navigation.ScreenRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewYorkSchoolDetails(navController: NavController, schoolDetails : String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "NewYork School List")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(route = ScreenRoute.SchoolList.route){
                            popUpTo(ScreenRoute.SchoolList.route){
                                inclusive = true
                            }
                        }
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                }
            )
        }, content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = schoolDetails,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        })
}
