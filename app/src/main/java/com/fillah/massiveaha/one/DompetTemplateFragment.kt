package com.fillah.massiveaha.one

import android.os.Bundle
import android.provider.CalendarContract.Instances
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import com.fillah.massiveaha.R

class DompetTemplateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        return inflater.inflate(R.layout.fragment_dompet_template, container, false)
    }


    }
