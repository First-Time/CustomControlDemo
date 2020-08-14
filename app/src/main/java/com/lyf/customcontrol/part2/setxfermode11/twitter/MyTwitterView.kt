package com.lyf.customcontrol.part2.setxfermode11.twitter

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyTwitterView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private var layerId: Int = 0
    private val paint = Paint()
    private val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.img_bird_1)
    private val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.img_bird_2)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.isAntiAlias = true

        layerId = canvas?.saveLayer(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            null,
            Canvas.ALL_SAVE_FLAG
        )!!
        canvas?.drawBitmap(bitmap2, 0f, 0f, paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.MULTIPLY)
        canvas?.drawBitmap(bitmap1, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
    }
}