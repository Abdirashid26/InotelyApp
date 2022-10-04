package com.example.inotelyapp.ui.theme.screens.editnotescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditNoteMain(
 modifier: Modifier = Modifier
) {

 Column(
  modifier = modifier
      .fillMaxSize()
      .background(Color(0xFFF8EEE2))

 ) {

  Scaffold(
      topBar = {
          EditNoteTopAppBar()
      },
      content = {
//                show the pressed note
      },

  )



 }


}



@Preview(showBackground = true)
@Composable
fun EditNotesPreview(){
  EditNoteMain()
}