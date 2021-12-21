package com.upb.vlibrary.ui.menuAdmi


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.vlibrary.ListOfUsersAdapter
import com.upb.vlibrary.ui.viewmodels.ListOfUsersViewModel
import com.upb.vlibrary.databinding.FragmentAdminBinding
import kotlin.properties.Delegates


class AdminFragment : Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private var idUsuario by Delegates.notNull<Int>()
    private val args:AdminFragmentArgs by navArgs()
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
        username=args.userName
        password=args.password
        idUsuario=args.idUsuario

        listOfUsersViewModel.updateListUsers()
        binding.rvAdmin.adapter= listOfUsersAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvAdmin.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvAdmin)
        listOfUsersViewModel.users.observe(viewLifecycleOwner){
            listOfUsersAdapter.addAll(it)
        }

        listOfUsersAdapter.setOnUserClickListener {
            Log.d("Main","Persona id: ${it.Id_persona}")
            //Toast.makeText(context,"Se toco el usuario con id : ${it.Id_Usuario}", Toast.LENGTH_SHORT).show()
            val goToUserInfo= AdminFragmentDirections.actionAdminFragmentToUserDetails(it,username,password,idUsuario)
            findNavController().navigate(goToUserInfo)
        }
    }
}