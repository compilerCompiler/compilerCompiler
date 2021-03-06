package com.upb.vlibrary.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upb.vlibrary.ui.menuAdmi.AdmiViewModel
import com.upb.vlibrary.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class LoginFragment:Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private val adminViewModel: AdmiViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var idUsuario: Int
        binding.buttonNext.setOnClickListener{
            val username=binding.userNameLogin.text.toString()
            val password=binding.userPasswordLogIn.text.toString()
            loginViewModel.login(username,password).onEach {
                idUsuario = it.Id_usuario
                Log.d("Main","Id usuario: $idUsuario")
                Toast.makeText(context,"Credenciales correctas", Toast.LENGTH_SHORT).show()
                adminViewModel.getAdmi(it.Id_usuario).onEach {
                    val goToAdmiMenu= LoginFragmentDirections.actionLoginFragmentToMenuAdminFragment(username,password,idUsuario)
                    findNavController().navigate(goToAdmiMenu)
                }.catch {
                    val goToMainMenu = LoginFragmentDirections.actionLoginFragmentToMenuUserFragment(username,password,idUsuario)
                    findNavController().navigate(goToMainMenu)
                }.launchIn(CoroutineScope(Dispatchers.Main))
            }.catch {
                Toast.makeText(context,"Usuario o password incorrecto", Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }
        }
    }
