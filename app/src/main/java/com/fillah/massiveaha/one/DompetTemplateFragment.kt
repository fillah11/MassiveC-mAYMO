package com.fillah.massiveaha.one

import android.app.ProgressDialog
import android.os.Bundle
import android.provider.CalendarContract.Instances
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentDompetTemplateBinding

class DompetTemplateFragment : Fragment() {

    private var _binding : FragmentDompetTemplateBinding? = null
    private val binding get() = _binding!!
    private var functions = Functions()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        //inflate the layout
        _binding = FragmentDompetTemplateBinding.inflate(inflater, container, false)

        readUserData()

        return binding.root
    }

    private fun readUserData(){

        //get user data
        functions.userData.get()
            .addOnSuccessListener {
                //set nilai aset(sisa saldo) dan pendapatan
                val aset = functions.formatRupiah(it.data?.get("aset").toString().toDouble())
                val pendapatan = "dari ${functions.formatRupiah(it.data?.get("pendapatan").toString().toDouble())}"
                val asetPokok = functions.formatRupiah(it.data?.get("aset_pokok").toString().toDouble())
                val asetFleksibel = functions.formatRupiah(it.data?.get("aset_fleksibel").toString().toDouble())
                val asetInvestasi = functions.formatRupiah(it.data?.get("aset_investasi").toString().toDouble())
                val pokok = functions.formatRupiah(it.data?.get("pokok").toString().toDouble())
                val fleksibel = functions.formatRupiah(it.data?.get("fleksibel").toString().toDouble())
                val investasi = functions.formatRupiah(it.data?.get("investasi").toString().toDouble())

                val ketPokok = "$asetPokok dari $pokok"
                val ketFleksibel = "$asetFleksibel dari $fleksibel"
                val ketInvestasi = "$asetInvestasi dari $investasi"

                binding.tvAset.text = aset
                binding.tvPendapatan.text = pendapatan
                binding.tvKetdanapokok.text = ketPokok
                binding.tvKetdanafleksibel.text = ketFleksibel
                binding.tvKetdanainvestasi.text = ketInvestasi
            }
            .addOnFailureListener {
                println("failed to retrieve data. $it")
            }
    }


    }
