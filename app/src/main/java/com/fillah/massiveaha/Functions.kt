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

    fun updateTemplate(pendapatan: Int){
        val pokok = pendapatan /2
        val fleksibel = pendapatan * 3/10
        val investasi = pendapatan /5

        userData
            .update(mapOf(
                "pendapatan" to pendapatan,
                "aset" to pendapatan,
                "pokok" to pokok,
                "fleksibel" to fleksibel,
                "investasi" to investasi,
                "aset_pokok" to pokok,
                "aset_fleksibel" to fleksibel,
                "aset_investasi" to investasi
            ))
            .addOnSuccessListener {
                println("Successfully updated. $it")
            }
            .addOnFailureListener {
                println("Update failed. $it")
            }
    }

    fun updateTanpaTemplate(pendapatan: Int){

        userData
            .update(mapOf(
                "pendapatan" to pendapatan,
                "aset" to pendapatan,
                "pokok" to 0,
                "fleksibel" to 0,
                "investasi" to 0,
                "aset_pokok" to 0,
                "aset_fleksibel" to 0,
                "aset_investasi" to 0
            ))
            .addOnSuccessListener {
                println("Successfully updated. $it")
            }
            .addOnFailureListener {
                println("Update failed. $it")
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

    fun logout(){
        auth.signOut()
    }

}