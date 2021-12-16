package com.upb.vlibrary.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upb.vlibrary.databinding.FragmentLoginOptionsBinding

class OptionsLoginfragment:Fragment() {

    private lateinit var binding: FragmentLoginOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginOptionsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonRegister.setOnClickListener{
            val goToLoginPage= OptionsLoginfragmentDirections.actionOptionsLoginfragmentToRegisterFragment()
            findNavController().navigate(goToLoginPage)
        }
        binding.buttonLogin.setOnClickListener{
            val goToRegisterPage= OptionsLoginfragmentDirections.actionOptionsLoginfragmentToLoginFragment2()
            findNavController().navigate(goToRegisterPage)
        }
        binding.buttonRegisterAdmin.setOnClickListener {
            val goToRegisterAdminPage= OptionsLoginfragmentDirections.actionOptionsLoginfragmentToRegisterAdminFragment()
            findNavController().navigate(goToRegisterAdminPage)
        }
    }
}