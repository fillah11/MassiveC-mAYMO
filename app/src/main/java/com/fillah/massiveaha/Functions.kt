package com.fillah.massiveaha

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Functions {

    private val firestore = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()
    private val currentUser = auth.currentUser
    val userData = firestore.collection("users").document(currentUser?.email.toString())

    fun isLoggedIn(): Boolean {
        return currentUser != null
    }

    fun finishedIntro(){
        userData
            .update("intro", false)
            .addOnSuccessListener {
                println("user has finished introduction. $it")
            }
            .addOnFailureListener {
                println("user has not finished intro. $it")
            }
    }

    fun useTemplate(){
        userData
            .update("template", true)
            .addOnSuccessListener {
                println("user has finished introduction. $it")
            }
            .addOnFailureListener {
                println("user has not finished intro. $it")
            }
    }

}