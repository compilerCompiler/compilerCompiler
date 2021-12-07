package com.upb.vlibrary.ui.menuAdmi


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.databinding.FragmentMenuAdminBinding


class MenuAdminFragment : Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private val args: MenuAdminFragmentArgs by navArgs()
    private lateinit var binding:FragmentMenuAdminBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuAdminBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.userName
        password=args.password
            binding.btReserva.setOnClickListener {
                val goToReservationPage= MenuAdminFragmentDirections.actionMenuAdminFragmentToReservationMainFragment(username,password)
                findNavController().navigate(goToReservationPage)
            }
            binding.btAyuda.setOnClickListener {
                val goToHelpPage=MenuAdminFragmentDirections.actionMenuAdminFragmentToSupportFragment()
                findNavController().navigate(goToHelpPage)
            }
            binding.btBusqueda.setOnClickListener {
                val goToSearchPage=MenuAdminFragmentDirections.actionMenuAdminFragmentToArticleSearchFragment(username,password)
                findNavController().navigate(goToSearchPage)
            }
            binding.btMultimedia.setOnClickListener {
                val goToMultimedia =MenuAdminFragmentDirections.actionMenuAdminFragmentToMultimediaMainFragment()
                findNavController().navigate(goToMultimedia)
            }
            binding.btAdmin.setOnClickListener {
                val goToUsersPage=MenuAdminFragmentDirections.actionMenuAdminFragmentToAdminFragment()
                findNavController().navigate(goToUsersPage)
            }

    }
}