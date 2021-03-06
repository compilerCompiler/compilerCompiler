package com.upb.vlibrary.ui.helpContact


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upb.vlibrary.databinding.FragmentSupportBinding


class SupportFragment : Fragment() {

    private lateinit var binding: FragmentSupportBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSupportBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btContacto.setOnClickListener {
            val goToContactPage= SupportFragmentDirections.actionSupportFragmentToContactFragment()
            findNavController().navigate(goToContactPage)
        }
        binding.btSoporte.setOnClickListener {
            val goToHelpPage= SupportFragmentDirections.actionSupportFragmentToHelpFragment()
            findNavController().navigate(goToHelpPage)
        }
    }
}