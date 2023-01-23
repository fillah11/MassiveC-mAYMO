package com.fillah.massiveaha.one

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentEditKategoriBinding
import kotlinx.android.synthetic.main.list_kategori_pengeluaran.*

class EditKategoriFragment : Fragment(), IconClickListener {

    private lateinit var _binding: FragmentEditKategoriBinding
    private val binding get() = _binding

    private val iconMakan = listOf(
        R.drawable.makan,
        R.drawable.makan_v2,
        R.drawable.makan_v3,
        R.drawable.makan_v4,
        R.drawable.makan_v5,
        R.drawable.makan_v6,
        R.drawable.makan_v7,
        R.drawable.makan_v8
    )

    private val iconJajan = listOf(
        R.drawable.jajan,
        R.drawable.jajan_v2,
        R.drawable.jajan_v3,
        R.drawable.jajan_v4
    )

    private val iconBelanja = listOf(
        R.drawable.belanja_v1,
        R.drawable.belanja_v2,
        R.drawable.belanja_v3,
        R.drawable.belanja_v4,
        R.drawable.belanja,
        R.drawable.belanja_v6,
        R.drawable.belanja_v7,
        R.drawable.belanja_v8
    )

    private val iconHadiah = listOf(
        R.drawable.hadiah,
        R.drawable.hadiah_v2,
        R.drawable.hadiah_v3,
        R.drawable.hadiah_v4
    )

    private val iconPeliharaan = listOf(
        R.drawable.peliharaan,
        R.drawable.peliharaan_v2,
        R.drawable.peliharaan_v3,
        R.drawable.peliharaan_v4
    )

    private val iconLaundri = listOf(
        R.drawable.laundri,
        R.drawable.laundri_v2,
        R.drawable.laundri_v3,
        R.drawable.laundri_v4
    )

    private val iconUtang = listOf(
        R.drawable.utang,
        R.drawable.utang_v2,
        R.drawable.utang_v3,
        R.drawable.utang_v4
    )

    private val iconTeknologi = listOf(
        R.drawable.teknologi,
        R.drawable.teknologi_v2,
        R.drawable.teknologi_v3,
        R.drawable.teknologi_v4
    )

    private val iconPajak = listOf(
        R.drawable.pajak,
        R.drawable.pajak_v2,
        R.drawable.pajak_v3,
        R.drawable.pajak_v4
    )

    private val iconSosial = listOf(
        R.drawable.sosial,
        R.drawable.sosial_v2,
        R.drawable.sosial_v3,
        R.drawable.sosial_v4
    )

    private val iconRumah = listOf(
        R.drawable.rumah,
        R.drawable.rumah_v2,
        R.drawable.rumah_v3,
        R.drawable.rumah_v4
    )

    private val iconLiburan = listOf(
        R.drawable.liburan,
        R.drawable.liburan_v2,
        R.drawable.liburan_v3,
        R.drawable.liburan_v4
    )

    private val iconKecantikan = listOf(
        R.drawable.kecantikan,
        R.drawable.kecantikan_v2,
        R.drawable.kecantikan_v3,
        R.drawable.kecantikan_v4
    )

    private val iconMedis = listOf(
        R.drawable.medis,
        R.drawable.medis_v2,
        R.drawable.medis_v3,
        R.drawable.medis_v4
    )

    private val iconListrik = listOf(
        R.drawable.listrik,
        R.drawable.listrik_v2,
        R.drawable.listrik_v3,
        R.drawable.listrik_v4
    )

    private val iconTransportasi = listOf(
        R.drawable.transportasi,
        R.drawable.transportasi_v2,
        R.drawable.transportasi_v3,
        R.drawable.transportasi_v4
    )

    private val iconLaluLintas = listOf(
        R.drawable.lalulintas,
//        R.drawable.lalulintas_v2,
//        R.drawable.lalulintas_v3,
//        R.drawable.lalulintas_v4
    )

    private val iconPendidikan = listOf(
        R.drawable.pendidikan,
        R.drawable.pendidikan_v2,
        R.drawable.pendidikan_v3,
        R.drawable.pendidikan_v4
    )

    private val icons = mapOf(
        "Makan" to iconMakan,
        "Jajan" to iconJajan,
        "Belanja" to iconBelanja,
        "Hadiah" to iconHadiah,
        "Peliharaan" to iconPeliharaan,
        "Laundri" to iconLaundri,
        "Utang" to iconUtang,
        "Teknologi" to iconTeknologi,
        "Pajak" to iconPajak,
        "Sosial" to iconSosial,
        "Rumah" to iconRumah,
        "Liburan" to iconLiburan,
        "Kecantikan" to iconKecantikan,
        "Medis" to iconMedis,
        "Listrik" to iconListrik,
        "Transportasi" to iconTransportasi,
        "Lalu Lintas" to iconLaluLintas,
        "Pendidikan" to iconPendidikan,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEditKategoriBinding.inflate(inflater, container, false)

        val args = this.arguments
        val category = args?.get("kategori")
        val icon = args?.get("icon")

        binding.imgIcon.setImageResource(icon as Int)
        binding.tvCategory.text = category as String

        val adapter = icons[category]?.let { IconAdapter(it) }
        adapter?.iconClickListener = this

        binding.rvIcon.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(this.context, 4, )
        }

        return binding.root
    }

    override fun onItemClicked(img: Int, view: View) {
        view.alpha = 0.4f
    }

}