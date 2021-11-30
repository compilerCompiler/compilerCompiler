package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upb.vlibrary.databinding.FragmentRegisterBinding

class RegisterFragment:Fragment() {


    private lateinit var binding:FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonNext.setOnClickListener {
            val goToMainAdmiMenu= RegisterFragmentDirections.actionRegisterFragmentToMenuAdminFragment()
            findNavController().navigate(goToMainAdmiMenu)
        }
    }
}