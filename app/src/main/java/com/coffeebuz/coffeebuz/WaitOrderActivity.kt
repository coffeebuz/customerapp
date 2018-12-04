package com.coffeebuz.coffeebuz

import java.util.concurrent.TimeUnit
import java.util.Locale
import android.os.Bundle
import android.os.CountDownTimer
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_wait_order.*
import kotlinx.android.synthetic.main.content_wait_order.*

class WaitOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wait_order)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
    private fun timer(millisInFuture:Long,countDownInterval:Long): CountDownTimer {
        return object: CountDownTimer(millisInFuture,countDownInterval){
            override fun onTick(millisUntilFinished: Long){
                val timeRemaining = timeString(millisUntilFinished)
                waitTime.text = timeRemaining
            }

            override fun onFinish() {
                //nothing Yet
            }
        }
    }

    private fun timeString(millisUntilFinished:Long):String{
        var millisUntilFinished:Long = millisUntilFinished

        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)

        // Format the string
        return String.format(
            Locale.getDefault(),
            "%02d sec",
            seconds
        )
    }

}
