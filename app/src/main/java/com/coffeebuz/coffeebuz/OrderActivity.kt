package com.coffeebuz.coffeebuz

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_order.*
import java.math.BigDecimal

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        orderButton.setOnClickListener {view->
            val intent = Intent(this, WaitOrderActivity::class.java)
            intent.putExtra(ORDER, Order("Weak soy flat white", BigDecimal(3.50)))
            startActivity(intent)

        }
    }

}
