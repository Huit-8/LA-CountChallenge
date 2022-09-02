package app.aoyama.huit.countchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import app.aoyama.huit.countchallenge.databinding.ActivityMainBinding
import app.aoyama.huit.countchallenge.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewPagerを設定する
        binding.viewPager.adapter= ViewPagerAdapter(this)
        binding.viewPager.orientation= ViewPager2.ORIENTATION_HORIZONTAL
    }
}