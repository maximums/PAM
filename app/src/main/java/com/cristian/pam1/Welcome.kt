package com.cristian.pam1

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.VideoView
import com.cristian.pam1.feed.Second

class Welcome : AppCompatActivity() {

    private lateinit var death_note_op: VideoView
    private val PATH: String = "android.resource://com.cristian.pam1/"+R.raw.df_back

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        death_note_op = findViewById(R.id.dfn_op)
        val uri: Uri = Uri.parse(PATH)
        death_note_op.setVideoURI(uri)
        death_note_op.start()
        death_note_op.setOnPreparedListener { mp: MediaPlayer? ->
            if (mp != null) {
                mp.isLooping = true
            }
        }
        death_note_op
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
        death_note_op.resume()
        super.onResume()
    }

    override fun onPause() {
        death_note_op.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        death_note_op.stopPlayback()
        super.onDestroy()
    }
}