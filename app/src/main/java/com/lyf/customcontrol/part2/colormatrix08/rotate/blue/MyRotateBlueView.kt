package com.lyf.customcontrol.part2.colormatrix08.rotate.blue

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class MyRotateBlueView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val paint = Paint()
    private lateinit var bitmap: Bitmap
    private var angle: Double = 0.0
    private var cosAngle: Float = cos(angle / 180 * PI).toFloat()
    private var sinAngle: Float = sin(angle / 180 * PI).toFloat()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
        paint.isAntiAlias = true
        paint.colorFilter = null

        //绘制原始位图
        canvas?.drawBitmap(
            bitmap,
            null,
            RectF(0f, 0f, 500f, 500f * bitmap.height / bitmap.width),
            paint
        )

        canvas?.translate(550f, 0f)

        //生成色彩矩阵
        val colorMatrix = ColorMatrix(
            floatArrayOf(
                cosAngle, sinAngle, 0f, 0f, 0f,
                -sinAngle, cosAngle, 0f, 0f, 0f,
                0f, 0f, 1f, 0f, 0f,
                0f, 0f, 0f, 1f, 0f,
                0f, 0f, 0f, 0f, 1f
            )
        )
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)

        canvas?.drawBitmap(
            bitmap,
            null,
            RectF(0f, 0f, 500f, 500f * bitmap.height / bitmap.width),
            paint
        )
    }

    fun postInvalidate(angle: Int) {
        this.angle = angle.toDouble()
        this.cosAngle = cos(this.angle / 180 * PI).toFloat()
        this.sinAngle = sin(this.angle / 180 * PI).toFloat()
        postInvalidate()
    }
}