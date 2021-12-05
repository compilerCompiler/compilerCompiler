package com.upb.vlibrary


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upb.vlibrary.databinding.FragmentMenuUserBinding

class MenuUserFragment : Fragment() {

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
        binding.btBusqueda.setOnClickListener {
            val goToSearchPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToArticleSearchFragment()
            findNavController().navigate(goToSearchPage)
        }
        binding.btMultimedia.setOnClickListener {
            val goToMultimediaPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToMultimediaMainFragment()
            findNavController().navigate(goToMultimediaPage)
        }
        binding.btReserva.setOnClickListener {
            val goToReservationPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToReservationMainFragment()
            findNavController().navigate(goToReservationPage)
        }
        binding.btAyuda.setOnClickListener {
            val goToHelpPage =
                MenuUserFragmentDirections.actionMenuUserFragmentToSupportFragment()
            findNavController().navigate(goToHelpPage)
        }
    }
}