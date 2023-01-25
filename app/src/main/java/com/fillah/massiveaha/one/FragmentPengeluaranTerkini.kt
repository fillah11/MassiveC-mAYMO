package com.fillah.massiveaha.one

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentPengeluaranTerkiniBinding
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

class FragmentPengeluaranTerkini : Fragment() {

    private var _binding : FragmentPengeluaranTerkiniBinding? = null
    private val binding get() = _binding!!

    private val functions = Functions()

    private lateinit var pengeluaranAdapter: PengeluaranTerkiniAdapter
    private lateinit var userData : ArrayList<TransactionClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPengeluaranTerkiniBinding.inflate(inflater, container, false)

        userData = arrayListOf()

        readData()

        return binding.root
    }

    private fun readData(){
        functions.currentExpense
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {

                    //cek apakah ada pengeluaran
                    if (!(value!!.isEmpty)){
                        binding.root.visibility = View.VISIBLE
                    } else{
                        return
                    }

                    //cek apakah error
                    if (error != null){
                        Log.e("Firestore Error", error.message.toString())
                        return
                    }

                    //add data ke array list
                    for (dc : DocumentChange in value.documentChanges){
                        if (dc.type == DocumentChange.Type.ADDED){
                            userData.add(dc.document.toObject(TransactionClass::class.java))
                        }
                    }
                    println("data pengeluaran: $userData")

                    //pasang adapter, set recycler view
                    pengeluaranAdapter = PengeluaranTerkiniAdapter(userData)

                    binding.rvPengeluaran.apply {
                        this.adapter = pengeluaranAdapter
                        this.layoutManager = LinearLayoutManager(context)
                    }
                }
            })
    }

}