package com.example.week04_rc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Singer1Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_singer1, container, false)

        val items = mutableListOf<String>()
        items.add("Dynamite")
        items.add("작은 것들을 위한 시(Boy with Luv)")
        items.add("Butter")
        items.add("봄날")
        items.add("DNA")
        items.add("I NEED U")
        items.add("FAKE LOVE")
        items.add("MIC Drop")
        items.add("IDOL")
        items.add("불타오르네(FIRE)")
        items.add("소우주(Mikrokosmos)")
        items.add("피 땀 눈물")
        items.add("Save ME")
        items.add("Permission to Dance")
        items.add("RUN")
        items.add("상남자")
        items.add("Life Goes On")
        items.add("ON")


        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)



        val image2 = view.findViewById<ImageView>(R.id.blackpink)
        image2.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer2Fragment)
        }

        val image3 = view.findViewById<ImageView>(R.id.aespa)
        image3.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer3Fragment)
        }

        return view
    }

}