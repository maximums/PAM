package com.cristian.pam1

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.VideoView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.cristian.pam1.databinding.ActivityMainBinding
import com.cristian.pam1.feed.Second
import kotlinx.android.synthetic.main.activity_main.view.*

class Welcome : AppCompatActivity() {

    private lateinit var death_note_op: VideoView
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mute_unmute: ImageButton
    private val PATH: String = "android.resource://com.cristian.pam1/"+R.raw.df_back

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val uri: Uri = Uri.parse(PATH)

        death_note_op = binding.dfnOp
        death_note_op.setVideoURI(uri)
        death_note_op.start()
        death_note_op.setOnPreparedListener { mp: MediaPlayer? ->
            if (mp != null) {
                mp.isLooping = true
                mediaPlayer = mp
            }
        }

        mute_unmute = findViewById(R.id.mute_unmute)
        mute_unmute.setOnClickListener{
            if (mute_unmute.tag == "Unmute") {
                mute_unmute.tag = "Mute"
                mute_unmute.setImageResource(R.drawable.ic_unmute)
                mediaPlayer.setVolume(1f, 1f)
            }
            else {
                mute_unmute.tag = "Unmute"
                mute_unmute.setImageResource(R.drawable.ic_mute)
                mediaPlayer.setVolume(0f, 0f)
            }
        }
    }

    fun next(view: View) {
        val input: EditText = findViewById(binding.root.text_input.id)
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