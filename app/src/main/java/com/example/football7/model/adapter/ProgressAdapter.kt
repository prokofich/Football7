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
import com.example.football7.*
import com.example.football7.model.constant.GOALKEEPER
import com.example.football7.model.constant.HEADBUTT
import com.example.football7.model.constant.RUNNING

class ProgressAdapter(private val context: Context):RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder>() {

    private var listProgress = ArrayList<String?>()
    private var valueToKey = ""

    class ProgressViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_progress,parent,false)
        return  ProgressViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {

        val imageViewProgress = holder.itemView.findViewById<ImageView>(R.id.id_item_progress_image_dinamics)
        val textViewResult = holder.itemView.findViewById<TextView>(R.id.id_item_progress_result)
        val textViewNumber = holder.itemView.findViewById<TextView>(R.id.id_item_progress_number)

        if(position!=0 && listProgress[position]!! > listProgress[position-1]!!){
            Glide.with(context)
                .load(R.drawable.ic_result_up)
                .into(imageViewProgress)
        }

        if(position!=0 && listProgress[position]!! <= listProgress[position-1]!!){
            Glide.with(context)
                .load(R.drawable.ic_result_down)
                .into(imageViewProgress)
        }

        when(valueToKey){
            RUNNING -> {
                textViewResult.text = listProgress[position].toString() + " s"
            }
            GOALKEEPER -> {
                textViewResult.text = listProgress[position].toString() + " saves"
            }
            HEADBUTT -> {
                textViewResult.text = listProgress[position].toString() + " goals"
            }
        }

        textViewNumber.text = (position+1).toString()

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