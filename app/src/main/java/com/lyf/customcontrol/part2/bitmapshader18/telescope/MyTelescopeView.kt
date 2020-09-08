package com.lyf.customcontrol.part2.bitmapshader18.telescope

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lyf.customcontrol.R

class MyTelescopeView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private var mDx = -1f
    private var mDy = -1f
    private var mBitmapBackground: Bitmap? = null
    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.img_scenery)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (mBitmapBackground == null) {
            mBitmapBackground = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val backgroundCanvas = Canvas(mBitmapBackground!!)
            backgroundCanvas.drawBitmap(mBitmap, null, Rect(0, 0, width, height), mPaint)
        }

        if (mDx != -1f && mDy != -1f) {
            mPaint.shader =
                BitmapShader(mBitmapBackground!!, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
            canvas?.drawCircle(mDx, mDy - 350, 300f, mPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                mDx = event?.x
                mDy = event?.y
                postInvalidate()
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                mDx = event?.x
                mDy = event?.y
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                mDx = -1f
                mDy = -1f
            }
        }
        postInvalidate()
        return super.onTouchEvent(event)
    }
}