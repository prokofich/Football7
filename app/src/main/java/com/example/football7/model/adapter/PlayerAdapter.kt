package com.example.football7.model.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football7.R
import com.example.football7.model.modelDataFromServer.PlayerItem
import kotlinx.android.synthetic.main.item_best_player.view.*

class PlayerAdapter(private val context: Context) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    private var listPlayers = emptyList<PlayerItem>()

    class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_best_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        Glide.with(context)
            .load(listPlayers[position].image)
            .into(holder.itemView.id_item_player_image_player)
        Glide.with(context)
            .load(listPlayers[position].club)
            .into(holder.itemView.id_item_player_image_club)
        holder.itemView.id_item_player_name.text = listPlayers[position].name
    }

    override fun getItemCount(): Int {
        return listPlayers.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<PlayerItem>?) {
        if(list!=null){
            listPlayers = list
            notifyDataSetChanged()
        }
    }

}