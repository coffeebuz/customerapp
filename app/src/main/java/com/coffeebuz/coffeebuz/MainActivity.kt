package com.coffeebuz.coffeebuz

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.github.sumimakito.awesomeqr.AwesomeQRCode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onGenerateQRCodeClick( view: View){
        AwesomeQRCode.Renderer().contents(qrText!!.text.toString())
            .size(800).margin(20)
            .renderAsync(object : AwesomeQRCode.Callback {
                override fun onRendered(renderer: AwesomeQRCode.Renderer, bitmap: Bitmap) {
                    // Tip: here we use runOnUiThread {...} to avoid the problems caused by operating UI elements from a non-UI thread.
                    runOnUiThread {
                        val qrCodeImageViewer = findViewById<ImageView>(R.id.qrCode)
                        qrCodeImageViewer!!.setImageBitmap(bitmap)
                    }
                }

                override fun onError(renderer: AwesomeQRCode.Renderer, e: Exception) {
                    e.printStackTrace()
                }
            })
    }
}
