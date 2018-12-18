package com.coffeebuz.coffeebuz.ui.coffeeshop

import androidx.lifecycle.ViewModel
import com.coffeebuz.coffeebuz.Address
import com.coffeebuz.coffeebuz.CoffeeShop

class CoffeeshopViewModel(val name: String, val address: Address, val cupsToFreeCoffee: String ) : ViewModel() {
    constructor(coffeeShop: CoffeeShop) : this(
        coffeeShop.name,
        coffeeShop.address,
        coffeeShop.cupsToFreeCoffee
    )

    fun getCoffeeshop ():  CoffeeShop {
        return CoffeeShop(name,address,cupsToFreeCoffee)
    }
}
