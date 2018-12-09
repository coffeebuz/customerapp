package com.coffeebuz.coffeebuz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.coffeebuz.coffeebuz.databinding.OrderActivityBinding
import com.coffeebuz.coffeebuz.ui.order.OrderFragment

class OrderActivity : AppCompatActivity() {
    private lateinit var mBinding: OrderActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<OrderActivityBinding>(this, R.layout.order_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.ordercontainer, OrderFragment.newInstance())
                .commitNow()
        }
    }

}
