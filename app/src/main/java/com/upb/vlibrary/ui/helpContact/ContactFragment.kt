package com.upb.vlibrary.ui.helpContact


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.vlibrary.databinding.FragmentContactBinding


class ContactFragment : Fragment() {

    private val contactsListAdapter= ContactListAdapter()
    private lateinit var binding:FragmentContactBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentContactBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvCcontacto.adapter = contactsListAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvCcontacto.layoutManager = layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvCcontacto)
        contactsListAdapter.addAll(ContactsDataSource.contactList)
        contactsListAdapter.setOnContactClickListener {
            Toast.makeText(context,"Numero: ${it.numero}",Toast.LENGTH_SHORT).show()
        }
    }
}