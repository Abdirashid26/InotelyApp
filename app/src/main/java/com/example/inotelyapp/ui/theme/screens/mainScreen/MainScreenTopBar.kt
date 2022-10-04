package com.example.inotelyapp.ui.theme.screens.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inotelyapp.R
import com.example.inotelyapp.ui.theme.screens.navigation.Screen
import com.example.inotelyapp.ui.vm.FirebaseViewModel


@Composable
fun MainScreenTopAppBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    firebaseViewModel: FirebaseViewModel  = hiltViewModel()
){
        TopAppBar(
            modifier = modifier,
            backgroundColor = Color(0xFFF8EEE2),
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var expanded by remember {
                    mutableStateOf(false)
                }
                IconButton(onClick = { expanded = true }) {

                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = "Log Out",
                        tint = Color.Black
                    )
                    
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        DropdownMenuItem(onClick = {
                            firebaseViewModel.logOutUser()
                            navHostController.popBackStack()
                        }) {
                            Text(
                                text = "Log Out"
                            )
                        }
                    }
                }


                Text(
                    text = "All notes",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.nubold)),
                        fontSize = MaterialTheme.typography.h6.fontSize
                    ),
                    color = Color.Black
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Button",
                        tint = Color.Black
                    )
                }

            }

        }
}




@Preview(showBackground = true)
@Composable
fun MainScreenTopAppBarPreview(){
    MainScreenTopAppBar(navHostController = rememberNavController())
}