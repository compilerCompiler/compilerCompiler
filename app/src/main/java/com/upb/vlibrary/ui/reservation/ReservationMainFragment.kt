package com.upb.vlibrary.ui.reservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.vlibrary.SearchArticlesToReserveAdapter
import com.upb.vlibrary.databinding.FragmentReservationMainBinding
import com.upb.vlibrary.ui.search.ArticleSearchViewModel
import kotlin.properties.Delegates

class ReservationMainFragment: Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private var idUsuario by Delegates.notNull<Int>()
    private val args:ReservationMainFragmentArgs by navArgs()
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
        username=args.userName
        password=args.password
        idUsuario=args.idUsuario
        articleSearchViewModel.updateListBooks()
        binding.rvReservationList.adapter=articleToReserveAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvReservationList.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvReservationList)

        articleToReserveAdapter.setOnLibroClickListener {
            if(it.Reservado==0){
                val goToReservationForm= ReservationMainFragmentDirections.actionReservationMainFragmentToReservationFormFragment(it,username,password,idUsuario)
                findNavController().navigate(goToReservationForm)
            }else{
                Toast.makeText(context,"No se puede reservar este libro",Toast.LENGTH_SHORT).show()
            }

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