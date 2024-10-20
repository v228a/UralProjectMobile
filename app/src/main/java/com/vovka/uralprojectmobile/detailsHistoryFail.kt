package com.vovka.uralprojectmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class detailsHistoryFailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalis_history_fail, container, false)
        view.findViewById<ImageView>(R.id.imageViewBack).setOnClickListener {
            val navController = findNavController()
            navController.popBackStack()
        }
        //view.findViewById<>()
        return view
    }

}