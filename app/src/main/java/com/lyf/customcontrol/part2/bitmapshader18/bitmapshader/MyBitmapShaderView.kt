package com.lyf.customcontrol.part2.bitmapshader18.bitmapshader

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyBitmapShaderView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.img_dog_edge)

    init {
        mPaint.shader = BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.CLAMP)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
//        canvas?.drawRect(0f, 20f, 400f, 400f, mPaint)
    }
}