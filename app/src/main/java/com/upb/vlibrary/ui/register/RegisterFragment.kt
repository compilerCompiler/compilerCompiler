package com.upb.vlibrary.ui.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upb.vlibrary.PersonaViewModel
import com.upb.vlibrary.databinding.FragmentRegisterBinding

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterFragment:Fragment() {


    public lateinit var binding:FragmentRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()

    private val existingUsers = listOf("Manuel", "Rodrigo")


    fun validateUsernameInput(
        username: String
    ): Boolean {
        if(username.isEmpty()) {
            return false
        }
        if(username in existingUsers) {
            return false
        }

        return true
    }



    fun validatePasswordInput(
        password: String
    ): Boolean {
        if(password.isEmpty()) {
            return false
        }
        if(password.count { it.isDigit() } < 2) {
            return false
        }
        return true
    }

    fun validateRegistrationInput(
        username: Boolean,
        password: Boolean
    ): Boolean {
        if(password || username) {
            return false
        }
        return true
    }


    private val personaViewModel: PersonaViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var idUsuario=0
        binding.buttonNext.setOnClickListener {
            val nombre= binding.edtxNamePersonNormal.text.toString()
            val profesion=binding.edtxProfessionNormal.text.toString()
            val username=binding.userName.text.toString()
            val email=binding.userEmail.text.toString()
            val password=binding.userPassword.text.toString()


        registerViewModel.register(username,email,password).onEach{
            idUsuario = it.id
            Toast.makeText(context,"Registro exitoso",Toast.LENGTH_SHORT).show()
            Log.d("Main","Id usuario: $idUsuario")
            val goToMainAdmiMenu= RegisterFragmentDirections.actionRegisterFragmentToMenuUserFragment(username,password,idUsuario)

                findNavController().navigate(goToMainAdmiMenu)
            personaViewModel.createPersona(nombre,profesion,idUsuario).launchIn(CoroutineScope(Dispatchers.Main))
            }.catch {
                Toast.makeText(context,"No se pudo registrar el usuario",Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))

        }
    }
}