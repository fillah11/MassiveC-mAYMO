package com.fillah.massiveaha

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.NumberFormat
import java.util.*

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

    fun updatePendapatan(pendapatan: Int){
        userData
            .update("pendapatan", pendapatan)
            .addOnSuccessListener {
                println("successfully update. $it")
            }
            .addOnFailureListener {
                println("update failed. $it")
            }
    }

    fun updateAset(aset: Int){
        userData
            .update("aset", aset)
            .addOnSuccessListener {
                println("successfully update. $it")
            }
            .addOnFailureListener {
                println("update failed. $it")
            }
    }

    fun formatRupiah(number : Double): String {
        val localeId = Locale("IND", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeId)
        val format = numberFormat.format(number)
        val split = format.split(",")
        val length = split[0].length
        return split[0].substring(0,2)+""+split[0].substring(2,length)
    }

}