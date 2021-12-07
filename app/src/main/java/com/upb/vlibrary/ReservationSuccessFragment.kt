package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.databinding.FragmentReservationSuccessBinding

class ReservationSuccessFragment: Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private val args:ReservationSuccessFragmentArgs by navArgs()
    private lateinit var binding:FragmentReservationSuccessBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentReservationSuccessBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.userName
        password=args.password
        binding.imgConfirmarReservation.setOnClickListener {
            val goToMainMenu= ReservationSuccessFragmentDirections.actionReservationSuccessFragmentToMenuUserFragment(username,password)
            findNavController().navigate(goToMainMenu)
        }
    }
}