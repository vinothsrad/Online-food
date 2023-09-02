package com.example.onlinefood.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinefood.R
import com.example.onlinefood.adapter.foodListAdater
import com.example.onlinefood.api.ApiInterface
import com.example.onlinefood.api.RestClient
import com.example.onlinefood.responce.Category
import com.example.onlinefood.responce.foodResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var mApiService: ApiInterface? = null

    private var mAdapter: foodListAdater?= null;
    private var mCategory: MutableList<Category> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listRecycler= findViewById<RecyclerView>(R.id.recycler_view)


            mApiService = RestClient.client.create(ApiInterface::class.java)

            listRecycler!!.layoutManager = LinearLayoutManager(this)

            mAdapter = foodListAdater(this, mCategory, R.layout.list_item)
            listRecycler!!.adapter = mAdapter

            fetchFood()
        }

        private fun fetchFood() {
            val call = mApiService!!.getData("android")
            call.enqueue(object : Callback<foodResponce> {

                override fun onResponse(call: Call<foodResponce>, response: Response<foodResponce>) {

                    Log.d(TAG, "Total Questions: " + response.body()!!.categories!!.size)
                    val questions = response.body()
                    if (questions != null) {
                        mCategory.addAll(questions.categories!!)
                        mAdapter!!.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<foodResponce>, t: Throwable) {
                    Log.e(TAG, "Got error : " + t.localizedMessage)
                }
            })
        }

        companion object {
            private val TAG = MainActivity::class.java.simpleName
        }
    }

