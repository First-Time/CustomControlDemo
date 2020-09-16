package com.lyf.customcontrol.part1.objectanimator07

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_object_animator.*

class ObjectAnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        //alpha
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f)

        //rotation
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f, 0f)

        //rotationX
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "rotationX", 0f, 360f, 0f)

        //rotationY
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "rotationY", 0f, 360f, 0f)

        //translationX
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 0f, 360f, -360f, 0f)

        //translationY
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "translationY", 0f, 360f, -360f, 0f)

        //scaleX
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "scaleX", 0f, 3f, 1f)

        //scaleY
//        val objectAnimator = ObjectAnimator.ofFloat(textView, "scaleY", 0f, 3f, 1f)
        val objectAnimator = ObjectAnimator.ofInt(textView, "scaleY", 0, 3, 1)


        objectAnimator.duration = 4000

        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.end() }
    }
}