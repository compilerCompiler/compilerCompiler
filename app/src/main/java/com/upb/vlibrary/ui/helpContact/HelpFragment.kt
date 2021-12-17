package com.upb.vlibrary.ui.helpContact


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upb.vlibrary.databinding.FragmentHelpBinding


class HelpFragment : Fragment() {

    private lateinit var binding: FragmentHelpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHelpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding.buttonMail.setOnClickListener {
           val webIntent: Intent = Uri.parse("https://www.gmail.com").let { webpage ->
               Intent(Intent.ACTION_VIEW, webpage)
           }
           startActivity(webIntent)
       }
       binding.buttonRedes.setOnClickListener {
           val webIntent: Intent = Uri.parse("https://www.facebook.com/SEUPBLaPaz").let { webpage ->
               Intent(Intent.ACTION_VIEW, webpage)
           }
           startActivity(webIntent)
       }

    }
}