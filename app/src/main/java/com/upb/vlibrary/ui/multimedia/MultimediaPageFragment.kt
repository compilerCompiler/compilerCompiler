package com.upb.vlibrary.ui.multimedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.Video
import com.upb.vlibrary.databinding.FragmentMultimediaPageBinding
import com.upb.vlibrary.databinding.FragmentReservationDetailsBinding

class MultimediaPageFragment: Fragment() {

    private lateinit var videoArgs: Video
    private val args: MultimediaPageFragmentArgs by navArgs()
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
        videoArgs=args.video
        binding.videoInfo=videoArgs
        lifecycle.addObserver(binding.viewVideoMult)
        binding.imgBackButtonMult.setOnClickListener {
            val goToMainPage= MultimediaPageFragmentDirections.actionMultimediaPageFragmentToMultimediaMainFragment()
            findNavController().navigate(goToMainPage)
        }
    }
}