package com.lyf.customcontrol.part1.valueanimator04

import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_value_animator_basic.*

class ValueAnimatorBasicActivity : AppCompatActivity() {

    private var startPosX = 0
    private var startPosY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator_basic)

        //View Animation 补间动画仅能对指定的控件做动画，并没有改变控件内部的属性值。
        /*btn_start_anim.setOnClickListener {
            val animation = TranslateAnimation(
                Animation.ABSOLUTE,
                0f,
                Animation.ABSOLUTE,
                400f,
                Animation.ABSOLUTE,
                0f,
                Animation.ABSOLUTE,
                400f
            )
            animation.duration = 1000
            animation.fillAfter = true
            textView.animation = animation
            textView.startAnimation(animation)
        }*/

        //ValueAnimator简单使用
        /*val valueAnimator = ValueAnimator.ofInt(0, 400)
        valueAnimator.duration = 2000
        valueAnimator.addUpdateListener { animator ->
            val curValue = animator.animatedValue as Int
            println("curValue = $curValue")
        }
        valueAnimator.start()*/

        //实例使用ValueAnimator
        val valueAnimator = ValueAnimator.ofInt(0, 200)
        valueAnimator.duration = 2000
        valueAnimator.addUpdateListener { animator ->
            val curValue = animator.animatedValue as Int
            textView.layout(
                startPosX + curValue,
                startPosY + curValue,
                startPosX + curValue + textView.width,
                startPosY + curValue + textView.height
            )
        }

        btn_start_anim.setOnClickListener {
            valueAnimator.start()
        }

        textView.viewTreeObserver.addOnGlobalLayoutListener {
            startPosX = textView.x.toInt()
            startPosY = textView.y.toInt()
        }
        textView.setOnClickListener { Toast.makeText(this, "clicked me", Toast.LENGTH_LONG).show() }
    }
}