package com.lyf.customcontrol.part1.objectanimator07.customobjectanimator

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_point_object_animator.*

class PointObjectAnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point_object_animator)

        //使用多个values
//        val objectAnimator = ObjectAnimator.ofFloat(myPointView, "pointRadius", 0f, 400f, 200f)

        //使用一个values
        val objectAnimator = ObjectAnimator.ofFloat(myPointView, "pointRadius", 200f)
        objectAnimator.duration = 4000
        objectAnimator.interpolator = BounceInterpolator()

        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }
    }
}