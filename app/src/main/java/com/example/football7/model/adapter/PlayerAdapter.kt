package com.example.football7.model.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football7.R
import com.example.football7.model.modelDataFromServer.PlayerItem

class PlayerAdapter(private val context: Context) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    private var listPlayers = emptyList<PlayerItem>()

    class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_best_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {

        val textViewName = holder.itemView.findViewById<TextView>(R.id.id_item_player_name)
        val imageViewPlayer = holder.itemView.findViewById<ImageView>(R.id.id_item_player_image_player)
        val imageViewClub = holder.itemView.findViewById<ImageView>(R.id.id_item_player_image_club)

        Glide.with(context)
            .load(listPlayers[position].image)
            .into(imageViewPlayer)
        Glide.with(context)
            .load(listPlayers[position].club)
            .into(imageViewClub)
        textViewName.text = listPlayers[position].name

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