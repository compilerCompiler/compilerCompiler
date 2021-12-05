package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upb.vlibrary.databinding.FragmentRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterFragment:Fragment() {


    private lateinit var binding:FragmentRegisterBinding
    private val registerViewModel:RegisterViewModel by viewModels()

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
            val username=binding.userName.text.toString()
            val email=binding.userEmail.text.toString()
            val password=binding.userPassword.text.toString()
            registerViewModel.register(username,email,password).onEach{
                val goToMainAdmiMenu= RegisterFragmentDirections.actionRegisterFragmentToMenuAdminFragment()
                findNavController().navigate(goToMainAdmiMenu)
            }.catch {
                Toast.makeText(context,"No se pudo registrar el usuario",Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))

        }
    }
}