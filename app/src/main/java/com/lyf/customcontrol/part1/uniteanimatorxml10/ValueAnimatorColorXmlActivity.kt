package com.lyf.customcontrol.part1.uniteanimatorxml10

import android.animation.AnimatorInflater
import android.animation.ValueAnimator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_value_animator_color_xml.btn_cancel_anim
import kotlinx.android.synthetic.main.activity_value_animator_color_xml.btn_start_anim
import kotlinx.android.synthetic.main.activity_value_animator_color_xml.textView

class ValueAnimatorColorXmlActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator_color_xml)

        val animator =
            AnimatorInflater.loadAnimator(this, R.animator.value_animator_color) as ValueAnimator
        animator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.setBackgroundColor(curValue)
        }
        btn_start_anim.setOnClickListener { animator.start() }
        btn_cancel_anim.setOnClickListener { animator.cancel() }
    }
}