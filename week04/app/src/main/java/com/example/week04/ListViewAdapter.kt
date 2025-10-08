package com.example.week04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List: MutableList<ListViewModel>) : BaseAdapter() {
    override fun getCount(): Int{
        return List.size
    }

    override fun getItem(position: Int) : Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var converView = convertView

        if(converView == null){
            converView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent,false)
        }

        val title = converView!!.findViewById<TextView>(R.id.listViewItem1)
        val content = converView!!.findViewById<TextView>(R.id.listViewItem2)
        // List[0] -> ListViewModel("a","b")

        title.text = List[position].title
        content.text = List[position].content

        return converView!!
    }
}