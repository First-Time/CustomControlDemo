package com.lyf.customcontrol.part1.animation01

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        //scale
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_scale)

        //alpha
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_alpha)

        //rotate
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_rotate)

        //translate
//        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_translate)

        //set
        val animation = AnimationUtils.loadAnimation(this, R.anim.animation_set)

        textView01.startAnimation(animation)
    }
}