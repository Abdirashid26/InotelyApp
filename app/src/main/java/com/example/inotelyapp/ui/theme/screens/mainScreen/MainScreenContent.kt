package com.example.inotelyapp.ui.theme.screens.mainScreen

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.inotelyapp.R
import com.example.inotelyapp.ui.theme.Shapes
import com.example.inotelyapp.ui.theme.screens.navigation.Screen
import com.example.inotelyapp.ui.vm.FirebaseViewModel


@Composable
fun MainScreenContent(
    firebaseViewModel: FirebaseViewModel = hiltViewModel()
){
//    DisplayNoNotes()
    DisplayNotes()
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayNotes(
    firebaseViewModel: FirebaseViewModel = hiltViewModel()
){

    val user  = firebaseViewModel.userLiveData?.observeAsState()

    val notesLists = firebaseViewModel.notesList.observeAsState()

//    this launched effect will only be called once, due to result set true
//    get the required data
    LaunchedEffect(key1 = true){
        firebaseViewModel.getNotes(user?.value?.uid.toString())
        Log.i("NotesList",notesLists.value.toString())
    }


    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8EEE2))
            .padding(5.dp),
        columns = StaggeredGridCells.Fixed(2)
    ){
        items(
            count = notesLists.value?.toList()?.size!!
        ){
            notesLists.value?.toList()?.forEach {
                    note ->
                NoteCard(
                    title = note.title,
                    descripiton = note.description
                )
            }
        }

    }


    StaggeredVerticalGrid(maxColumnWidth = 200.dp, modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF8EEE2))) {
        notesLists.value?.toList()?.forEach {
                note ->
            NoteCard(
                title = note.title,
                descripiton = note.description
            )
        }
    }


//    LazyVerticalGrid(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFF8EEE2))
//            .padding(5.dp),
//        columns = GridCells.Fixed(2)
//    ){
//        items(
//            items = notesLists.value?.toList()!!,
//            key = {
//                note ->
//                note.title
//            }
//        ){ note ->
//            NoteCard(
//                title = note.title,
//                descripiton = note.description
//            )
//        }
//    }



}


@Composable
fun DisplayNoNotes(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8EEE2))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    )
            {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painterResource(id = R.drawable.onmainimage),
                contentDescription = "No Notes Image",
                Modifier.size(400.dp)
            )

            Text(
                text = "Create Your First Note",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nubold)),
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    textAlign =TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text ="Add a note about anything (your thoughts on climate change, or your history essay) and share it with the world.",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.numedium)),
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    textAlign = TextAlign.Center
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, false)
        ) {
            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(74.dp)
                    .padding(horizontal = 10.dp),
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD9614C)),

                ) {

                Text(
                    text = "Create A Note",
                    fontFamily =  FontFamily(Font(R.font.nubold)),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = MaterialTheme.typography.h5.fontSize
                )

            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun MainScreenContentPreview(){
    MainScreenContent()
}
