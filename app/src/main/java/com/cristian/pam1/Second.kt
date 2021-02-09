package com.cristian.pam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class Second : AppCompatActivity() {

    var message: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun submit(view: View) {
        val textView: TextView = findViewById(R.id.textView2)
        message = intent.getStringExtra("MESSAGE").toString()
        message = "Your sting to uppercase: " + message.toUpperCase(Locale.ROOT)
        textView.text = message
    }

    override fun onPause() {
        super.onPause()
        startActivity(Intent(this, Welcome::class.java).apply {
            putExtra("MESSAGE", message)
        })
    }
}