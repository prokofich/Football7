package com.example.football7.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football7.R
import com.example.football7.model.Player
import com.example.football7.model.PlayerItem
import kotlinx.android.synthetic.main.item_best_player.view.*

class PlayerAdapter(private val context: Context):RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    var list = emptyList<PlayerItem>()

    class PlayerViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_best_player,parent,false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position].image)
            .into(holder.itemView.id_item_player_image_player)
        Glide.with(context)
            .load(list[position].club)
            .into(holder.itemView.id_item_player_image_club)
        holder.itemView.id_item_player_name.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(List:ArrayList<PlayerItem>){
        list = List
        notifyDataSetChanged()
    }

}