package com.example.week04_rc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RVAdapter(val items : MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)
    }

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        if(itemClick != null){
            holder.itemView.setOnClickListener { v->
                itemClick?.onClick(v, position)
            }
        }
        holder.bindItem(items[position])
    }

    // 전체 리사이클러뷰의 갯수
    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item : String) {
            // 이 곳에 rv_item.xml의 View들을 연결하고 데이터를 세팅하는 코드를 추가하면 됩니다.
            // 예: val textView = itemView.findViewById<TextView>(R.id.textView)
            //     textView.text = item

            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item


        }
    }





}