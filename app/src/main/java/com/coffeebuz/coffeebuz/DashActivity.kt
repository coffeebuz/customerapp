package com.coffeebuz.coffeebuz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dash.*
import kotlinx.android.synthetic.main.content_dash.*

class DashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)
        setSupportActionBar(toolbar)

        dashItems.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        dashItems.adapter = CoffeeShopRecyclerAdapter(this,DataManager.coffeeshops)

    }

}
