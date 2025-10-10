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

class Singer2Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer2, container, false)


        val items = mutableListOf<String>()
        items.add("뛰어(JUMP)")
        items.add("마지막처럼")
        items.add("Lovesick Girls")
        items.add("불장난")
        items.add("Shut Down")
        items.add("Forever Young")
        items.add("Pink Venom")
        items.add("뚜두뚜두(DDU-DU DDU-DU)")
        items.add("How You Like That")
        items.add("휘파람")
        items.add("Kill This Love")
        items.add("STAY")
        items.add("Don't Know What To Do")
        items.add("붐바야")
        items.add("Pretty Savage")
        items.add("Kick it")
        items.add("Ready For Love")


        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)



        view.findViewById<ImageView>(R.id.bts).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer1Fragment2)
        }

        view.findViewById<ImageView>(R.id.aespa).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer3Fragment)
        }

        return view
    }

}