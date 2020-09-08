package com.lyf.customcontrol.part2.bitmapshadow17.encapsulation

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyShadowControlView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private var mBitmap: Bitmap
    private var mShadowBitmap: Bitmap
    private var mDx = 0
    private var mDy = 0
    private var mShadowColor: Int
    private var mRadius: Float = 0.0f

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.BitmapShadowView)
        val bitmapId = typedArray?.getResourceId(R.styleable.BitmapShadowView_src, -1)
        if (bitmapId == -1) {
            throw Exception("BitmapShadowView 需要定义Src属性,而且必须是图像")
        }
        mBitmap = BitmapFactory.decodeResource(resources, bitmapId!!)
        mDx = typedArray?.getInt(R.styleable.BitmapShadowView_shadowDx, 0)
        mDy = typedArray?.getInt(R.styleable.BitmapShadowView_shadowDy, 0)
        mShadowColor = typedArray?.getColor(R.styleable.BitmapShadowView_shadowColor, Color.BLACK)
        mRadius = typedArray?.getFloat(R.styleable.BitmapShadowView_shadowRadius, 0f)
        typedArray.recycle()

        mShadowBitmap = mBitmap.extractAlpha()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        val density = resources.displayMetrics.density
        val mWidth = (mBitmap.width / density).toInt()
        val mHeight = (mBitmap.height / density).toInt()
        setMeasuredDimension(
            if (measureWidthMode == MeasureSpec.EXACTLY) measureWidth else mWidth,
            if (measureHeightMode == MeasureSpec.EXACTLY) measureHeight else mHeight
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val density = resources.displayMetrics.density.toInt()
        val mWidth = width - mDx
        val mHeight = mWidth * height / width
        //绘制阴影
        mPaint.color = mShadowColor
        mPaint.maskFilter = BlurMaskFilter(mRadius, BlurMaskFilter.Blur.NORMAL)
        canvas?.drawBitmap(mShadowBitmap, null, Rect(mDx, mDy, mWidth, mHeight), mPaint)
        //绘制原图像
        mPaint.maskFilter = null
        canvas?.drawBitmap(mBitmap, null, Rect(0, 0, mWidth, mHeight), mPaint)
    }
}