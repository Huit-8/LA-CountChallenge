package app.aoyama.huit.countchallenge

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.aoyama.huit.countchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mSoundPool: SoundPool
    private var sound = 0
//
//    private lateinit var mSoundID: Array<Int?>
//
//
//    private val mSoundResource = arrayOf(
//        R.raw.bass_brum_sound,
//        R.raw.dog_sound
//
//    )

    var tapCount = 0


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pref:SharedPreferences = getSharedPreferences("SharedPref",Context.MODE_PRIVATE)

        val previousCount: Int = pref.getInt("COUNT",0)

        binding.previousText.text = previousCount.toString()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()
        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            // ストリーム数に応じて
            .setMaxStreams(2)
            .build()

        sound = mSoundPool.load(this, R.raw.dog_sound, 1)


        binding.tapButton.setOnClickListener {
            tapCount ++
            binding.tapTextCount.text = tapCount.toString()

            when(tapCount%2){
                0 -> binding.tapTextCount.setTextColor(Color.BLUE)
                1 -> { binding.tapTextCount.setTextColor(Color.RED)
                    mSoundPool.play(sound, 1.0f, 1.0f, 0, 0, 1.0f)
//                    if (mSoundID[0] != null){
//                        mSoundID[0]?.let { it1 -> mSoundPool.play(it1,1.0F,1.0F,0,0,1.0F) }
//                    }





                }

            }

        }
    }

//    override fun onResume() {
//        super.onResume()
//
//        val audioAttributes=AudioAttributes.Builder()
//            .setUsage(AudioAttributes.USAGE_MEDIA)
//            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//            .build()
//
//        mSoundPool = SoundPool.Builder()
//            .setAudioAttributes(audioAttributes)
//            .setMaxStreams(mSoundResource.size)
//            .build()
//
//        mSoundID = arrayOfNulls(mSoundResource.size)
//
//        for (i in mSoundResource.indices){
//            mSoundID[i] = mSoundPool.load(applicationContext,mSoundResource[i],0)
//        }
//
//
//    }

    override fun onStop() {
        super.onStop()
        val pref:SharedPreferences = getSharedPreferences("SharedPref",Context.MODE_PRIVATE)

        val previousCount: Int = tapCount

        val editor = pref.edit()
        editor.putInt("COUNT",previousCount)
        editor.apply()

    }


//    override fun onDestroy() {
//        super.onDestroy()
//
//
//
//        mSoundPool.release()
//    }
}