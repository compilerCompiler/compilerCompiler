package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.databinding.FragmentArticleSearchInfoBinding

class ArticleSearchInfoFragment: Fragment() {

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
        libro= args.infoBook
        binding.articleInfo=libro
        binding.imgButtonReservarAsInfo.setOnClickListener {
            val goToReservationPage = ArticleSearchInfoFragmentDirections.actionArticleSearchInfoFragmentToReservationFormFragment(libro)
            findNavController().navigate(goToReservationPage)
        }
    }
}