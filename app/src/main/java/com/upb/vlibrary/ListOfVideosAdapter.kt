package com.upb.vlibrary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upb.vlibrary.databinding.MultimediaItemBinding

class ListOfVideosAdapter: RecyclerView.Adapter<ListOfVideosViewHolder>() {

    private val videosList: MutableList<Video> = mutableListOf()
    private var onVideoItemClickListener:((videos:Video)-> Unit)? =null

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(newElementList: List<Video>) {
        videosList.clear()
        videosList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfVideosViewHolder {
        val binding = MultimediaItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListOfVideosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListOfVideosViewHolder, position: Int) {
        holder.bind(videosList[position])
        holder.binding.root.setOnClickListener{
            onVideoItemClickListener?.invoke(videosList[position])
        }
    }

    override fun getItemCount(): Int {
        return videosList.size
    }

    fun setOnVideoClickListener(onVideoItemClickListener:((videos:Video)-> Unit)?){
        this.onVideoItemClickListener=onVideoItemClickListener
    }
}

class ListOfVideosViewHolder(val binding: MultimediaItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(videos: Video){
        binding.videoDes=videos

    }
}