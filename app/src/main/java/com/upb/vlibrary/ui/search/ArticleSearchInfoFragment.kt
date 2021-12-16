package com.upb.vlibrary.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.Books
import com.upb.vlibrary.databinding.FragmentArticleSearchInfoBinding
import kotlin.properties.Delegates

class ArticleSearchInfoFragment: Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private var idUsuario by Delegates.notNull<Int>()
    private lateinit var libro: Books
    private val args: ArticleSearchInfoFragmentArgs by navArgs()
    private lateinit var binding: FragmentArticleSearchInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentArticleSearchInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.userName
        password=args.password
        idUsuario=args.idUsuario
        libro= args.infoBook
        binding.articleInfo=libro
        binding.imgButtonReservarAsInfo.setOnClickListener {
            if(libro.Reservado == 0){
                val goToReservationPage = ArticleSearchInfoFragmentDirections.actionArticleSearchInfoFragmentToReservationFormFragment(libro,username,password,idUsuario)
                findNavController().navigate(goToReservationPage)
            }else{
                Toast.makeText(context,"Libbro no disponible",Toast.LENGTH_SHORT).show()
            }

        }
    }
}