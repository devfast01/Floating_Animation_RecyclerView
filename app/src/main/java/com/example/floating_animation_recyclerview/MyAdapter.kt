package com.example.floating_animation_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(mData: ArrayList<String>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val mDataCopy = mData
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        val tvCard: TextView = view.findViewById(R.id.text_view_rv)

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCard.text = mDataCopy[position]
    }

    override fun getItemCount(): Int {
        return mDataCopy.size
    }
}
