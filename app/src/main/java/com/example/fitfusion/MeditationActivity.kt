package com.example.fitfusion

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.TimeUnit

class MeditationActivity : AppCompatActivity() {
            private lateinit var timerTextView: TextView
            private lateinit var mediaPlayer: MediaPlayer
            private var countDownTimer: CountDownTimer? = null

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_meditation)

                timerTextView = findViewById(R.id.timerTextView)
                mediaPlayer = MediaPlayer.create(this, R.raw.notification_sound)

                findViewById<Button>(R.id.btn1min).setOnClickListener { startTimer(1) }
                findViewById<Button>(R.id.btn3min).setOnClickListener { startTimer(3) }
                findViewById<Button>(R.id.btn5min).setOnClickListener { startTimer(5) }
                findViewById<Button>(R.id.btn7min).setOnClickListener { startTimer(7) }
                findViewById<Button>(R.id.btn10min).setOnClickListener { startTimer(10) }
            }

            private fun startTimer(minutes: Int) {
                countDownTimer?.cancel()
                val durationInMillis = minutes * 60 * 1000L

                countDownTimer = object : CountDownTimer(durationInMillis, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val formattedTime = String.format(
                            "%02d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                        )
                        timerTextView.text = formattedTime
                    }

                    override fun onFinish() {
                        timerTextView.text = "00:00"
                        mediaPlayer.start()
                    }
                }.start()
            }

            override fun onDestroy() {
                countDownTimer?.cancel()
                mediaPlayer.release()
                super.onDestroy()
            }
        }