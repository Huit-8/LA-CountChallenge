package app.aoyama.huit.countchallenge

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when(position){
            0->Fragment1()
            1->Fragment2()
            2->Fragment3()
            else -> throw IllegalArgumentException()
        }
}