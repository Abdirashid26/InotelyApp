package com.example.inotelyapp.ui.theme.screens.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inotelyapp.R


@Composable
fun MainScreenTopAppBar(
    modifier: Modifier = Modifier
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

               Icon(
                   Icons.Filled.Person,
                   contentDescription = "Profile",
                   tint = Color.Black
               )


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
    MainScreenTopAppBar()
}