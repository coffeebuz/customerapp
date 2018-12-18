package com.coffeebuz.coffeebuz

import android.os.Parcel
import android.os.Parcelable
import com.coffeebuz.coffeebuz.ui.order.OrderFragment
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal
import java.math.BigInteger

@Parcelize
data class Address ( val street1: String, val street2: String? = null, val city: String ): Parcelable{
    constructor(parcel:Parcel) : this(
        parcel.readString(), parcel.readString(), parcel.readString())

    override fun toString(): String {
        return "$street1${" ${street2?:""}" }, $city"
    }
    companion object : Parceler<Address> {
        override fun create(parcel: Parcel): Address {
            return Address(parcel)
        }
        override fun Address.write(parcel: Parcel, flags: Int){
            parcel.writeString(street1)
            parcel.writeString(street2)
            parcel.writeString(city)
        }
    }
}

@Parcelize
data class CoffeeShop ( val name: String, val address: Address, val cupsToFreeCoffee: String ) : Parcelable {
    constructor(parcel:Parcel) : this(
        parcel.readString(), parcel.readParcelable(Address.javaClass.classLoader), parcel.readString()
    )
    companion object : Parceler<CoffeeShop> {
        override fun create(parcel: Parcel): CoffeeShop {
            return CoffeeShop(parcel)
        }
        override fun CoffeeShop.write(parcel: Parcel, flags: Int){
            parcel.writeString(name)
            parcel.writeParcelable(address, flags)
            parcel.writeString(cupsToFreeCoffee)
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