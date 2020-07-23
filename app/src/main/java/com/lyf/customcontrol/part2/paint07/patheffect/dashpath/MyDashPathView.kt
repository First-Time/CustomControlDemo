package com.lyf.customcontrol.part2.paint07.patheffect.dashpath

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.lyf.customcontrol.main.generatePaint

class MyDashPathView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    private var valueAnimator: ValueAnimator = ValueAnimator.ofFloat(230f)
    private var valueAnimator2: ValueAnimator = ValueAnimator.ofFloat(180f)
    private var phase = 0f
    private var phase2 = 0f

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        valueAnimator.duration = 2000
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.addUpdateListener {
            phase = it.animatedValue as Float
            println("phase = $phase")
            postInvalidate()
        }

        valueAnimator.addPauseListener(object : Animator.AnimatorPauseListener {
            override fun onAnimationPause(animation: Animator?) {
                println("valueAnimator pause")
            }

            override fun onAnimationResume(animation: Animator?) {
                println("valueAnimator resume")
            }

        })

        valueAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                println("onAnimationRepeat")
            }

            override fun onAnimationEnd(animation: Animator?) {
                println("onAnimationEnd")
            }

            override fun onAnimationCancel(animation: Animator?) {
                println("onAnimationCancel")
            }

            override fun onAnimationStart(animation: Animator?) {
                println("onAnimationStart")
            }

        })

        valueAnimator2.duration = 2000
        valueAnimator2.interpolator = LinearInterpolator()
        valueAnimator2.repeatCount = ValueAnimator.INFINITE
        valueAnimator2.repeatMode = ValueAnimator.RESTART
        valueAnimator2.addUpdateListener {
            phase2 = it.animatedValue as Float
            postInvalidate()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)
        paint.isAntiAlias = true

        val path = Path()
        path.moveTo(100f, 600f)
        path.lineTo(400f, 100f)
        path.lineTo(700f, 900f)

        canvas?.drawPath(path, paint)

        paint.color = Color.RED
        paint.pathEffect = DashPathEffect(floatArrayOf(20f, 10f, 100f, 100f), phase)
        canvas?.translate(0f, 100f)
        canvas?.drawPath(path, paint)

        paint.color = Color.YELLOW
        paint.pathEffect = DashPathEffect(floatArrayOf(20f, 10f, 50f, 100f), phase2)
        canvas?.translate(0f, 100f)
        canvas?.drawPath(path, paint)
    }

    fun startAnim() {
        valueAnimator.start()
        valueAnimator2.start()
    }

    fun cancelAnim() {
        valueAnimator.cancel()
        valueAnimator2.cancel()
    }

    fun endAnim() {
        valueAnimator.end()
        valueAnimator2.end()
    }

    fun pauseAnim() {
        valueAnimator.pause()
        valueAnimator2.pause()
    }

    fun resumeAnim() {
        valueAnimator.resume()
        valueAnimator2.resume()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        println("onDetachedFromWindow")
        valueAnimator.cancel()
        valueAnimator2.cancel()
    }
}