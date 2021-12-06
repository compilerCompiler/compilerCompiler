package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.vlibrary.databinding.FragmentReservationMainBinding

class ReservationMainFragment: Fragment() {

    private val articleToReserveAdapter = SearchArticlesToReserveAdapter()
    private lateinit var binding: FragmentReservationMainBinding
    private val articleSearchViewModel: ArticleSearchViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentReservationMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        articleSearchViewModel.updateListBooks()
        binding.rvReservationList.adapter=articleToReserveAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvReservationList.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvReservationList)

        articleToReserveAdapter.setOnLibroClickListener {
            val goToReservationForm= ReservationMainFragmentDirections.actionReservationMainFragmentToReservationFormFragment(it)
            findNavController().navigate(goToReservationForm)
        }

        articleSearchViewModel.libros.observe(viewLifecycleOwner){
            articleToReserveAdapter.addAll(it)
        }

        binding.iconSearch2.setOnClickListener {
            articleSearchViewModel.updateSelectedBooks(binding.txTextoBusquedaReserva.text.toString())
            articleSearchViewModel.libros.observe(viewLifecycleOwner){
                articleToReserveAdapter.addAll(it)
            }

        }
    }
}