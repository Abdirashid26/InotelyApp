package com.example.inotelyapp.ui.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.inotelyapp.data.FirebaseDatabaseRepo
import com.example.inotelyapp.data.FirebaseRepo
import com.example.inotelyapp.data.Note
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirebaseViewModel @Inject constructor(
    private val firebaseRepo: FirebaseRepo,
    private val firebaseDatabaseRepo: FirebaseDatabaseRepo
    ) : ViewModel() {

     var userLiveData: MutableLiveData<FirebaseUser>? = MutableLiveData()
     var loggedOutLiveData: MutableLiveData<Boolean>? = MutableLiveData()


    var user : LiveData<FirebaseUser>? = userLiveData
    var loggedOut : LiveData<Boolean>? = loggedOutLiveData

    init {

        userLiveData = firebaseRepo.getUserLiveData()
        loggedOutLiveData = firebaseRepo.isLoggedOut()


    }

    private val _notesList  = MutableLiveData<List<Note>>(emptyList())
    val notesList : LiveData<List<Note>> = _notesList


//    Uid holds the reference for each user
    fun getNotes(myUid : String){
        firebaseDatabaseRepo.getNotes(_notesList,myUid)
        Log.i("NOTESLIST", myUid)
    }

    fun loginWithEmailAndPassword(email : String, password : String){
        firebaseRepo.loginWithEmailAndPassword(email, password)
    }

    fun createUserWithEmailAndPassword(email: String,password: String){
        firebaseRepo.createUserWithEmailAndPassword(email, password)
    }

    fun logOutUser(){
        firebaseRepo.logOutUser()
    }




}