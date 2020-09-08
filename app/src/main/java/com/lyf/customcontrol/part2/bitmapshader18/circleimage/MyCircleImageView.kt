package com.lyf.customcontrol.part2.bitmapshader18.circleimage

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyCircleImageView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val strokePaint = Paint()
    private val mPaint = Paint()
    private val strokeWidth = 20f
    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.img_avatar)
    private val mBitmapShader = BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var radius = width / 2f

        val matrix = Matrix()
        val scale = width.toFloat() / mBitmap.width
        matrix.setScale(scale, scale)
        mBitmapShader.setLocalMatrix(matrix)
        mPaint.shader = mBitmapShader
        canvas?.drawCircle(radius, radius, radius - strokeWidth, mPaint)

        strokePaint.color = Color.RED
        strokePaint.style = Paint.Style.STROKE
        strokePaint.strokeWidth = strokeWidth
        canvas?.drawCircle(radius, radius, radius - strokeWidth, strokePaint)
    }
}