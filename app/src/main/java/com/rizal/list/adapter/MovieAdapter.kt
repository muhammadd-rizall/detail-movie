package com.rizal.list.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rizal.list.DetailBuah
import com.rizal.list.DetailMovie
import com.rizal.list.MainActivity
import com.rizal.list.R
import com.rizal.list.RecycleMovie
import com.rizal.list.adapter.BuahAdapter.MyViewHolder
import com.rizal.list.model.ModelMovie

class MovieAdapter(
  val itemList: ArrayList<ModelMovie>,
  val getActivity: RecycleMovie

): RecyclerView.Adapter<MovieAdapter.MyViewHolder>(){
    class MyViewHolder (itemView : View):RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemNama : TextView

        init {
            itemImage =itemView.findViewById(R.id.gambar1) as ImageView
            itemNama =itemView.findViewById(R.id.nama) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_recyclemovie, parent, false)
        return com.rizal.list.adapter.MovieAdapter.MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //set data ke widget
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemNama.setText(itemList[position].nama)

        //kita intent
        holder.itemView.setOnClickListener(){
            //inten
            //context atau this --> getActivity
            val intent = Intent(getActivity, DetailMovie::class.java)
            //kita put data untuk kita passed ke detail
            intent.putExtra("image",itemList[position].image)
            intent.putExtra("nama",itemList[position].nama)
            //passed ke detail
            getActivity.startActivity(intent)
        }
    }


}