package com.coffeebuz.coffeebuz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.coffeebuz.coffeebuz.databinding.CoffeeshopFragmentBinding
import com.coffeebuz.coffeebuz.ui.coffeeshop.CoffeeshopViewModel


class CoffeeShopRecyclerAdapter ( private val context: Context, private val coffeeshops: ArrayList<CoffeeShop>)
    : androidx.recyclerview.widget.RecyclerView.Adapter<CoffeeShopRecyclerAdapter.BindingHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private val ctx: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BindingHolder {
        val itemView: CoffeeshopFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.coffeeshop_fragment, parent, false)
        return BindingHolder(itemView.root)
    }

    fun refreshList(newCoffeeShops: List<CoffeeShop> ){
        coffeeshops.clear()
        coffeeshops.addAll(newCoffeeShops)
    }

    override fun getItemCount() = coffeeshops.size

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.binding!!.mainActivity = ctx as IMainActivity
        holder.binding.coffeeshopViewwModel = CoffeeshopViewModel(coffeeshops[position])
        holder.binding.executePendingBindings()
    }

    inner class BindingHolder (itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        val binding: CoffeeshopFragmentBinding? = DataBindingUtil.bind(itemView)

    }
}