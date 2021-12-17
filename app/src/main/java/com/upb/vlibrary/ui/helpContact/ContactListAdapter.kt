package com.upb.vlibrary.ui.helpContact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upb.vlibrary.databinding.ContactInfoBinding

class ContactListAdapter:RecyclerView.Adapter<ContactListViewHolder>() {
    private val contactList: MutableList<Contact> = mutableListOf()
    private var onContactItemListener:((contacto: Contact)-> Unit)? = null

    fun addAll(newContactList: MutableList<Contact>){
        contactList.clear()
        contactList.addAll(newContactList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val binding = ContactInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        holder.bind(contactList[position])
        holder.binding.root.setOnClickListener{
            onContactItemListener?.invoke(contactList[position])
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun setOnContactClickListener(onContactClickListener:((contacto: Contact)-> Unit)? ) {
        this.onContactItemListener =onContactClickListener
    }

}

class ContactListViewHolder(val binding: ContactInfoBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(contact: Contact){
        binding.contacto=contact
    }
}