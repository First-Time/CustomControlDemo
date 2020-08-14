package com.lyf.customcontrol.part2.setxfermode11.srcout.eraser

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lyf.customcontrol.R

class MyEraserView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paint = Paint()
    private var layerId = 0
    private val bitmapDog = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
    private val bitmapWidth = resources.displayMetrics.widthPixels
    private val bitmapHeight = bitmapWidth * bitmapDog.height / bitmapDog.width
    private val bitmapFinger =
        Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
    private val path = Path()
    private var preX: Float = 0f
    private var preY: Float = 0f

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 30f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        layerId = canvas?.saveLayer(
            0f,
            0f,
            bitmapWidth.toFloat(),
            bitmapHeight.toFloat(),
            null,
            Canvas.ALL_SAVE_FLAG
        )!!

        //先把手指轨迹画到目标Bitmap上
        val c = Canvas(bitmapFinger)
        c.drawPath(path, paint)

        //然后把目标图像画到画布上
        canvas?.drawBitmap(
            bitmapFinger,
            null,
            RectF(0f, 0f, bitmapWidth.toFloat(), bitmapHeight.toFloat()),
            paint
        )

        //计算源图像区域
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        canvas?.drawBitmap(
            bitmapDog,
            null,
            RectF(0f, 0f, bitmapWidth.toFloat(), bitmapHeight.toFloat()),
            paint
        )

        paint.xfermode = null

        canvas?.restoreToCount(layerId)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(event.x, event.y)
                preX = event.x
                preY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = (preX + event.x) / 2
                val endY = (preY + event.y) / 2
                path.quadTo(preX, preY, endX, endY)
                preX = event.x
                preY = event.y
            }
        }
        postInvalidate()
        return true
    }
}