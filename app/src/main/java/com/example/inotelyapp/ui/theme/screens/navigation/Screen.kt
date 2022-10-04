package com.example.inotelyapp.ui.theme.screens.navigation

sealed class Screen(val route : String){
    object GetStarted : Screen(route = "GetStarted_Screen")
    object SignUp : Screen(route = "SignUp_Screen")
    object SignIn : Screen(route = "SignIn_Screen")
    object Main : Screen(route = "Main_Screen")
}
