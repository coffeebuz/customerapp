package com.coffeebuz.coffeebuz.ui.coffeeshops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.coffeebuz.coffeebuz.DataManager
import com.coffeebuz.coffeebuz.databinding.CoffeeshopsFragmentBinding

class CoffeeshopsFragment : Fragment() {

    companion object {
        fun newInstance() = CoffeeshopsFragment()
    }

    private lateinit var binding: CoffeeshopsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CoffeeshopsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.coffeeshops = DataManager.coffeeshops


    }

}
