package com.example.inotelyapp.ui.theme.screens.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
fun SignInScreen(
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

        Text(
            text = "Sign In To Inotely",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontFamily = FontFamily(Font(R.font.nubold))
            ),
            modifier = Modifier.padding(top = 20.dp)
        )

        Text(
            text = "Welcome Back To Inotely, Happy To Have You !!",
            style = TextStyle(
                color = Color.Gray,
                fontWeight = FontWeight.ExtraBold,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontFamily = FontFamily(Font(R.font.nuregular))
            ),
            modifier = Modifier.padding(20.dp),
            textAlign = TextAlign.Center
        )


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
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

        var email by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = {
                Text(
                    text = "Email",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            ),
            leadingIcon = {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = "Email"
                )
            }
        )

        var password by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = {
                Text(
                    text = "Password",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            ),
            leadingIcon = {
                Icon(
                    Icons.Filled.Lock,
                    contentDescription = "Lock"
                )
            },
            visualTransformation = PasswordVisualTransformation(),

            )




        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            Button(
                onClick = {

                    if(email != "" && password != "") firebaseViewModel.loginWithEmailAndPassword(email, password)
                    if(firebaseViewModel.userLiveData?.value != null){
                        navHostController.navigate(Screen.Main.route)
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(74.dp)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD9614C)),

                ) {

                Text(
                    text = "Sign In",
                    fontFamily =  FontFamily(Font(R.font.nubold)),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = MaterialTheme.typography.h5.fontSize
                )

            }


            Button(
                onClick = {
                    navHostController.navigate(Screen.SignUp.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(74.dp)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF8EEE2)),

                ) {

                Text(
                    text = "Sign Up",
                    fontFamily =  FontFamily(Font(R.font.nubold)),
                    color = Color(0xFFD9614C),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = MaterialTheme.typography.h5.fontSize
                )

            }


        }


    }

}


@Preview(showBackground = true)
@Composable
fun SignInPreview(){
    SignInScreen(navHostController = rememberNavController())
}