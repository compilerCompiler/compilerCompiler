package com.upb.vlibrary.ui.menuUser


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.databinding.FragmentMenuUserBinding
import kotlin.properties.Delegates

class MenuUserFragment : Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private var idUsuario by Delegates.notNull<Int>()
    private val args: MenuUserFragmentArgs by navArgs()
    private lateinit var binding: FragmentMenuUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuUserBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.userName
        password=args.password
        idUsuario=args.idUsuario
        binding.btBusqueda.setOnClickListener {
            val goToSearchPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToArticleSearchFragment(username,password,idUsuario)
            findNavController().navigate(goToSearchPage)
        }
        binding.btMultimedia.setOnClickListener {
            val goToMultimediaPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToMultimediaMainFragment()
            findNavController().navigate(goToMultimediaPage)
        }
        binding.btReserva.setOnClickListener {
            val goToReservationPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToReservationMainFragment(username,password,idUsuario)
            findNavController().navigate(goToReservationPage)
        }
        binding.btAyuda.setOnClickListener {
            val goToHelpPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToSupportFragment()
            findNavController().navigate(goToHelpPage)
        }
        binding.imgHouseNormal.setOnClickListener {
            val goToRegisterMain = MenuUserFragmentDirections.actionMenuUserFragmentToOptionsLoginfragment()
            findNavController().navigate(goToRegisterMain)
        }
    }
}