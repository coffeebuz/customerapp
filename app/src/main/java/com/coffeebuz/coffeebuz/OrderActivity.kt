package com.coffeebuz.coffeebuz

import java.util.concurrent.TimeUnit
import java.util.Locale

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_order.*


class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val minute:Long = 60000
        val millisInFuture:Long =  (2 * minute )
        val countDownInterval:Long = 1000
        timer(millisInFuture, countDownInterval)
    }
    private fun timer(millisInFuture:Long,countDownInterval:Long):CountDownTimer{
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
