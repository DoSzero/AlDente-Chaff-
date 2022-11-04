package com.ald.aldentechaff.utils

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("SuspiciousIndentation")
class MusicUtils(activity: AppCompatActivity) {

    private var mMusicPlayer: MediaPlayer? = null
    private var mSoundPool: SoundPool? = null
    //private val mSoundID: Int
    private val mVolume: Float
    private var mLoaded = false

    init {
        val audioManager = activity.getSystemService(Context.AUDIO_SERVICE) as AudioManager

        mVolume = (audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)).toFloat()/
                (audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)).toFloat()

        activity.volumeControlStream = AudioManager.STREAM_MUSIC

        val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
                SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(6).build()

            mSoundPool!!.setOnLoadCompleteListener {
                soundPool: SoundPool?, sampleId: Int, status: Int ->
                mLoaded = true
            }

        //mSoundID = mSoundPool!!.load(activity, R.raw.position, 1)
    }

    fun playSound() {
        //if (mLoaded) mSoundPool!!.play(mSoundID, mVolume, mVolume, 1, 0, 1f)
    }

    fun prepareMusicPlayer(context: Context) {
        //val mMusicPlayer = MediaPlayer.create(context.applicationContext, R.raw.somethingAudio)
        //mMusicPlayer.setVolume(.5f, .5f)
        //mMusicPlayer.isLooping = true
    }

    fun playMusic() {
        if (mMusicPlayer != null) mMusicPlayer!!.start()
    }

    fun pauseMusic() {
        if (mMusicPlayer != null && mMusicPlayer!!.isPlaying) mMusicPlayer!!.pause()
    }
}