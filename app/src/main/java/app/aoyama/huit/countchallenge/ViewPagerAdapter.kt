package app.aoyama.huit.countchallenge

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// Doggy: ViewPagerAdapter だと、どの ViewPager の adapter か分からないので、
//  TitleViewPagerAdapter や TutorialViewPagerAdapter のような命名がより良さそう！
class ViewPagerAdapter (fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int = 3

    // Doggy: このあたりも良い感じにスペースを入れられると読みやすさ（可読性）が上がりそう！
    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> Fragment1()
            // Doggy: Fragment2 で定義された newInstance を使用して Fragment2 を生成すると以下のようになる！
            1 -> Fragment2.newInstance(param1 = "引数1つ目", param2 = "引数2つ目")
            // 1 -> Fragment2()
            2 -> Fragment3()
            else -> throw IllegalArgumentException()
        }
}
