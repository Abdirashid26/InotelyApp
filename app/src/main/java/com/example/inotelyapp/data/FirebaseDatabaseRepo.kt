package com.example.inotelyapp.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import javax.inject.Inject


class FirebaseDatabaseRepo  {

    private val database = Firebase.database


    fun getNotes(liveData: MutableLiveData<List<Note>>,ref : String){
         val myRef = database.getReference(ref)
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                val value = snapshot.getValue<Map<String, Any>>()

                val notesList: List<Note> = snapshot.children.map { note ->
                     note.getValue(Note::class.java)!!
                 }

//                Log.i("VALUE", "Value is $value")
                liveData.postValue(notesList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("FIREBASE", "Failed to read value from the notes list ", error.toException())
            }

        })
    }



}