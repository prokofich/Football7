package com.example.football7.model.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football7.*
import com.example.football7.model.constant.GOALKEEPER
import com.example.football7.model.constant.HEADBUTT
import com.example.football7.model.constant.RUNNING
import kotlinx.android.synthetic.main.item_progress.view.*

class ProgressAdapter(private val context: Context):RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder>() {

    private var listProgress = ArrayList<String?>()
    private var valueToKey = ""

    class ProgressViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_progress,parent,false)
        return  ProgressViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {
        if(position!=0 && listProgress[position]!! > listProgress[position-1]!!){
            Glide.with(context)
                .load(R.drawable.ic_result_up)
                .into(holder.itemView.id_item_progress_image_dinamics)
        }

        if(position!=0 && listProgress[position]!! <= listProgress[position-1]!!){
            Glide.with(context)
                .load(R.drawable.ic_result_down)
                .into(holder.itemView.id_item_progress_image_dinamics)
        }

        when(valueToKey){
            RUNNING -> {
                holder.itemView.id_item_progress_result.text = listProgress[position].toString() + " s"
            }
            GOALKEEPER -> {
                holder.itemView.id_item_progress_result.text = listProgress[position].toString() + " saves"
            }
            HEADBUTT -> {
                holder.itemView.id_item_progress_result.text = listProgress[position].toString() + " goals"
            }
        }

        holder.itemView.id_item_progress_number.text = (position+1).toString()

    }

    override fun getItemCount(): Int {
        return listProgress.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addResultInList(result:String,value:String){
        listProgress.add(result)
        valueToKey = value
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    @JvmName("setList1")
    fun setList(list:ArrayList<String?>,value:String){
        listProgress = list
        valueToKey = value
        notifyDataSetChanged()
    }

}