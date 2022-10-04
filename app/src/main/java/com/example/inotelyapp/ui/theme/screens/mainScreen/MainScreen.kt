package com.example.inotelyapp.ui.theme.screens.mainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inotelyapp.ui.theme.screens.navigation.Screen
import com.example.inotelyapp.ui.vm.FirebaseViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navHostController: NavHostController,
    firebaseViewModel: FirebaseViewModel = hiltViewModel()
){

    val isLoggedOut = firebaseViewModel.loggedOutLiveData?.observeAsState()

    if(isLoggedOut?.value == true){
        navHostController.popBackStack(Screen.SignIn.route, inclusive = true)
    }

    
    Scaffold(
        topBar = {
            MainScreenTopAppBar(navHostController = navHostController)
        },
        content = {
            MainScreenContent()
        }
    )


}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen(navHostController = rememberNavController())
}