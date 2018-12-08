package com.coffeebuz.coffeebuz

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.coffeebuz.coffeebuz.databinding.ActivityOrderBinding
import com.coffeebuz.coffeebuz.databinding.ContentOrderBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_order.*


class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val activityOrderBinding  = DataBindingUtil.setContentView<ActivityOrderBinding>(
            this, R.layout.activity_order)
        activityOrderBinding.setLifecycleOwner(this)
        val viewModel = ViewModelProviders.of(this).get(OrderViewModel::class.java)
        val contentOrderBinding=  DataBindingUtil.getBinding<ContentOrderBinding>(ordercontent)
        contentOrderBinding!!.viewmodel = viewModel
        setSupportActionBar(toolbar)
    }

}
