package com.example.inotelyapp.ui.theme.screens.getStarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inotelyapp.R
import com.example.inotelyapp.ui.theme.Shapes
import com.example.inotelyapp.ui.theme.screens.navigation.Screen
import com.example.inotelyapp.ui.vm.FirebaseViewModel


@Composable
fun GetStartedScreen(
    navHostController: NavHostController,
    firebaseViewModel: FirebaseViewModel = hiltViewModel()
){




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8EEE2))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        )

        {

            Text(
                text = "INOTELY",
                style = TextStyle(
                  color = Color.Black,
                  fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontFamily = FontFamily(Font(R.font.nubold))
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
            horizontalArrangement = Arrangement.Center
                ){

            Image(
                painterResource(id = R.drawable.onboardingimage),
                contentDescription = "OnBoarding Image",
                modifier = Modifier
                    .width(268.dp)
                    .height(197.dp)
            )

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text="World’s Safest And\n" +
                            "Largest Digital Notebook",
                    fontFamily = FontFamily(Font(R.font.nubold)),
                    modifier = Modifier.padding(
                        top = 20.dp
                    ),
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text="INotely is the world’s safest, largest and intelligent digital notebook. Join over 1k users already using INotely.",
                    fontFamily = FontFamily(Font(R.font.nuregular)),
                    modifier = Modifier.padding(
                        top = 5.dp
                    ),
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }

        }









        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painterResource(id = R.drawable.paperplane),
                contentDescription =  "Paper plane",
                tint = Color(0xFFD9614C),
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 30.dp),
            )

            Button(
                onClick = {
                    navHostController.navigate(Screen.SignUp.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(74.dp)
                    .padding(horizontal = 10.dp),
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD9614C)),

                ) {

                Text(
                    text = "Get Started",
                    fontFamily =  FontFamily(Font(R.font.nubold)),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = MaterialTheme.typography.h5.fontSize
                )

            }


            Text(
                textAlign = TextAlign.Center,
                text = "Already have an account?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .clickable { navHostController.navigate(Screen.SignIn.route) },
                color = Color(0xFFD9614C),
                fontFamily = FontFamily(Font(R.font.nubold))
            )


        }


    }
}



@Preview(showBackground = true)
@Composable
fun GetStartedScreenPreview(){
    GetStartedScreen(navHostController = rememberNavController())
}