package com.lyf.customcontrol.part2.setxfermode10

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


private const val WIDTH = 320f
private const val SEPARATE = 60f
private const val HEIGHT = WIDTH

class MyPorterDuffXfermodeView2(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private var layerId = 0
    private val paint = Paint()
    private var srcBitmap: Bitmap
    private var dstBitmap: Bitmap
    private var fontMetrics = paint.fontMetrics
    private var textWidth = 0f
    private var textHeight = 0f

    init {
        paint.textSize = 40f
        srcBitmap = makeSrcBitmap(
            WIDTH,
            HEIGHT
        )
        dstBitmap = makeDstBitmap(
            WIDTH,
            HEIGHT
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //region CLEAR
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!
        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("CLEAR")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("CLEAR", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC
        canvas?.translate(0f, HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("SRC")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("SRC", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("DST")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("DST", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_OVER
        canvas?.translate(-(WIDTH * 3 / 2 + SEPARATE), HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("SRC_OVER")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("SRC_OVER", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_OVER
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("DST_OVER")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("DST_OVER", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_IN
        canvas?.translate(-(WIDTH * 3 / 2 + SEPARATE), HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("SRC_IN")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("SRC_IN", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_IN
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("DST_IN")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("DST_IN", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_OUT
        canvas?.translate(-(WIDTH * 3 / 2 + SEPARATE), HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("SRC_OUT")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("SRC_OUT", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_OUT
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("DST_OUT")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("DST_OUT", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region SRC_ATOP
        canvas?.translate(-(WIDTH * 3 / 2 + SEPARATE), HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("SRC_ATOP")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("SRC_ATOP", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region DST_ATOP
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("DST_ATOP")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("DST_ATOP", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region XOR
        canvas?.translate(-(WIDTH * 3 / 2 + SEPARATE), HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.XOR)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("XOR")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("XOR", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region ADD
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.ADD)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("ADD")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("ADD", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region MULTIPLY
        canvas?.translate(-(WIDTH * 3 / 2 + SEPARATE), HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.MULTIPLY)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("MULTIPLY")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("MULTIPLY", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region SCREEN
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SCREEN)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("SCREEN")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("SCREEN", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region OVERLAY
        canvas?.translate(-(WIDTH * 3 / 2 + SEPARATE), HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.OVERLAY)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("OVERLAY")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("OVERLAY", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region DARKEN
        canvas?.translate(0f, HEIGHT * 3 / 2 + SEPARATE)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DARKEN)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("DARKEN")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("DARKEN", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion

        //region LIGHTEN
        canvas?.translate(WIDTH * 3 / 2 + SEPARATE, 0f)
        layerId = canvas?.saveLayer(0f, 0f, WIDTH * 2, HEIGHT * 2, paint, Canvas.ALL_SAVE_FLAG)!!

        canvas?.drawBitmap(dstBitmap, 0f, 0f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.LIGHTEN)
        canvas?.drawBitmap(srcBitmap, WIDTH / 2, HEIGHT / 2, paint)
        paint.xfermode = null

        textWidth = paint.measureText("LIGHTEN")
        textHeight = fontMetrics.bottom - fontMetrics.top
        canvas?.drawText("LIGHTEN", (WIDTH - textWidth) / 2, HEIGHT / 2, paint)

        canvas?.restoreToCount(layerId)
        //endregion
    }

    private fun makeSrcBitmap(width: Float, height: Float): Bitmap {
        val bitmap = Bitmap.createBitmap(width.toInt(), height.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = 0x77AEF6
        paint.alpha = 0xFF
        canvas.drawRect(0f, 0f, width, height, paint)
        return bitmap
    }

    private fun makeDstBitmap(width: Float, height: Float): Bitmap {
        val bitmap = Bitmap.createBitmap(width.toInt(), height.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = 0xF7CD67
        paint.alpha = 0xFF
        canvas.drawOval(RectF(0f, 0f, width, height), paint)
        return bitmap
    }
}