package com.example.football7.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football7.*
import kotlinx.android.synthetic.main.fragment_progress.*
import kotlinx.android.synthetic.main.item_progress.view.*

class ProgressAdapter(private val context: Context):RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder>() {

    var list = ArrayList<String?>()
    var valueToKey = ""

    class ProgressViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_progress,parent,false)
        return  ProgressViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {
        if(position!=0 && list[position]!! > list[position-1]!!){
            Glide.with(context)
                .load(R.drawable.ic_result_up)
                .into(holder.itemView.id_item_progress_image_dinamics)
        }

        if(position!=0 && list[position]!! <= list[position-1]!!){
            Glide.with(context)
                .load(R.drawable.ic_result_down)
                .into(holder.itemView.id_item_progress_image_dinamics)
        }

        when(valueToKey){
            RUNNING -> {
                holder.itemView.id_item_progress_result.text = list[position].toString() + " s"
            }
            GOALKEEPER -> {
                holder.itemView.id_item_progress_result.text = list[position].toString() + " saves"
            }
            HEADBUTT -> {
                holder.itemView.id_item_progress_result.text = list[position].toString() + " goals"
            }
        }


        holder.itemView.id_item_progress_number.text = (position+1).toString()


    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addResultInList(result:String,value:String){
        list.add(result)
        valueToKey = value
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    @JvmName("setList1")
    fun setList(List:ArrayList<String?>,value:String){
        list = List
        valueToKey = value
        notifyDataSetChanged()
    }

}