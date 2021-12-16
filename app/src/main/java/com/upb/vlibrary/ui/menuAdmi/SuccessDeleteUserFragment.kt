package com.upb.vlibrary.ui.menuAdmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.UsuarioPersona
import com.upb.vlibrary.databinding.FragmentSuccessDeleteUserBinding
import com.upb.vlibrary.ui.reservation.ReservationSuccessFragmentDirections
import kotlin.properties.Delegates

class SuccessDeleteUserFragment: Fragment() {
    private lateinit var username:String
    private lateinit var password:String
    private var idUsuario by Delegates.notNull<Int>()
    private val args: SuccessDeleteUserFragmentArgs by navArgs()
    private lateinit var  binding: FragmentSuccessDeleteUserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSuccessDeleteUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.userName
        password=args.password
        idUsuario=args.idUsuario
        binding.imgConfirmarEliminacionUser.setOnClickListener {
          val goToMainMenu = SuccessDeleteUserFragmentDirections.actionSuccessDeleteUserFragmentToMenuAdminFragment(username,password,idUsuario)
            findNavController().navigate(goToMainMenu)
        }
    }
}