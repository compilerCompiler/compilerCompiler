package com.upb.vlibrary.ui.menuAdmi


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.CompleteListOfUsersViewModel
import com.upb.vlibrary.ListOfUsersViewModel
import com.upb.vlibrary.databinding.FragmentMenuAdminBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.properties.Delegates


class MenuAdminFragment : Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private var idUsuario by Delegates.notNull<Int>()
    private val args: MenuAdminFragmentArgs by navArgs()
    private lateinit var binding:FragmentMenuAdminBinding
    private val completeListOfUsersViewModel: CompleteListOfUsersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuAdminBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.userName
        password=args.password
        idUsuario=args.idUsuario
            binding.btReserva.setOnClickListener {
                val goToReservationPage= MenuAdminFragmentDirections.actionMenuAdminFragmentToReservationMainFragment(username,password,idUsuario)
                findNavController().navigate(goToReservationPage)
            }
            binding.btAyuda.setOnClickListener {
                val goToHelpPage=MenuAdminFragmentDirections.actionMenuAdminFragmentToSupportFragment()
                findNavController().navigate(goToHelpPage)
            }
            binding.btBusqueda.setOnClickListener {
                val goToSearchPage=MenuAdminFragmentDirections.actionMenuAdminFragmentToArticleSearchFragment(username,password,idUsuario)
                findNavController().navigate(goToSearchPage)
            }
            binding.btMultimedia.setOnClickListener {
                val goToMultimedia =MenuAdminFragmentDirections.actionMenuAdminFragmentToMultimediaMainFragment()
                findNavController().navigate(goToMultimedia)
            }
            binding.btAdmin.setOnClickListener {
                val goToUsersPage=MenuAdminFragmentDirections.actionMenuAdminFragmentToAdminFragment(username,password,idUsuario)
                findNavController().navigate(goToUsersPage)
            }
            binding.imgGrafica.setOnClickListener {
                completeListOfUsersViewModel.getAllListOfUsers().onEach {
                    Toast.makeText(context,"Primer elemento ${it[0]}",Toast.LENGTH_SHORT).show()
                }.catch {
                    Toast.makeText(context,"Primer elemento ${it}",Toast.LENGTH_SHORT).show()
                }.launchIn(CoroutineScope(Dispatchers.Main))

            //listOfUsersViewModel.getAllListOfUsers()
                //listOfUsersViewModel.completeListOfUsers.observe(viewLifecycleOwner){
                  //  Toast.makeText(context,"Primer elemento ${it}",Toast.LENGTH_SHORT).show()
                    //Toast.makeText(context,"Ultimo elemento ${it[it.lastIndex].Id_usuario}",Toast.LENGTH_SHORT).show()


            }

    }
}