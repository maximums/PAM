package com.cristian.pam1

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Welcome : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout: ConstraintLayout = findViewById(R.id.background_view)
        val anim = constraintLayout.background as AnimationDrawable
        anim.setEnterFadeDuration(500)
        anim.setExitFadeDuration(700)
        anim.start()

    }

    fun next(view: View) {
        val input: EditText = findViewById(R.id.text_input)
        val message: String = input.text.toString()
        val intent = Intent(this, Second::class.java).apply {
            putExtra("MESSAGE", message)
        }
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val textView: TextView = findViewById(R.id.textView)
        textView.text= intent.getStringExtra("MESSAGE")
    }
}