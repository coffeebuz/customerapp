package com.coffeebuz.coffeebuz.ui.coffeeshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coffeebuz.coffeebuz.databinding.CoffeeshopFragmentBinding


class CoffeeshopFragment : Fragment() {

    companion object {
        fun newInstance() = CoffeeshopFragment()
    }

    private lateinit var binding: CoffeeshopFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CoffeeshopFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
