package com.upb.vlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.upb.vlibrary.databinding.FragmentLoginBinding


class LoginFragment:Fragment() {


    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonNext.setOnClickListener{
            val queue = Volley.newRequestQueue(context)
            val url = "http://localhost:4000/api/tutorials/findAll"
            val goToMainMenu = LoginFragmentDirections.actionLoginFragmentToMenuUserFragment()
            findNavController().navigate(goToMainMenu)
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    println("Response is: ${response.substring(0, 500)}")
                },
                Response.ErrorListener { println("That didn't work!") } )

            // Add the request to the RequestQueue.
            queue.add(stringRequest)
         }
        }
    }
