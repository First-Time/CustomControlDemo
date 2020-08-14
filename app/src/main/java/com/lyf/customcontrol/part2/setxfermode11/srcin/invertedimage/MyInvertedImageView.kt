package com.lyf.customcontrol.part2.setxfermode11.srcin.invertedimage

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyInvertedImageView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paint = Paint()
    private var layerId = 0
    private val bitmapInverted = BitmapFactory.decodeResource(resources, R.drawable.img_bg_inverted)
    private val bitmapDog = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
    private var bitmapInvertedDog: Bitmap

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        val matrix = Matrix()
        matrix.setScale(1f, -1f)
        bitmapInvertedDog =
            Bitmap.createBitmap(bitmapDog, 0, 0, bitmapDog.width, bitmapDog.height, matrix, true)
    }

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

        canvas?.drawBitmap(bitmapDog, null, Rect(0, 0, 600, 600), paint)
        canvas?.translate(0f, 600f)
        canvas?.drawBitmap(bitmapInverted, null, Rect(0, 0, 600, 600), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas?.drawBitmap(bitmapInvertedDog, null, Rect(0, 0, 600, 600), paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
    }
}