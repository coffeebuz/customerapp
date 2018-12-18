package com.coffeebuz.coffeebuz

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object MyBindingAdapters {


    @BindingAdapter("app:coffeeshops")
    @JvmStatic
    fun setCoffeeShops(view: RecyclerView, coffeeshops: List<CoffeeShop>) {

        if (view.layoutManager == null) {
            view.layoutManager = LinearLayoutManager(view.context)
        }

        if (view.adapter == null) {
            view.adapter = CoffeeShopRecyclerAdapter(view.context, ArrayList(coffeeshops))
            return
        }

        (view.adapter as CoffeeShopRecyclerAdapter).refreshList(DataManager.coffeeshops)
    }
}