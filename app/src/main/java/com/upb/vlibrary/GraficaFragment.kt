package com.upb.vlibrary

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter
import com.upb.vlibrary.databinding.FragmentGraficaBinding
import kotlin.properties.Delegates

class GraficaFragment: Fragment() {

    private var totalUsers by Delegates.notNull<Int>()
    private var normalTotalUsers by Delegates.notNull<Int>()
    private val args: GraficaFragmentArgs by navArgs()


    fun draw(view: View){
        val arrayList= ArrayList<Int>()
        //arrayList.add(Int.)
    }


    private lateinit var binding:FragmentGraficaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGraficaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        totalUsers=args.totalUsers
        normalTotalUsers=args.totalNormalUsers
        val arrayList=ArrayList<Int>()
        arrayList.add(totalUsers-normalTotalUsers)
        arrayList.add(normalTotalUsers)
        val s1 = Segment("Usuarios normales",arrayList.get(0))
        val s2 = Segment("Usuarios admin",arrayList.get(1))
        val sf1 = SegmentFormatter(Color.GREEN)
        val sf2 = SegmentFormatter(Color.BLUE)
        binding.pieChart.addSegment(s1,sf1)
        binding.pieChart.addSegment(s2,sf2)
    }
}