package com.coffeebuz.coffeebuz

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal
import java.math.BigInteger

data class Address ( val street1: String, val street2: String? = null, val city: String  ){
    override fun toString(): String {
        return "$street1${" ${street2?:""}" }, $city"
    }
}
data class CoffeeShop ( val name: String, val address: Address, val cupsToFreeCoffee: String )

fun Parcel.readByteArrayToBigInteger() : BigInteger {
    val byteArray = createByteArray()
    readByteArray(byteArray)
    return BigInteger(byteArray)
}

@Parcelize
data class Order (
    val itemName: String?,
    val price: BigDecimal ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        BigDecimal(parcel.readByteArrayToBigInteger(), parcel.readInt())
    )

    companion object : Parceler<Order> {

        override fun Order.write(parcel: Parcel, flags: Int) {
            parcel.writeString(itemName)
            parcel.writeByteArray(price.unscaledValue().toByteArray())
            parcel.writeInt(price.scale())
        }

        override fun create(parcel: Parcel): Order {
            return Order(parcel)
        }
    }
}

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