package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upb.vlibrary.databinding.FragmentMultimediaPageBinding
import com.upb.vlibrary.databinding.FragmentReservationDetailsBinding

class MultimediaPageFragment: Fragment() {

    private lateinit var binding: FragmentMultimediaPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMultimediaPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}