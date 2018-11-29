package com.coffeebuz.coffeebuz

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_dash.*
import kotlinx.android.synthetic.main.content_dash.*

class DashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)
        setSupportActionBar(toolbar)

        dashItems.layoutManager = LinearLayoutManager(this)

        dashItems.adapter = CoffeeShopRecyclerAdapter(this,DataManager.coffeeshops)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
