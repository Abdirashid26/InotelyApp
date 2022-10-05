package com.example.inotelyapp.ui.theme.screens.mainScreen

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddNoteButton(
    modifier: Modifier = Modifier
){

    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.White
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add Todo" )

    }

}




@Preview(showBackground = true)
@Composable
fun AddNoteButtonPreview(){

}