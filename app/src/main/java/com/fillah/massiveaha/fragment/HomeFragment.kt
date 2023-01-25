package com.fillah.massiveaha.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentHomeBinding
import com.fillah.massiveaha.one.*
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val functions = Functions()

    private val dompetTemplateFragment = DompetTemplateFragment()
    private val dompetTanpaTemplateFragment = DompetTanpaTemplateFragment()
    private val pemasukanTerkini = FragmentPemasukanTerkini()
    private val pengeluaranTerkini = FragmentPengeluaranTerkini()
    private val fragmentAdd = FragmentAdd()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //baca data dari db
        readUserData()

        //pasang fragment pengeluaran dan pemasukan terkini
        parentFragmentManager.beginTransaction()
            .add(binding.pengeluaranTerkini.id, pengeluaranTerkini)
            .add(binding.pemasukanTerkini.id, pemasukanTerkini)
            .commit()

        //set tanggal
        binding.tanggal.text = functions.currentDate

        binding.btnAdd.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragmentAdd)
                .addToBackStack("Home Fragment")
                .commit()
        }

        binding.btnTips.setOnClickListener {
            val intent = Intent(activity, TipsAct::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    private fun readUserData() {
        functions.userData.get()
            .addOnSuccessListener {
                val useTemplate = it.data?.get("template")

                //cek apakah user pake template
                if (useTemplate as Boolean){
                    //kalo pake template
                    parentFragmentManager.beginTransaction()
                        .add(binding.FrameDompet.id ,dompetTemplateFragment)
                        .commit()
                } else {
                    //kalo ga pake template mau apa
                    parentFragmentManager.beginTransaction()
                        .add(binding.FrameDompet.id ,dompetTanpaTemplateFragment)
                        .commit()
                }

                //set username
                val username = "Halo, ${it.data?.get("username").toString()}"
                binding.tvUsername.text = username

                checkUserTransaction()

            }
            .addOnFailureListener {
                Log.e("Firestore error!", it.message.toString())
            }
    }

    private fun checkUserTransaction(){
        functions.currentIncome
            .addSnapshotListener(object : com.google.firebase.firestore.EventListener<QuerySnapshot>{
                override fun onEvent(incomeValue: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    //cek apakah error
                    if (error != null){
                        Log.e("Firestore Error", error.message.toString())
                        return
                    }

                    val incomeSize = incomeValue!!.size()

                    functions.currentExpense
                        .addSnapshotListener(object : com.google.firebase.firestore.EventListener<QuerySnapshot>{
                            override fun onEvent(expenseValue: QuerySnapshot?, error: FirebaseFirestoreException?) {
                                //cek apakah error
                                if (error != null){
                                    Log.e("Firestore Error", error.message.toString())
                                    return
                                }

                                val expenseSize = expenseValue!!.size()

                                if ((incomeSize == 0) and (expenseSize == 0)){
                                    binding.noTransaction.visibility = View.VISIBLE
                                }
                            }

                        })
                }

            })
    }

    override fun onDestroyView() {
        parentFragmentManager.beginTransaction()
            .remove(dompetTemplateFragment)
            .remove(dompetTanpaTemplateFragment)
            .remove(pengeluaranTerkini)
            .remove(pemasukanTerkini)
            .commit()
        super.onDestroyView()
    }
}