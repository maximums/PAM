package com.cristian.pam1.ui.view

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.VideoView
import com.cristian.pam1.R
import com.cristian.pam1.databinding.ActivityMainBinding

class Welcome : AppCompatActivity() {

    private lateinit var death_note_op: VideoView
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mute_unmute: ImageButton
    private val PATH: String = "android.resource://com.cristian.pam1/"+ R.raw.df_back

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        death_note_op = binding.dfnOp
        initBackgroundOp(Uri.parse(PATH))

        mute_unmute = binding.muteUnmute
        muteUnmute()

    }

    fun next(view: View) = startActivity(Intent(this, FragmentHolderActivity::class.java))

    private fun initBackgroundOp(uri: Uri) {
        death_note_op.setVideoURI(uri)
        death_note_op.start()
        death_note_op.setOnPreparedListener { mp: MediaPlayer? ->
            if (mp != null) {
                mp.isLooping = true
                mediaPlayer = mp
            }
        }
    }

    private fun muteUnmute() {
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