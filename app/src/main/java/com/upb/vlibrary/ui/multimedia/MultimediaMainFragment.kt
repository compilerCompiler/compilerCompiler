package com.upb.vlibrary.ui.multimedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.vlibrary.ListOfVideosAdapter
import com.upb.vlibrary.ui.viewmodels.ListOfVideosViewModel
import com.upb.vlibrary.databinding.FragmentMultimediaMainBinding

class MultimediaMainFragment: Fragment() {

    private val listOfVideosAdapter = ListOfVideosAdapter()
    private val listOfVideosViewModel: ListOfVideosViewModel by viewModels()
    private lateinit var binding: FragmentMultimediaMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMultimediaMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listOfVideosViewModel.updateVideos()
        binding.rvMultimediaMain.adapter=listOfVideosAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvMultimediaMain.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvMultimediaMain)
        listOfVideosViewModel.videos.observe(viewLifecycleOwner){
            listOfVideosAdapter.addAll(it)
        }

        listOfVideosAdapter.setOnVideoClickListener {
            Toast.makeText(context,"Se toco el video con id : ${it.Id_video}", Toast.LENGTH_SHORT).show()
            val goToVideoPage = MultimediaMainFragmentDirections.actionMultimediaMainFragmentToMultimediaPageFragment(it)
            findNavController().navigate(goToVideoPage)
        }
    }
}