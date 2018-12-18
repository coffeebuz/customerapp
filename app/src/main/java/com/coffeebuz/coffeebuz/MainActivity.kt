package com.coffeebuz.coffeebuz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.coffeebuz.coffeebuz.databinding.MainActivityBinding
import com.coffeebuz.coffeebuz.ui.coffeeshops.CoffeeshopsFragment
import com.coffeebuz.coffeebuz.ui.order.OrderFragment

class MainActivity : IMainActivity, AppCompatActivity() {

    override fun inflateOrderFragment(coffeeShop: CoffeeShop) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, OrderFragment.newInstance(coffeeShop))
            .commitNow()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CoffeeshopsFragment.newInstance())
                .commitNow()
        }


    }

}
