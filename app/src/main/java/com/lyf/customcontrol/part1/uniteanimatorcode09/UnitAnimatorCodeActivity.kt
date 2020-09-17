package com.lyf.customcontrol.part1.uniteanimatorcode09

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnCancel
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnRepeat
import androidx.core.animation.doOnStart
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_unit_animator_code.*

class UnitAnimatorCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_animator_code)

        //顺序执行所有动画————playSequentially
        /*val objectAnimator11 = ObjectAnimator.ofInt(
            textView1,
            "backgroundColor",
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffff00ff.toInt()
        )
        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(objectAnimator11, objectAnimator12, objectAnimator21)
        animatorSet.duration = 3000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //同时执行所有动画————playTogether
        /*val objectAnimator11 = ObjectAnimator.ofInt(
            textView1,
            "backgroundColor",
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffff00ff.toInt()
        )
        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(objectAnimator11, objectAnimator12, objectAnimator21)
        animatorSet.duration = 3000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //同时执行所有动画————playTogether————设置延迟
        /*val objectAnimator11 = ObjectAnimator.ofInt(
            textView1,
            "backgroundColor",
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffff00ff.toInt()
        )
        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)
        objectAnimator12.startDelay = 2000
        objectAnimator12.repeatCount = ObjectAnimator.INFINITE

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)
        objectAnimator21.startDelay = 2000

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(objectAnimator11, objectAnimator12, objectAnimator21)
        animatorSet.duration = 2000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //顺序执行所有动画————playSequentially————设置延迟
        /*val objectAnimator11 = ObjectAnimator.ofInt(
            textView1,
            "backgroundColor",
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffff00ff.toInt()
        )
        objectAnimator11.startDelay = 2000

        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)
        objectAnimator12.repeatCount = ObjectAnimator.INFINITE

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(objectAnimator11, objectAnimator12, objectAnimator21)
        animatorSet.duration = 2000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //设置无限循环动画
        /*val objectAnimator11 = ObjectAnimator.ofInt(
            textView1,
            "backgroundColor",
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffff00ff.toInt()
        )
        objectAnimator11.repeatCount = ObjectAnimator.INFINITE

        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)
        objectAnimator12.repeatCount = ObjectAnimator.INFINITE

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)
        objectAnimator21.repeatCount = ObjectAnimator.INFINITE

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(objectAnimator11, objectAnimator12, objectAnimator21)
        animatorSet.duration = 2000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //自由设置动画顺序————AnimatorSet.Builder
        /*val objectAnimator11 = ObjectAnimator.ofInt(
            textView1,
            "backgroundColor",
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffff00ff.toInt()
        )

        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)

        val animatorSet = AnimatorSet()
        val builder = animatorSet.play(objectAnimator11)
        builder.with(objectAnimator12)
        animatorSet.duration = 2000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //自由设置动画顺序————AnimatorSet.Builder（先11，后12、21）、监听AnimatorSet状态————addListener
        /*val objectAnimator11 = ObjectAnimator.ofInt(
            textView1,
            "backgroundColor",
            0xffff00ff.toInt(),
            0xffffff00.toInt(),
            0xffff00ff.toInt()
        )

        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)
        objectAnimator21.repeatCount = ObjectAnimator.INFINITE

        val animatorSet = AnimatorSet()
        animatorSet.play(objectAnimator12).with(objectAnimator21).after(objectAnimator11)
        animatorSet.duration = 2000

        *//*animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                println("animator onAnimationRepeat")
            }

            override fun onAnimationEnd(animation: Animator?) {
                println("animator onAnimationEnd")
            }

            override fun onAnimationCancel(animation: Animator?) {
                println("animator onAnimationCancel")
            }

            override fun onAnimationStart(animation: Animator?) {
                println("animator onAnimationStart")
            }

        })*//*

        animatorSet.doOnStart { println("animator onAnimationStart") }
        animatorSet.doOnRepeat { println("animator onAnimationRepeat") }
        animatorSet.doOnCancel { println("animator onAnimationCancel") }
        animatorSet.doOnEnd { println("animator onAnimationEnd") }

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //setStartDelay（setStartDelay函数不会覆盖单个动画的延时，而且仅针对性的延长AnimatorSet的激活时间，单个动画的所设置的setStartDelay仍对单个动画起作用。）
        /*val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)
        objectAnimator21.startDelay = 2000

        val animatorSet = AnimatorSet()
        animatorSet.play(objectAnimator12).with(objectAnimator21)
        animatorSet.duration = 2000
        animatorSet.startDelay = 2000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //setStartDelay（setStartDelay函数不会覆盖单个动画的延时，而且仅针对性的延长AnimatorSet的激活时间，单个动画的所设置的setStartDelay仍对单个动画起作用。）
        //交换顺序之后效果与上边一样
        /*val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)
        objectAnimator21.startDelay = 2000

        val animatorSet = AnimatorSet()
        animatorSet.play(objectAnimator21).with(objectAnimator12)
        animatorSet.startDelay = 2000
        animatorSet.duration = 2000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }*/

        //setStartDelay（setStartDelay函数不会覆盖单个动画的延时，而且仅针对性的延长AnimatorSet的激活时间，单个动画的所设置的setStartDelay仍对单个动画起作用。）
        //延迟4000ms开始执行动画（交换顺序也一样）
        val objectAnimator12 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 300f, 0f)
        objectAnimator12.startDelay = 2000

        val objectAnimator21 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 300f, 0f)
        objectAnimator21.startDelay = 2000

        val animatorSet = AnimatorSet()
        animatorSet.play(objectAnimator12).with(objectAnimator21)
//        animatorSet.play(objectAnimator21).with(objectAnimator12)
        animatorSet.startDelay = 2000
        animatorSet.duration = 2000

        btn_start_anim.setOnClickListener { animatorSet.start() }
        btn_cancel_anim.setOnClickListener { animatorSet.cancel() }
    }
}