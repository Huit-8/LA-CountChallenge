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

    // Doggy: 定数は以下のように定義できるよ！
    //  companion object とは何か調べてみても良いかも！
    companion object {
        private const val SHARED_PREF = "SharedPref"
    }

    // Doggy: private を付ける場合と付けない場合の違いを調べてみると良さそう！
    private lateinit var mSoundPool: SoundPool
    private var sound = 0

    // Doggy: 不要なコードは削除しておくと、コードが読みやすくなるよ！
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

        // Doggy: コロンと型名の間はスペースを空けるのが通例になっているよ！
        // Doggy: コンマの後はスペースを空けるのが通例になっているよ！
        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

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
                1 -> {
                    // Doggy: 新しいブロックの始めは改行を入れられると良さそう！
                    binding.tapTextCount.setTextColor(Color.RED)
                    mSoundPool.play(sound, 1.0f, 1.0f, 0, 0, 1.0f)
//                    if (mSoundID[0] != null){
//                        mSoundID[0]?.let { it1 -> mSoundPool.play(it1,1.0F,1.0F,0,0,1.0F) }
//                    }
                    // Doggy: 不要な改行を削除するとコードがスッキリするよ！
                }

            }

        }
    }

    // Doggy: ここも不要であれば削除しよう！
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
        // Doggy: "SharedPref" という文字が2回出てくるね！
        //  文字列だとタイプミスをしたり、値を変えようとしたらすべての箇所を変更しなければならないので、
        //  定数にしておくとより良いよ！
        // val pref:SharedPreferences = getSharedPreferences("SharedPref",Context.MODE_PRIVATE) // 変更前
        val pref:SharedPreferences = getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE) // 変更後

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