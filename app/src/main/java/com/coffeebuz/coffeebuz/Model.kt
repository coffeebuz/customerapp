package com.coffeebuz.coffeebuz

import java.math.BigDecimal

data class Address ( val street1: String, val street2: String? = null, val city: String  ){
    override fun toString(): String {
        return "$street1${" ${street2?:""}" }, $city"
    }
}
data class CoffeeShop ( val name: String, val address: Address, val cupsToFreeCoffee: String )

object DataManager {
    val coffeeshops = ArrayList<CoffeeShop>()

    init {
        loadCoffeeShops()
    }

    private fun loadCoffeeShops() {
        coffeeshops.add(CoffeeShop("ChuckBeans"
            , Address("7 Collins Street", city = "Melbourne")
            , "Free"))

        coffeeshops.add(CoffeeShop("Jane's Cuppa"
            , Address("8 Bourke Street", city = "Melbourne")
            , "1 more cup"))
    }
}