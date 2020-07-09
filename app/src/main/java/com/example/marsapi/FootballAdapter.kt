package com.example.marsapi

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.footballrow.view.*
import kotlinx.android.synthetic.main.row.view.*
import kotlinx.android.synthetic.main.typerow.view.*

class FootballAdapter(private val footballList: FootballList) :RecyclerView.Adapter<FootballAdapter.ViewHolder>() {

    class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        val id_number :TextView = itemView.id_number
        val published_at : TextView = itemView.published_at
        val body : TextView = itemView.bodies
        val imageView : ImageView = itemView.footballimage


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.footballrow,parent,false)
        return FootballAdapter.ViewHolder(view)
    }

    override fun getItemCount() = footballList.data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id_number.text = footballList.data[position].id.toString()
        holder.published_at.text = footballList.data[position].publishedAt
        holder.body.text = footballList.data[position].body
        Picasso.get().load(footballList.data[position].source).into(holder.imageView)
    }


}