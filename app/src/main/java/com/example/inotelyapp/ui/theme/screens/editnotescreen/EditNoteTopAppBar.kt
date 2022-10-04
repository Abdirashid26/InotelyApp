package com.example.inotelyapp.ui.theme.screens.editnotescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.inotelyapp.R


@Composable
fun EditNoteTopAppBar(
    modifier: Modifier = Modifier
){
    TopAppBar(
        backgroundColor = Color(0xFFF8EEE2),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ){

            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Back To Notes Main Screen",
                modifier = Modifier.weight(1f),
                tint = Color.Black
            )


            Text(
                text =  "Edit Note",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontFamily = FontFamily(Font(R.font.nubold)),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.weight(7f)

            )



        }

    }
}





@Preview(showBackground = true)
@Composable
fun EditNoteTopAppBarPreview(){
    EditNoteTopAppBar()
}