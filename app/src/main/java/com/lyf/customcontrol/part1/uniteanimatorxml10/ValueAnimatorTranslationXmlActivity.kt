package com.lyf.customcontrol.part1.uniteanimatorxml10

import android.animation.AnimatorInflater
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_value_animator_translation_xml.*

class ValueAnimatorTranslationXmlActivity : AppCompatActivity() {

    var curX = 0
    var curY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator_translation_xml)

        textView.viewTreeObserver.addOnGlobalLayoutListener {
            curX = textView.x.toInt()
            curY = textView.y.toInt()
        }

        val animator =
            AnimatorInflater.loadAnimator(this, R.animator.value_animator_transition) as ValueAnimator
        animator.addUpdateListener { animation ->
            val curValue = animation.animatedValue as Int
            textView.layout(
                curX + curValue,
                curY + curValue,
                curX + curValue + textView.width,
                curY + curValue + textView.height
            )
        }

        btn_start_anim.setOnClickListener { animator.start() }
        btn_cancel_anim.setOnClickListener { animator.cancel() }
    }
}