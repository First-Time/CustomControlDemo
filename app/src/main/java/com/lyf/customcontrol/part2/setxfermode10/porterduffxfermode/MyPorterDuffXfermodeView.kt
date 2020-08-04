package com.lyf.customcontrol.part2.setxfermode10.porterduffxfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


private const val WIDTH = 500f
private const val SEPARATE = 40f
private const val HEIGHT = WIDTH

class MyPorterDuffXfermodeView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val paint = Paint()
    private var srcBitmap: Bitmap
    private var dstBitmap: Bitmap

    init {
        srcBitmap = makeSrcBitmap(WIDTH, HEIGHT)
        dstBitmap = makeDstBitmap(WIDTH, HEIGHT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //region CLEAR
        var layerId: Int =
            canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC
        canvas?.translate(0f, HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_OVER
        canvas?.translate(-(WIDTH + SEPARATE), HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_OVER
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_IN
        canvas?.translate(-(WIDTH + SEPARATE), HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_IN
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_OUT
        canvas?.translate(-(WIDTH + SEPARATE), HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_OUT
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_ATOP
        canvas?.translate(-(WIDTH + SEPARATE), HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_ATOP
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region XOR
        canvas?.translate(-(WIDTH + SEPARATE), HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.XOR)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region ADD
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.ADD)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region MULTIPLY
        canvas?.translate(-(WIDTH + SEPARATE), HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.MULTIPLY)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region SCREEN
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SCREEN)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region OVERLAY
        canvas?.translate(-(WIDTH + SEPARATE), HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.OVERLAY)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region DARKEN
        canvas?.translate(0f, HEIGHT + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DARKEN)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion

        //region LIGHTEN
        canvas?.translate(WIDTH + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.LIGHTEN)
        canvas?.drawBitmap(srcBitmap, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
        //endregion
    }

    private fun makeSrcBitmap(width: Float, height: Float): Bitmap {
        val bitmap = Bitmap.createBitmap(width.toInt(), height.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = 0x77AEF6
        paint.alpha = 0xFF
        canvas.drawRect(width / 3, height / 3, width * 19 / 20, height * 19 / 20, paint)
        return bitmap
    }

    private fun makeDstBitmap(width: Float, height: Float): Bitmap {
        val bitmap = Bitmap.createBitmap(width.toInt(), height.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = 0xF7CD67
        paint.alpha = 0xFF
        canvas.drawOval(RectF(0f, 0f, width * 3 / 4, height * 3 / 4), paint)
        return bitmap
    }
}