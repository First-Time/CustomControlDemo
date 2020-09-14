package com.lyf.customcontrol.part1.interpolator02

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_interpolator.*

class InterpolatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpolator)

        //AccelerateInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_accelerate)

        //DecelerateInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_decelerate)

        //AcceleratorDecelerateInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_accelerate_decelerate)

        //BounceInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_bounce)

        //CycleInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_cycle)

        //LinearInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_linear)

        //AnticipateInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_anticipate)

        //OvershootInterpolator
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_overshoot)

        //AnticipateOvershootInterpolator
        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_anticipate_overshoot)

        textView.animation = animation
        textView.startAnimation(animation)
    }
}