package com.lyf.customcontrol.part2.qqredpoint15

import android.content.Context
import android.graphics.*
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.lyf.customcontrol.R
import kotlin.math.*


class MyQqRedPointView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    FrameLayout(context, attrs, defStyleAttr) {
    private var mStartPoint: PointF = PointF(100f, 100f)
    private var mCurPoint: PointF = PointF()
    private val defaultRadius = 30f
    private var mRadius = defaultRadius
    private var mPaint: Paint = Paint()
    private var mPath: Path
    private var mTouch = false
    private var isSeparate = false
    private var isAnimStart = false

    private var alpha = 0.0
    private lateinit var mPoint0: PointF
    private lateinit var mPoint1: PointF
    private lateinit var mPoint2: PointF
    private lateinit var mPoint3: PointF
    private lateinit var mPointCenter: PointF

    private var mTipTextView: TextView
    private var exploredImageView: ImageView

    init {
        mPaint.color = Color.RED
        mPaint.style = Paint.Style.FILL

        mPath = Path()

        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        mTipTextView = TextView(context)
        mTipTextView.layoutParams = layoutParams
        mTipTextView.setBackgroundResource(R.drawable.tv_bg)
        mTipTextView.setPadding(10, 10, 10, 10)
        mTipTextView.setTextColor(Color.GREEN)
        mTipTextView.text = "99+"
        addView(mTipTextView)

        exploredImageView = ImageView(context)
        exploredImageView.layoutParams = layoutParams
        exploredImageView.setImageResource(R.drawable.tip_anim)
        exploredImageView.visibility = View.INVISIBLE
        addView(exploredImageView)
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    override fun dispatchDraw(canvas: Canvas?) {
        canvas?.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), mPaint, Canvas.ALL_SAVE_FLAG)
        if (mTouch) {
            calculateDistance()
            if (isSeparate) {
                mTipTextView.x = mCurPoint.x - mTipTextView.width / 2
                mTipTextView.y = mCurPoint.y - mTipTextView.height / 2
            } else {
                calculatePath()
                canvas?.drawCircle(mStartPoint.x, mStartPoint.y, mRadius, mPaint)
                canvas?.drawCircle(mCurPoint.x, mCurPoint.y, mRadius, mPaint)
                canvas?.drawPath(mPath, mPaint)
                mTipTextView.x = mCurPoint.x - mTipTextView.width / 2
                mTipTextView.y = mCurPoint.y - mTipTextView.height / 2
            }
        } else {
            if (isAnimStart) {
                exploredImageView.x = mCurPoint.x - mTipTextView.width / 2
                exploredImageView.y = mCurPoint.y - mTipTextView.height / 2
                exploredImageView.visibility = View.VISIBLE
                (exploredImageView.drawable as AnimationDrawable).start()

                mTipTextView.visibility = View.GONE
            } else {
                mTipTextView.x = mStartPoint.x - mTipTextView.width / 2
                mTipTextView.y = mStartPoint.y - mTipTextView.height / 2
            }
        }

        canvas?.restore()
        super.dispatchDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                //判断触摸点是否在mTipTextView中
                val rect = Rect()
                var location = IntArray(2)
                mTipTextView.getLocationOnScreen(location)
                rect.left = location[0]
                rect.top = location[1]
                rect.right = mTipTextView.width + location[0]
                rect.bottom = mTipTextView.height + location[1]
                if (rect.contains(event?.rawX.toInt(), event?.rawY.toInt())) {
                    mTouch = true
                }
            }
            MotionEvent.ACTION_UP -> {
                mTouch = false
                isAnimStart = isSeparate
            }
        }
        mCurPoint.set(event?.x!!, event?.y)
        postInvalidate()
        return true
    }

    private fun calculateDistance() {
        alpha = atan2(
            (mCurPoint.y - mStartPoint.y).toDouble(),
            (mCurPoint.x - mStartPoint.x).toDouble()
        )
        mPoint0 = PointF(
            (mStartPoint.x + mRadius * sin(alpha)).toFloat(),
            (mStartPoint.y - mRadius * cos(alpha)).toFloat()
        )
        mPoint1 = PointF(
            (mCurPoint.x + mRadius * sin(alpha)).toFloat(),
            (mCurPoint.y - mRadius * cos(alpha)).toFloat()
        )
        mPoint2 = PointF(
            (mCurPoint.x - mRadius * sin(alpha)).toFloat(),
            (mCurPoint.y + mRadius * cos(alpha)).toFloat()
        )
        mPoint3 = PointF(
            (mStartPoint.x - mRadius * sin(alpha)).toFloat(),
            (mStartPoint.y + mRadius * cos(alpha)).toFloat()
        )
        mPointCenter =
            PointF((mStartPoint.x + mCurPoint.x) / 2, (mStartPoint.y + mCurPoint.y) / 2)

        val distance =
            sqrt((mCurPoint.x - mStartPoint.x).pow(2) + (mCurPoint.y - mStartPoint.y).pow(2))
        mRadius = defaultRadius - distance / 15
        isSeparate = mRadius < 9f
    }

    private fun calculatePath() {
        calculateDistance()

        mPath.reset()
        mPath.moveTo(mPoint0.x, mPoint0.y)
        mPath.quadTo(mPointCenter.x, mPointCenter.y, mPoint1.x, mPoint1.y)
        mPath.lineTo(mPoint2.x, mPoint2.y)
        mPath.quadTo(mPointCenter.x, mPointCenter.y, mPoint3.x, mPoint3.y)
        mPath.lineTo(mPoint0.x, mPoint0.y)
    }
}