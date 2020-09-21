package com.lyf.customcontrol.part1.animatelayoutchanges12

import android.animation.Keyframe
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_animate_layout_changes.*

class AnimateLayoutChangesActivity : AppCompatActivity() {
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animate_layout_changes)

        //自定义动画效果
        val layoutTransition = LayoutTransition()
        layoutTransition.setDuration(1000)
        val appearAnimator = ObjectAnimator.ofFloat(linearLayout, "rotationY", 0f, 79f, 0f)
        val disappearAnimator = ObjectAnimator.ofFloat(linearLayout, "rotationX", 0f, 79f)

        val leftHolder = PropertyValuesHolder.ofInt("left", 0, 50, 0)
        val topHolder = PropertyValuesHolder.ofInt("top", 1, 1)
        val scaleHolder = PropertyValuesHolder.ofFloat("scaleX", 1f, 3f, 1f)
        val changeAppearAnimator =
            ObjectAnimator.ofPropertyValuesHolder(linearLayout, leftHolder, topHolder, scaleHolder)

        val leftOut = PropertyValuesHolder.ofInt("left", 0, 0)
        val topOut = PropertyValuesHolder.ofInt("top", 0, 0)
        val keyFrame0 = Keyframe.ofFloat(0f, 0f)
        val keyFrame1 = Keyframe.ofFloat(0.1f, -20f)
        val keyFrame2 = Keyframe.ofFloat(0.2f, 20f)
        val keyFrame3 = Keyframe.ofFloat(0.3f, -20f)
        val keyFrame4 = Keyframe.ofFloat(0.4f, 20f)
        val keyFrame5 = Keyframe.ofFloat(0.5f, -20f)
        val keyFrame6 = Keyframe.ofFloat(0.6f, 20f)
        val keyFrame7 = Keyframe.ofFloat(0.7f, -20f)
        val keyFrame8 = Keyframe.ofFloat(0.8f, 20f)
        val keyFrame9 = Keyframe.ofFloat(0.9f, -20f)
        val keyFrame10 = Keyframe.ofFloat(1.0f, 0f)
        val changeDisappearHolder = PropertyValuesHolder.ofKeyframe(
            "rotation",
            keyFrame0,
            keyFrame1,
            keyFrame2,
            keyFrame3,
            keyFrame4,
            keyFrame5,
            keyFrame6,
            keyFrame7,
            keyFrame8,
            keyFrame9,
            keyFrame10
        )
        val changeDisappearAnimator =
            ObjectAnimator.ofPropertyValuesHolder(
                linearLayout,
                leftOut,
                topOut,
                changeDisappearHolder
            )

        layoutTransition.setAnimator(LayoutTransition.APPEARING, appearAnimator)
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, disappearAnimator)
        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeAppearAnimator)
        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeDisappearAnimator)

        layoutTransition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 300L)
        layoutTransition.addTransitionListener(object : LayoutTransition.TransitionListener {
            override fun startTransition(
                transition: LayoutTransition?,
                container: ViewGroup?,
                view: View?,
                transitionType: Int
            ) {
                println("startTransition：transitionType: $transitionType container: ${container!!::class.java.name} childCount: ${container?.childCount} view: ${view!!::class.java.name}")
            }

            override fun endTransition(
                transition: LayoutTransition?,
                container: ViewGroup?,
                view: View?,
                transitionType: Int
            ) {
                println("endTransition：transitionType: $transitionType container: ${container!!::class.java.name} childCount: ${container?.childCount} view: ${view!!::class.java.name}")
            }

        })
        linearLayout.layoutTransition = layoutTransition

        btn_add.setOnClickListener {
            if (!layoutTransition.isRunning) {
                val button = AppCompatButton(this)
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                button.layoutParams = layoutParams
                button.text = "button ${i++}"
                linearLayout.addView(button, 0)
            }
        }
        btn_remove.setOnClickListener {
            if (!layoutTransition.isRunning) {
                if (i > 0) {
                    linearLayout.removeViewAt(0)
                    i--
                }
            }
        }
    }
}