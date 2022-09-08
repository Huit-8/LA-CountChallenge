package app.aoyama.huit.countchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// Doggy: せっかくなので、 Fragment で自動生成されるコードに、
//  補足でコメントを書いてみたので、ぜひ読んでみよう！

// Doggy: Fragment2 に渡す値のキー（SharedPreferences や Intent の putExtra/getXXExtra と同様）
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment2 : Fragment() {
    // Doggy: Fragment2 に、 param1, param2 という String 型の変数を用意する。
    //  Kotlin は null を基本的に使わない言語なので、
    //  デフォルトで生成されるコードとは言え、この変数の定義はあまり真似したくない！
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Doggy: param1, param2 を、 Fragment2 を生成した時に渡される値で初期化する。
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Doggy: layout ファイル（R.layout.fragment_2） を Fragment2 で使用できるようにする。
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    // Doggy: companion object について調べてみよう！（応用）
    //  よく分からなかったら、オブジェクトやクラス、インスタンスについて調べてみよう！
    companion object {
        // Doggy: @JvmStatic について調べてみよう！（応用）
        //  よく分からなかったら、アノテーションについて調べてみよう！
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                // Doggy: Fragment を生成するときに ARG_PARAM1, ARG_PARAM2 というキーで値を渡す。
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}