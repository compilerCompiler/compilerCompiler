package com.upb.vlibrary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upb.vlibrary.databinding.ReservationItemBinding

class SearchArticlesToReserveAdapter:RecyclerView.Adapter<SearchArticlesToReserveListViewHolder>(){
    private val librosList: MutableList<Books> = mutableListOf()
    private var onLibroItemClickListener:((libros: Books)-> Unit)? =null

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(newElementList: List<Books>) {
        librosList.clear()
        librosList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchArticlesToReserveListViewHolder {
        val binding= ReservationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchArticlesToReserveListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchArticlesToReserveListViewHolder, position: Int) {
        holder.bind(librosList[position])
        holder.binding.root.setOnClickListener{
            onLibroItemClickListener?.invoke(librosList[position])
        }
    }

    override fun getItemCount(): Int {
        return librosList.size
    }

    fun setOnLibroClickListener(onLibroItemClickListener:((libros: Books)->Unit)?){
        this.onLibroItemClickListener=onLibroItemClickListener
    }

}

class SearchArticlesToReserveListViewHolder(val binding: ReservationItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(libros: Books){
        binding.libroToReserve=libros
    }
}

