package com.example.inotelyapp.ui.theme.screens.editnotescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import  com.example.inotelyapp.R


@Composable
fun EditNote(
    title : String,
    text : String
){

    var titleTest by remember {
        mutableStateOf("Title Note")
    }


    var textTest by remember {
        mutableStateOf("Note Description ")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8EEE2))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = titleTest ,
            onValueChange = {
            titleTest = it
        } ,
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.nubold)),
                fontSize = MaterialTheme.typography.h6.fontSize

            )
        )

        TextField(
            value = textTest ,
            onValueChange = { newText ->
                textTest = newText
            } ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.nuregular)),
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = false

        )


        Button(
            onClick = { /*TODO*/ },
            enabled = true,
            border = BorderStroke(1.dp,Color.White)
        ){
            Icon(
                Icons.Filled.Build,
                contentDescription =  "Build Project"
            )
            
            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = "Update Note",
                style = TextStyle(
                    fontFamily =  FontFamily(Font(R.font.nubold)),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                )
            )
        }

    }
}






@Preview(showBackground = true)
@Composable
fun EditNotePreview(){
    EditNote(title = "",text = "")
}