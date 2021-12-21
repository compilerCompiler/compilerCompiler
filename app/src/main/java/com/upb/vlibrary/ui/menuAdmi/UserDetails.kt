package com.upb.vlibrary.ui.menuAdmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.ui.viewmodels.DeleteElementsViewModel
import com.upb.vlibrary.UsuarioPersona
import com.upb.vlibrary.databinding.FragmentUserDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.properties.Delegates

class UserDetails : Fragment() {
    private lateinit var username: String
    private lateinit var password: String
    private var idUsuario by Delegates.notNull<Int>()
    private lateinit var persona: UsuarioPersona
    private val args: UserDetailsArgs by navArgs()
    private lateinit var binding: FragmentUserDetailsBinding
    private val deleteElementsViewModel: DeleteElementsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username = args.userName
        password = args.password
        idUsuario = args.idUsuario
        persona = args.userInfo
        binding.usuario = persona
        binding.buttonEliminarUsuario.setOnClickListener {
            deleteElementsViewModel.deletePersona(persona.Id_persona).onEach {
            }.catch {
                Toast.makeText(context, "No se pudo borrar la persona", Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
            deleteElementsViewModel.deleteUsuario(persona.Id_Usuario).onEach {
                val goToSuccessPage =
                    UserDetailsDirections.actionUserDetailsToSuccessDeleteUserFragment(
                        username,
                        password,
                        idUsuario
                    )
                findNavController().navigate(goToSuccessPage)
            }.catch {
                Toast.makeText(context, "No se pudo borrar el usuario", Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }


    }

}