package com.upb.vlibrary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upb.vlibrary.databinding.ArticleItemBinding

class SearchArticlesAdapter:RecyclerView.Adapter<SearchArticlesListViewHolder>(){
    private val librosList: MutableList<Books> = mutableListOf()
    private var onLibroItemClickListener:((libros:Books)-> Unit)? =null


    @SuppressLint("NotifyDataSetChanged")
    fun addAll(newElementList: List<Books>){
        librosList.clear()
        librosList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchArticlesListViewHolder {
        val binding= ArticleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchArticlesListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchArticlesListViewHolder, position: Int) {
        holder.bind(librosList[position])
        holder.binding.root.setOnClickListener{
            onLibroItemClickListener?.invoke(librosList[position])
        }
    }

    override fun getItemCount(): Int {
        return librosList.size
    }

    fun setOnLibroClickListener(onLibroItemClickListener:((libros:Books)->Unit)?){
        this.onLibroItemClickListener=onLibroItemClickListener
    }
}

class SearchArticlesListViewHolder(val binding: ArticleItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(libros: Books){
        binding.libro= libros
    }
}