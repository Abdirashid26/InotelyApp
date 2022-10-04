package com.example.inotelyapp.ui.theme.screens.navigation

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inotelyapp.ui.theme.screens.getStarted.GetStartedScreen
import com.example.inotelyapp.ui.theme.screens.mainScreen.MainScreen
import com.example.inotelyapp.ui.theme.screens.signIn.SignInScreen
import com.example.inotelyapp.ui.theme.screens.signUp.SignUpScreen
import com.example.inotelyapp.ui.vm.FirebaseViewModel


@Composable
fun NavGraph(
    navHostController: NavHostController,
    firebaseViewModel: FirebaseViewModel = hiltViewModel()
){

    var startDestination by remember {
        mutableStateOf(Screen.GetStarted.route)
    }

    val user  = firebaseViewModel.userLiveData?.observeAsState()


    if (user?.value?.email != null){
        Log.i("MESSAGE","From us od this Value")
//        firebaseViewModel.getNotes(user.value?.uid.toString())
        startDestination = Screen.Main.route
    }

    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ){
//        Get Started Screen Composable
        composable(
            route = Screen.GetStarted.route
        ){
            GetStartedScreen(navHostController = navHostController)
        }

//        Sign Up Screen Composable
        composable(
            route = Screen.SignUp.route,
        ){
            SignUpScreen(navHostController = navHostController)
        }

        //        Sign In Screen Composable
        composable(
            route = Screen.SignIn.route,
        ){
            SignInScreen(navHostController = navHostController)
        }

        composable(
            route = Screen.Main.route
        ){

                MainScreen(navHostController = navHostController)
        }




    }

}