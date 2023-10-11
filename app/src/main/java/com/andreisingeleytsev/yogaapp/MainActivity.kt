package com.andreisingeleytsev.yogaapp

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import com.andreisingeleytsev.yogaapp.ui.navigation.YogaAppNavigationGraph
import com.andreisingeleytsev.yogaapp.ui.utils.NotificationHelper

class MainActivity : ComponentActivity() {
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val lastLoginTimestamp = sharedPreferences.getLong("lastLoginTime", 100000000000)
        val currentTime = System.currentTimeMillis()

        if (currentTime - lastLoginTimestamp > TIME_THRESHOLD) {
            val notificationHelper = NotificationHelper(this)
            notificationHelper.showNotification(
                getString(R.string.missed_us),
                getString(R.string.push_title)
            )
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer?.start()
        mediaPlayer?.isLooping = true
        setContent {
            YogaAppNavigationGraph(mediaPlayer)
        }
    }
    override fun onPause() {
        super.onPause()
        val currentTimeMillis = System.currentTimeMillis()
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong("lastLoginTime", currentTimeMillis)
        editor.apply()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

const val TIME_THRESHOLD = 172800000

