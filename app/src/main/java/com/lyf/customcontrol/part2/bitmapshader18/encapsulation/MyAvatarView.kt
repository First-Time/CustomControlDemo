package com.lyf.customcontrol.part2.bitmapshader18.encapsulation

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyAvatarView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private var mBitmap: Bitmap
    private var mBitmapShader: BitmapShader
    private var mEnumFormat = 0
    private var mRadius = 5f

    init {
        //提取自定义属性
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.AvatarView)
        val mBitmapId = typedArray?.getResourceId(R.styleable.AvatarView_avatarSrc, -1)!!
        if (mBitmapId == -1) {
            throw Exception("AvatarView 需要定义Src属性,而且必须是图像")
        }
        mBitmap = BitmapFactory.decodeResource(resources, mBitmapId)
        mEnumFormat = typedArray?.getInt(R.styleable.AvatarView_format, 0)!!
        if (mEnumFormat == 1) {
            mRadius = typedArray.getFloat(R.styleable.AvatarView_radius, 5f)
        }

        typedArray.recycle()

        mBitmapShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        val mWidth = mBitmap.width
        val mHeight = mBitmap.height
        setMeasuredDimension(
            if (measureWidthMode == MeasureSpec.EXACTLY) measureWidth else mWidth,
            if (measureHeightMode == MeasureSpec.EXACTLY) measureHeight else mHeight
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val matrix = Matrix()
        val scale = width.toFloat() / mBitmap.width
        matrix.setScale(scale, scale)

        mBitmapShader.setLocalMatrix(matrix)
        mPaint.shader = mBitmapShader

        val half = width.toFloat() / 2
        if (mEnumFormat == 0) {
            canvas?.drawCircle(half, half, half, mPaint)
        } else if (mEnumFormat == 1) {
            canvas?.drawRoundRect(
                RectF(0f, 0f, width.toFloat(), height.toFloat()),
                mRadius,
                mRadius,
                mPaint
            )
        }
    }
}