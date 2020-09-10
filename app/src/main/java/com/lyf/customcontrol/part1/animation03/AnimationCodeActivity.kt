package com.lyf.customcontrol.part1.animation03

import android.os.Bundle
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_animation_code.*

class AnimationCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_code)

        //ScaleAnimation
        /*val animation = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )*/

        //AlphaAnimation
//        val animation = AlphaAnimation(0f, 1f)

        //RotateAnimation
        /*val animation = RotateAnimation(
            0f,
            720f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )*/

        //TranslateAnimation
        /*val animation = TranslateAnimation(
            Animation.ABSOLUTE,
            0f,
            Animation.ABSOLUTE,
            100f,
            Animation.ABSOLUTE,
            0f,
            Animation.ABSOLUTE,
            200f
        )*/

        //AnimationSet
        /*val animation = AnimationSet(true)
        val scaleAnimation = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        val alphaAnimation = AlphaAnimation(0f, 1f)
        val rotateAnimation = RotateAnimation(
            0f,
            720f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animation.addAnimation(scaleAnimation)
        animation.addAnimation(alphaAnimation)
        animation.addAnimation(rotateAnimation)*/

        //Interpolator
        val animation = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animation.interpolator = BounceInterpolator()

        animation.duration = 3000
        textView.animation = animation
        animation.start()
    }
}