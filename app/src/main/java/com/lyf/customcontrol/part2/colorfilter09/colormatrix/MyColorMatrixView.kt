package com.lyf.customcontrol.part2.colorfilter09.colormatrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyColorMatrixView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val paint = Paint()
    private lateinit var bitmap: Bitmap

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
        paint.isAntiAlias = true
        paint.colorFilter = null

        canvas?.drawBitmap(bitmap, null, Rect(0, 0, 500, 500 * bitmap.height / bitmap.width), paint)

        canvas?.translate(550f, 0f)

        val colorMatrix = ColorMatrix(
            floatArrayOf(
                1 / 2f, 1 / 2f, 1 / 2f, 0f, 0f,
                1 / 3f, 1 / 3f, 1 / 3f, 0f, 0f,
                1 / 4f, 1 / 4f, 1 / 4f, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
        )
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, 500, 500 * bitmap.height / bitmap.width), paint)
    }
}