package com.coffeebuz.coffeebuz.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coffeebuz.coffeebuz.COFFEESHOP
import com.coffeebuz.coffeebuz.CoffeeShop
import com.coffeebuz.coffeebuz.databinding.OrderFragmentBinding


class OrderFragment : Fragment() {

    companion object {
        fun newInstance(coffeeshop: CoffeeShop) : OrderFragment{
            val orderFragment = OrderFragment()
            val bundle = Bundle()
            bundle.putParcelable(COFFEESHOP, coffeeshop)
            orderFragment.arguments = bundle
            return orderFragment
        }
    }

    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(arguments != null )
        {
            viewModel  = OrderViewModel( (arguments as Bundle).getParcelable(COFFEESHOP) )
        }

        val binding= OrderFragmentBinding.inflate(inflater)
        binding.orderViewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
