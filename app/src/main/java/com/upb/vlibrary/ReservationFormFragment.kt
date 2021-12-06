package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.databinding.FragmentReservationDetailsBinding

class ReservationFormFragment: Fragment() {

    private lateinit var libro: Books
    private val args: ReservationFormFragmentArgs by navArgs()
    private lateinit var binding: FragmentReservationDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentReservationDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        libro=args.bookInfo
        binding.librosReserva=libro
        binding.imgConfirmarReservation.setOnClickListener {
            val goToSuccessPage= ReservationFormFragmentDirections.actionReservationFormFragmentToReservationSuccessFragment()
            findNavController().navigate(goToSuccessPage)
        }

    }
}