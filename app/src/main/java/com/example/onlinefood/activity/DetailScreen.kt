package com.example.onlinefood.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.onlinefood.R

class DetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
         val foodName=findViewById<TextView>(R.id.dFname)
        val foodImage=findViewById<ImageView>(R.id.dFimage)
        val foodDetail=findViewById<TextView>(R.id.dFdetail)

        val bundle:Bundle?=intent.extras
        val fName=bundle!!.getString("name")
        val fImage=bundle!!.getString("image")
        val fDetail=bundle!!.getString("detail")

        Glide.with(this).load(fImage).placeholder(R.drawable.beef).into(foodImage)
        foodName.text=fName
        foodDetail.text=fDetail

        }
    }
