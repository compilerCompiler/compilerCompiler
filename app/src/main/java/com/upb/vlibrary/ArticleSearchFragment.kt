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
import com.upb.vlibrary.databinding.FragmentArticlesSearchBinding

class ArticleSearchFragment:Fragment() {

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
        articleSearchViewModel.updateListBooks()

        binding.rvArticleSearch.adapter= articleSearchAdapter
        val layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rvArticleSearch.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvArticleSearch)

        articleSearchAdapter.setOnLibroClickListener {
            val directions= ArticleSearchFragmentDirections.actionArticleSearchFragmentToArticleSearchInfoFragment(it)
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