package com.lyf.customcontrol.part2.colorfilter09.lighting

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lyf.customcontrol.R

class MyLightingView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    val paint = Paint()
    val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_blue)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.isAntiAlias = true
//        paint.colorFilter = null

        canvas?.drawBitmap(bitmap, null, Rect(0, 0, 500, 500 * bitmap.height / bitmap.width), paint)

        setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val lightingColorFilter = LightingColorFilter(0xffffff, 0x0000f0)
                    paint.colorFilter = lightingColorFilter
                    invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    paint.colorFilter = null
                    invalidate()
                }
            }
            true
        }

        canvas?.translate(550f, 0f)

        val redLightingColorFilter = LightingColorFilter(0xff0000, 0)
        paint.colorFilter = redLightingColorFilter
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, 500, 500 * bitmap.height / bitmap.width), paint)

        canvas?.translate(-550f, 500f * bitmap.height / bitmap.width + 50f)

        val greenLightingColorFilter = LightingColorFilter(0x00ff00, 0)
        paint.colorFilter = greenLightingColorFilter
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, 500, 500 * bitmap.height / bitmap.width), paint)

        canvas?.translate(550f, 0f)

        val blueLightingColorFilter = LightingColorFilter(0x0000ff, 0)
        paint.colorFilter = blueLightingColorFilter
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, 500, 500 * bitmap.height / bitmap.width), paint)
    }
}