package com.Assessment.photon.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Assessment.photon.Model.NewYorkSchool
import com.Assessment.photon.view.Navigation.ScreenRoute
import com.Assessment.photon.viewmodel.NewYorkSchoolViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewYorkSchoolListScreen(
    navController: NavController,
    viewModel: NewYorkSchoolViewModel
) {
    val newYorkSchool by viewModel.newYorkSchool.observeAsState(emptyList())

    LaunchedEffect(Unit){
        viewModel.fetchNewYorkSchool()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "NewYork School List")
            },
              colors =  TopAppBarDefaults.topAppBarColors(
                  containerColor = MaterialTheme.colorScheme.primary,
                  titleContentColor = Color.White,
              ),
                )
        }, content =  {
            Column (
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement =  Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                if(newYorkSchool.isEmpty()){
                    Text(text = "Loading...")
                } else {
                    NewYorkSchoolList(newYorkSchool,navController )
                }
            }
        }
    )
}

@Composable
fun NewYorkSchoolList(newYorkSchool : List<NewYorkSchool>,
                      navController: NavController,){
    LazyColumn(modifier = Modifier.padding(16.dp) ){
        items(newYorkSchool){school ->
            Text(text = "${school.school_name}",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(
                            route = ScreenRoute.SchoolDetails.passDetails(school.overview_paragraph)
                        )
                    }
                    .padding(16.dp)
            )
            Divider()
        }
    }
}