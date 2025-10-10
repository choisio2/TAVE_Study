package com.example.week04_rc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Singer3Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer3, container, false)


        val items = mutableListOf<String>()
        items.add("Rich Man")
        items.add("Whiplash")
        items.add("Dirty Work")
        items.add("Supernova")
        items.add("UP")
        items.add("Armageddon")
        items.add("Drama")
        items.add("Spicy")
        items.add("Next Level")
        items.add("Dark Arts")
        items.add("도깨비불(Illusion)")
        items.add("Savage")
        items.add("Thirsty")
        items.add("Girls")
        items.add("Dreams Come True")
        items.add("Black Mamba")
        items.add("Better Things")


        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)



        view.findViewById<ImageView>(R.id.bts).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer3Fragment_to_singer1Fragment)
        }

        view.findViewById<ImageView>(R.id.blackpink).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer3Fragment_to_singer2Fragment)
        }

        return view
    }
}