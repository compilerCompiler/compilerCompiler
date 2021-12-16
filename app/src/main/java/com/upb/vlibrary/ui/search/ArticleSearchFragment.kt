package com.upb.vlibrary.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.vlibrary.SearchArticlesAdapter
import com.upb.vlibrary.databinding.FragmentArticlesSearchBinding
import kotlin.properties.Delegates

class ArticleSearchFragment:Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private var idUsuario by Delegates.notNull<Int>()
    private val args:ArticleSearchFragmentArgs by navArgs()
    private val articleSearchAdapter = SearchArticlesAdapter()
    private lateinit var binding: FragmentArticlesSearchBinding
    private val articleSearchViewModel: ArticleSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentArticlesSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.username
        password=args.password
        idUsuario=args.idUser
        articleSearchViewModel.updateListBooks()

        binding.rvArticleSearch.adapter= articleSearchAdapter
        val layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rvArticleSearch.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvArticleSearch)

        articleSearchAdapter.setOnLibroClickListener {
            val directions= ArticleSearchFragmentDirections.actionArticleSearchFragmentToArticleSearchInfoFragment(it,username,password,idUsuario)
            findNavController().navigate(directions)
        }

        articleSearchViewModel.libros.observe(viewLifecycleOwner){
            articleSearchAdapter.addAll(it)
        }

        binding.iconSearch.setOnClickListener {
            articleSearchViewModel.updateSelectedBooks(binding.txTextoBusqueda.text.toString())
            articleSearchViewModel.libros.observe(viewLifecycleOwner){
                articleSearchAdapter.addAll(it)
            }
        }

    }
}