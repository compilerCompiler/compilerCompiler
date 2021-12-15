package com.upb.vlibrary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upb.vlibrary.databinding.AdminInfoBinding

class ListOfUsersAdapter:RecyclerView.Adapter<ListOfUsersViewHolder>() {
    private val userList: MutableList<UsuarioPersona> = mutableListOf()
    private var onUserItemClickListener:((users:UsuarioPersona)->Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun addAll(newElementList: List<UsuarioPersona>) {
        userList.clear()
        userList.addAll(newElementList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfUsersViewHolder {
        val binding = AdminInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListOfUsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListOfUsersViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.binding.root.setOnClickListener{
            onUserItemClickListener?.invoke(userList[position])
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setOnUserClickListener(onUserItemClickListener:((users:UsuarioPersona)->Unit)?){
        this.onUserItemClickListener=onUserItemClickListener
    }

}

class ListOfUsersViewHolder(val binding: AdminInfoBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(users:UsuarioPersona){
        binding.userP=users
    }
}
