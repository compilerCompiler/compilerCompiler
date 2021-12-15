package com.upb.vlibrary.ui.menuAdmi


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.vlibrary.ListOfUsersAdapter
import com.upb.vlibrary.ListOfUsersViewModel
import com.upb.vlibrary.databinding.FragmentAdminBinding
import com.upb.vlibrary.databinding.FragmentSupportBinding


class AdminFragment : Fragment() {

    private lateinit var binding: FragmentAdminBinding
    private val listOfUsersAdapter = ListOfUsersAdapter()
    private val listOfUsersViewModel: ListOfUsersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAdminBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listOfUsersViewModel.updateListUsers()
        binding.rvAdmin.adapter= listOfUsersAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvAdmin.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvAdmin)
        listOfUsersViewModel.users.observe(viewLifecycleOwner){
            listOfUsersAdapter.addAll(it)
        }

        listOfUsersAdapter.setOnUserClickListener {
            Toast.makeText(context,"Se toco el usuario con id : ${it.Id_Usuario}", Toast.LENGTH_SHORT).show()

        }
    }
}