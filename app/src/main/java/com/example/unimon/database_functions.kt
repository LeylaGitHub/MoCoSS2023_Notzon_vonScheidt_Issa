package com.example.unimon

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FireDatabase () {
  private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("UnimonDatabase")

  fun setData(value: String): String {
    var result = ""
    val userId = database.push().key!!
    database.child(userId).setValue(value)
      .addOnCompleteListener{
        result = "true"
      }
      .addOnFailureListener {
        err -> result = err.message.toString()
      }
    return result
  }

  fun setData2(value: String): String {
    // Write a message to the database
    val database = Firebase.database
    val myRef = database.getReference("Unimon2Database")

    var result = ""
    myRef.setValue("Hello, World!")
      .addOnCompleteListener {
        result = "true"
      }
      .addOnFailureListener { err ->
        result = err.message.toString()
      }
    return result
  }

  }
