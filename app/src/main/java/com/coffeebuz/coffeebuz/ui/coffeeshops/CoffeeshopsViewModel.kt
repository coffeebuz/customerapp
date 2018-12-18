package com.coffeebuz.coffeebuz.ui.coffeeshops

import androidx.lifecycle.ViewModel
import com.coffeebuz.coffeebuz.CoffeeShop
import com.coffeebuz.coffeebuz.DataManager

class CoffeeshopsViewModel(val coffeeshops:List<CoffeeShop>): ViewModel() {
    constructor(): this(DataManager.coffeeshops)
}
