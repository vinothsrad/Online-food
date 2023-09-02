package com.example.onlinefood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinefood.R
import com.example.onlinefood.activity.DetailScreen
import com.example.onlinefood.responce.Category

class foodListAdater(val ctx: Context, val fooList: List<Category>, listItem: Int): RecyclerView.Adapter<foodListAdater.ViewHolder>() {




    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var foodName: TextView
        var foodId:TextView
        var foodImage:ImageView

        init {
            foodName=itemView.findViewById(R.id.foodName)
            foodId=itemView.findViewById(R.id.foodId)
            foodImage=itemView.findViewById(R.id.foodImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fooList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = fooList[position]
        holder.foodName.text=fooList[position].strCategory
        holder.foodId.text = fooList[position].idCategory
        Glide.with(ctx).load(fooList[position].strCategoryThumb).into(holder.foodImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(ctx,DetailScreen::class.java)
            intent.putExtra("name",item.strCategory)
            intent.putExtra("image",item.strCategoryThumb)
            intent.putExtra("detail",item.strCategoryDescription)
            ctx.startActivity(intent)

        }
    }


}