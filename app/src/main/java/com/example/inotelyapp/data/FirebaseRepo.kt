package com.example.inotelyapp.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class FirebaseRepo ()
{

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData()
    private val loggedOutLiveData: MutableLiveData<Boolean> = MutableLiveData()

    init{

        if(firebaseAuth.currentUser != null){
            userLiveData.postValue(firebaseAuth.currentUser)
            loggedOutLiveData.postValue(false)
        }

    }


    fun  loginWithEmailAndPassword(email : String, password : String){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                userLiveData.postValue(firebaseAuth.currentUser)
            } else{
                Log.w(TAG, "signInWithEmail:failure", task.exception)
            }
        }
    }


    fun createUserWithEmailAndPassword(email : String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
            if(task.isSuccessful){
                userLiveData.postValue(firebaseAuth.currentUser)
            } else{
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
            }
        }
    }


    fun logOutUser (){
        firebaseAuth.signOut()
        loggedOutLiveData.postValue(true)
    }


    fun getUserLiveData() : MutableLiveData<FirebaseUser> {
        return userLiveData
    }

    fun isLoggedOut() : MutableLiveData<Boolean> {
        return loggedOutLiveData
    }





}