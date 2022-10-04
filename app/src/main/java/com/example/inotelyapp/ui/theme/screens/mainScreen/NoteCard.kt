package com.example.inotelyapp.ui.theme.screens.mainScreen

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inotelyapp.R
import com.example.inotelyapp.ui.theme.Shapes


@Composable
fun NoteCard(
    title: String,
    descripiton : String
){
    Surface(
        shape = Shapes.small,
        elevation = 10.dp,
        modifier = Modifier.padding(5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp).background(Color.White),
                text = title,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nubold)),
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.ExtraBold
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                text = descripiton,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nuregular)),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )


        }
    }

}




@Preview(showBackground = true)
@Composable
fun NoteCardPreview(){
    NoteCard(title = "Title Is Here", descripiton = "Description Is Here")
}