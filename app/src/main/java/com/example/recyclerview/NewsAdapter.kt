package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class NewsAdapter(context: Context, val newsList: ArrayList<TodayNews>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private lateinit var myListener:onItemClickListener
    interface  onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        myListener=listener
    }
    //to create new view instance when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_new_view,parent,false)
        return NewsViewHolder(itemView,myListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var currentItem = newsList[position]
        holder.hTitle.text = currentItem.hText
        holder.hImage.setImageResource(currentItem.hImage)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
    class NewsViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.heading)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.hImage)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

}