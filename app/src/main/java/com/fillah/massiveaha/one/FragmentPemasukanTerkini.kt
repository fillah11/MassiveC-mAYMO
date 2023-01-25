package com.fillah.massiveaha.one

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.databinding.FragmentPemasukanTerkiniBinding
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

class FragmentPemasukanTerkini : Fragment() {

    private var _binding : FragmentPemasukanTerkiniBinding? = null
    private val binding get()= _binding!!

    private val functions = Functions()

    private lateinit var pemasukanAdapter: PemasukanTerkiniAdapter
    private lateinit var userData : ArrayList<TransactionClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPemasukanTerkiniBinding.inflate(inflater, container, false)

        userData = arrayListOf()

        readData()

        return binding.root
    }

    private fun readData(){
        functions.currentIncome
            .addSnapshotListener(object : EventListener<QuerySnapshot>{
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {

                    //cek apakah ada pemasukan
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

                    //pasang adapter, set recycler view
                    pemasukanAdapter = PemasukanTerkiniAdapter(userData)

                    binding.rvPemasukan.apply {
                        this.adapter = pemasukanAdapter
                        this.layoutManager = LinearLayoutManager(context)
                    }
                }
            })
    }
}