package com.lyf.customcontrol.part1.valueanimator06

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_value_animator_of_object.*

class ValueAnimatorOfObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator_of_object)

        val valueAnimator = ValueAnimator.ofObject(CharEvaluator(), 'A', 'Z')
        valueAnimator.duration = 10000
        valueAnimator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Char
            textView.text = curValue.toString()
        }
        valueAnimator.interpolator = AccelerateInterpolator()
        valueAnimator.start()
    }
}