package com.lyf.customcontrol.part1.valueanimator05

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_value_animator_interpolator.*

class ValueAnimatorInterpolatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator_interpolator)

        //使用插值器
        /*val valueAnimator = ValueAnimator.ofInt(0, 600)
        valueAnimator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.layout(
                curValue,
                curValue,
                curValue + textView.width,
                curValue + textView.height
            )
        }
        valueAnimator.duration = 2000
        valueAnimator.interpolator = AccelerateInterpolator()
        valueAnimator.start()*/

        //自定义插值器
        /*val valueAnimator = ValueAnimator.ofInt(0, 600)
        valueAnimator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.layout(
                curValue,
                curValue,
                curValue + textView.width,
                curValue + textView.height
            )
        }
        valueAnimator.duration = 2000
        valueAnimator.interpolator = MyInterpolator()
        valueAnimator.start()*/

        //使用Evaluator
        /*val valueAnimator = ValueAnimator.ofInt(0, 600)
        valueAnimator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.layout(
                curValue,
                curValue,
                curValue + textView.width,
                curValue + textView.height
            )
        }
        valueAnimator.duration = 2000
        valueAnimator.setEvaluator(IntEvaluator())
        valueAnimator.interpolator = MyInterpolator()
        valueAnimator.start()*/

        //自定义Evaluator
        /*val valueAnimator = ValueAnimator.ofInt(0, 600)
        valueAnimator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.layout(
                curValue,
                curValue,
                curValue + textView.width,
                curValue + textView.height
            )
        }
        valueAnimator.duration = 2000
        valueAnimator.setEvaluator(MyEvaluator())
        valueAnimator.start()*/

        //倒序Evaluator
        /*val valueAnimator = ValueAnimator.ofInt(0, 600)
        valueAnimator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.layout(
                curValue,
                curValue,
                curValue + textView.width,
                curValue + textView.height
            )
        }
        valueAnimator.duration = 2000
        valueAnimator.setEvaluator(ReverseEvaluator())
        valueAnimator.start()*/

        //ArgbEvaluator
        val valueAnimator = ValueAnimator.ofInt(0xffffff00.toInt(), 0xff0000ff.toInt())
        valueAnimator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.setBackgroundColor(curValue)
        }
        valueAnimator.duration = 2000
        valueAnimator.setEvaluator(ArgbEvaluator())
        valueAnimator.start()
    }
}