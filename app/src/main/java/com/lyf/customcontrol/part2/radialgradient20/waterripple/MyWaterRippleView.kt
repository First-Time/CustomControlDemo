package com.lyf.customcontrol.part2.radialgradient20.waterripple

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.widget.AppCompatButton

class MyWaterRippleView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    AppCompatButton(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private lateinit var mRadialGradient: RadialGradient
    private var mDx = -1f
    private var mDy = -1f
    private val defaultRadius = 50f
    private var mCurRadius = 0f
    private var mObjectAnimator: ObjectAnimator? = null

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    private fun setRadius(radius: Float) {
        mCurRadius = radius
        if (mCurRadius > 0) {
            mRadialGradient = RadialGradient(mDx, mDy, mCurRadius, 0x00FFFFFF.toInt(), 0xFF58FAAC.toInt(), Shader.TileMode.CLAMP)
            mPaint.shader = mRadialGradient
        }
        postInvalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (mDx != event?.x || mDy != event.y) {
            mDx = event?.x!!
            mDy = event?.y!!
            setRadius(defaultRadius)
        }
        if (event.action == MotionEvent.ACTION_DOWN) {
            return true
        } else if (event.action == MotionEvent.ACTION_UP) {
            if (mObjectAnimator != null && mObjectAnimator?.isRunning!!) {
                mObjectAnimator?.cancel()
            }

            if (mObjectAnimator == null) {
                mObjectAnimator =
                    ObjectAnimator.ofFloat(this, "radius", defaultRadius, width.toFloat())
            }
            mObjectAnimator?.duration = 500
            mObjectAnimator?.interpolator = AccelerateInterpolator()
            mObjectAnimator?.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    setRadius(0f)
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })
            mObjectAnimator?.start()
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(mDx, mDy, mCurRadius, mPaint)
    }
}