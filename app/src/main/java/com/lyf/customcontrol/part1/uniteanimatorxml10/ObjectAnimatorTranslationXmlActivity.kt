package com.lyf.customcontrol.part1.uniteanimatorxml10

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_object_animator_translation_xml.*

class ObjectAnimatorTranslationXmlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator_translation_xml)

        val animator =
            AnimatorInflater.loadAnimator(
                this,
                R.animator.object_animator_translation
            ) as ObjectAnimator
        animator.target = textView

        btn_start_anim.setOnClickListener { animator.start() }
        btn_cancel_anim.setOnClickListener { animator.cancel() }
    }
}