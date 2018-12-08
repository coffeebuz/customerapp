package com.coffeebuz.coffeebuz

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class CoffeeShopRecyclerAdapter ( private val context: Context, private val coffeeshops: List<CoffeeShop>)
    : androidx.recyclerview.widget.RecyclerView.Adapter<CoffeeShopRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_dash_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = DataManager.coffeeshops.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coffeeshop = coffeeshops[position]

        holder.coffeeShopName?.text =coffeeshop.name
        holder.coffeeShopAddress?.text = coffeeshop.address.toString()
        holder.cupsToFreeCoffee?.text = coffeeshop.cupsToFreeCoffee
        holder.itemPosition = position
    }

    inner class ViewHolder (itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val coffeeShopName = itemView.findViewById<TextView?>(R.id.coffeeShopName)
        val coffeeShopAddress = itemView.findViewById<TextView?>(R.id.coffeeShopAddress)
        val cupsToFreeCoffee = itemView.findViewById<TextView?>(R.id.cupsToFreeCoffee)
        var itemPosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, OrderActivity::class.java)
                intent.putExtra(DASH_ITEM_POSITION, itemPosition)
                context.startActivity(intent)
            }
        }
    }
}