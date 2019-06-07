package com.example.zemiman.myfirstkotlinapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.zemiman.myfirstkotlinapp.adapters.HobbiesAdapter
import com.example.zemiman.myfirstkotlinapp.R
import com.example.zemiman.myfirstkotlinapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity(){
    companion object {
        val TAG:String=HobbiesActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        val layOutManager=LinearLayoutManager(this)
        layOutManager.orientation=LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=layOutManager
        val adapter= HobbiesAdapter(
            this,
            Supplier.hobbies
        )
        recyclerView.adapter=adapter

    }
}
