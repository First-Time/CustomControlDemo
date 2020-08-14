package com.lyf.customcontrol.part2.setxfermode11.srcin.roundcorner

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyRoundCornerView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paint = Paint()
    private var layerId = 0
    private val bitmapBg = BitmapFactory.decodeResource(resources, R.drawable.img_bg_corner)
    private val bitmapDog = BitmapFactory.decodeResource(resources, R.drawable.img_dog)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
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

        canvas?.drawBitmap(bitmapBg, null, Rect(0, 0, 600, 600), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas?.drawBitmap(bitmapDog, null, Rect(0, 0, 600, 600), paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
    }
}