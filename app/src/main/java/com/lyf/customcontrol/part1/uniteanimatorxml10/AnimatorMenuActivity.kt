package com.lyf.customcontrol.part1.uniteanimatorxml10

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_animator_menu.*
import kotlin.math.cos
import kotlin.math.sin

class AnimatorMenuActivity : AppCompatActivity(), View.OnClickListener {

    private var mIsMenuOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_menu)

        btn_menu.setOnClickListener(this)
        btn_menu_item_0.setOnClickListener(this)
        btn_menu_item_1.setOnClickListener(this)
        btn_menu_item_2.setOnClickListener(this)
        btn_menu_item_3.setOnClickListener(this)
        btn_menu_item_4.setOnClickListener(this)
    }

    /**
     * 执行展示菜单动画
     */
    private fun doAnimatorOpen(view: View, index: Int, total: Int, radius: Float) {
        if (view.visibility != View.VISIBLE) {
            view.visibility = View.VISIBLE
        }

        val radian = Math.toRadians(90.0) / (total - 1) * index
        val translationX = -radius * sin(radian).toFloat()
        val translationY = -radius * cos(radian).toFloat()
        println("translationX = $translationX translationY = $translationY")

        val animatorSet = AnimatorSet()
        animatorSet.duration = 300L
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(view, "translationX", 0f, translationX),
            ObjectAnimator.ofFloat(view, "translationY", 0f, translationY),
            ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
            ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        )
        animatorSet.start()
    }

    /**
     * 执行关闭菜单动画
     */
    private fun doAnimatorClose(view: View, index: Int, total: Int, radius: Float) {
        if (view.visibility != View.VISIBLE) {
            view.visibility = View.VISIBLE
        }

        val radian = Math.toRadians(90.0) / (total - 1) * index
        val translationX = -(radius * sin(radian)).toFloat()
        val translationY = -(radius * cos(radian)).toFloat()

        val animatorSet = AnimatorSet()
        animatorSet.duration = 300L
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(view, "translationX", translationX, 0f),
            ObjectAnimator.ofFloat(view, "translationY", translationY, 0f),
            ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
            ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
            ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        )
        animatorSet.start()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_menu -> {
                if (mIsMenuOpen) {
                    mIsMenuOpen = false
                    doAnimatorClose(btn_menu_item_0, 0, 5, 500f)
                    doAnimatorClose(btn_menu_item_1, 1, 5, 500f)
                    doAnimatorClose(btn_menu_item_2, 2, 5, 500f)
                    doAnimatorClose(btn_menu_item_3, 3, 5, 500f)
                    doAnimatorClose(btn_menu_item_4, 4, 5, 500f)
                } else {
                    mIsMenuOpen = true
                    doAnimatorOpen(btn_menu_item_0, 0, 5, 500f)
                    doAnimatorOpen(btn_menu_item_1, 1, 5, 500f)
                    doAnimatorOpen(btn_menu_item_2, 2, 5, 500f)
                    doAnimatorOpen(btn_menu_item_3, 3, 5, 500f)
                    doAnimatorOpen(btn_menu_item_4, 4, 5, 500f)
                }
            }
            R.id.btn_menu_item_0 -> {
                Toast.makeText(this@AnimatorMenuActivity, "您点击了菜单项 0", Toast.LENGTH_LONG).show()
            }
            R.id.btn_menu_item_1 -> {
                Toast.makeText(this@AnimatorMenuActivity, "您点击了菜单项 1", Toast.LENGTH_LONG).show()
            }
            R.id.btn_menu_item_2 -> {
                Toast.makeText(this@AnimatorMenuActivity, "您点击了菜单项 2", Toast.LENGTH_LONG).show()
            }
            R.id.btn_menu_item_3 -> {
                Toast.makeText(this@AnimatorMenuActivity, "您点击了菜单项 3", Toast.LENGTH_LONG).show()
            }
            R.id.btn_menu_item_4 -> {
                Toast.makeText(this@AnimatorMenuActivity, "您点击了菜单项 4", Toast.LENGTH_LONG).show()
            }
        }
    }
}