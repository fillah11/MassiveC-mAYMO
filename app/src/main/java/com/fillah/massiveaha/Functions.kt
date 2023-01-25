package com.fillah.massiveaha

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class Functions {

    private val firestore = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()
    private val currentUser = auth.currentUser
    val userData = firestore.collection("users").document(currentUser?.email.toString())
    private val formatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id","ID"))
    val currentDate: String = formatter.format(Date())
    val userCurrentTransaction = userData.collection("transaksi").document(currentDate)
    val currentExpense = userCurrentTransaction.collection("pengeluaran")
    val currentIncome = userCurrentTransaction.collection("pemasukan")

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

    fun updateAddIncome(nominal: Int){
        userData.get()
            .addOnSuccessListener {
                val template = it.data?.get("template").toString().toBoolean()
                var aset: Int = it.data?.get("aset").toString().toInt()
                var pendapatan: Int = it.data?.get("pendapatan").toString().toInt()
                var asetFleksibel: Int = it.data?.get("aset_fleksibel").toString().toInt()
                var asetPokok: Int = it.data?.get("aset_pokok").toString().toInt()
                var asetInvestasi: Int = it.data?.get("aset_investasi").toString().toInt()

                if(template){
                    aset+= nominal
                    val updatedPendapatan = pendapatan + nominal
                    val pokok = updatedPendapatan /2
                    val fleksibel = updatedPendapatan * 3/10
                    val investasi = updatedPendapatan /5

                    val updatedAsetPokok = asetPokok + (nominal /2)
                    val updatedAsetFleksibel = asetFleksibel + (nominal * 3/10)
                    val updatedAsetInvestasi = asetInvestasi + (nominal /5)

                    userData.update(mapOf(
                        "aset" to aset,
                        "pendapatan" to updatedPendapatan,
                        "pokok" to pokok,
                        "fleksibel" to fleksibel,
                        "investasi" to investasi,
                        "aset_pokok" to updatedAsetPokok,
                        "aset_fleksibel" to updatedAsetFleksibel,
                        "aset_investasi" to updatedAsetInvestasi
                    ))
                }else{
                    aset+= nominal
                    userData.update("aset", aset)
                }
            }
            .addOnFailureListener {
                Log.e("Failed to get data", it.message.toString())
            }
    }

    fun updateAddExpense(jenis: String, nominal:Int){
        userData.get()
            .addOnSuccessListener {
                val template = it.data?.get("template").toString().toBoolean()
                var aset: Int = it.data?.get("aset").toString().toInt()
                var asetFleksibel: Int = it.data?.get("aset_fleksibel").toString().toInt()
                var asetPokok: Int = it.data?.get("aset_pokok").toString().toInt()
                println("before, aset = $aset, fleksibel= $asetFleksibel, pokok=$asetPokok")

                if(template){
                    if (jenis == "aset_pokok"){
                        aset -= nominal
                        asetPokok -= nominal
                        userData.update(mapOf(
                            "aset" to aset,
                            "aset_pokok" to asetPokok
                        ))
                    } else{
                        aset -= nominal
                        asetFleksibel -= nominal
                        userData.update(mapOf(
                            "aset" to aset,
                            "aset_fleksibel" to asetFleksibel
                        ))
                    }
                }else{
                    aset -= nominal
                    userData.update("aset", aset)
                }


                println("after, aset = $aset, fleksibel= $asetFleksibel, pokok=$asetPokok")
            }
            .addOnFailureListener {
                Log.e("Failed to get data", it.message.toString())
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