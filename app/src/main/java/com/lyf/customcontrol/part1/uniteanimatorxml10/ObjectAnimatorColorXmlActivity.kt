package com.lyf.customcontrol.part1.uniteanimatorxml10

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_object_animator_color_xml.*

class ObjectAnimatorColorXmlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator_color_xml)

        val objectAnimator =
            AnimatorInflater.loadAnimator(this, R.animator.object_animator_color) as ObjectAnimator
        objectAnimator.target = textView

        btn_start_anim.setOnClickListener { objectAnimator.start() }
        btn_cancel_anim.setOnClickListener { objectAnimator.cancel() }
    }
}