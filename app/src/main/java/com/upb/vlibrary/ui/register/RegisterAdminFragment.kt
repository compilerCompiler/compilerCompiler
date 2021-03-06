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
import com.upb.vlibrary.ui.menuAdmi.AdmiViewModel
import com.upb.vlibrary.ui.viewmodels.PersonaViewModel
import com.upb.vlibrary.databinding.FragmentRegisterAdminBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterAdminFragment: Fragment() {

    private lateinit var binding: FragmentRegisterAdminBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    private val personaViewModel: PersonaViewModel by viewModels()
    private val admiViewModel: AdmiViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterAdminBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var idUsuario: Int
        var idPersona: Int
        binding.imgAcceptButtonAdminRegister.setOnClickListener {
            val username=binding.edtxNameUserAdmin.text.toString()
            val password=binding.edtxPasswordAdmin.text.toString()
            val email=binding.edtxCorreoAdmin.text.toString()
            val nombre=binding.edtxNamePerson.text.toString()
            val profesion=binding.edtxProfession.text.toString()
            val codigoAdmin:Int=binding.edtxAdminCode.text.toString().toInt()
            val codigoVerificacion:Int=binding.edtxVerificationCodeAdmin.text.toString().toInt()

            if(codigoVerificacion == 4545){
                registerViewModel.register(username,email,password).onEach {
                    idUsuario = it.id
                    Log.d("Main","Id usuario: $idUsuario")
                    Toast.makeText(context,"Registro exitoso",Toast.LENGTH_SHORT).show()
                    val goToAdmiMenu=RegisterAdminFragmentDirections.actionRegisterAdminFragmentToMenuAdminFragment(username,password,idUsuario)
                    findNavController().navigate(goToAdmiMenu)
                    personaViewModel.createPersona(nombre,profesion,idUsuario).onEach {
                        idPersona = it.id
                        admiViewModel.createAdmi(idPersona,codigoAdmin).launchIn(CoroutineScope(Dispatchers.Main))
                    }.launchIn(CoroutineScope(Dispatchers.Main))

                }.catch {
                    Toast.makeText(context,"No se pudo registrar",Toast.LENGTH_SHORT).show()
                }.launchIn(CoroutineScope(Dispatchers.Main))
            }else{
                Toast.makeText(context,"El codigo de verificacion es incorrecto",Toast.LENGTH_SHORT).show()
            }

        }
    }
}