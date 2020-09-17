package com.lyf.customcontrol.part1.uniteanimatorxml10

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_animator_set_translation_xml.*

class AnimatorSetTranslationXmlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_set_translation_xml)

        val animationSet =
            AnimatorInflater.loadAnimator(this, R.animator.animator_set_transition) as AnimatorSet
        animationSet.setTarget(textView)
        btn_start_anim.setOnClickListener { animationSet.start() }
        btn_cancel_anim.setOnClickListener { animationSet.cancel() }
    }
}