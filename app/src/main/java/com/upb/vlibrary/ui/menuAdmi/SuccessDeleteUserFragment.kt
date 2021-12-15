package com.upb.vlibrary.ui.menuAdmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upb.vlibrary.databinding.FragmentSuccessDeleteUserBinding

class SuccessDeleteUserFragment: Fragment() {

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

    }
}