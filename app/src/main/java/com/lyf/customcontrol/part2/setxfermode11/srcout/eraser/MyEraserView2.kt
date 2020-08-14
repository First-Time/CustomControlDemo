package com.lyf.customcontrol.part2.setxfermode11.srcout.eraser

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lyf.customcontrol.R

class MyEraserView2(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paint = Paint()
    private val paintCover = Paint()
    private var layerId = 0
    private val bitmapDog = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
    private val bitmapWidth = resources.displayMetrics.widthPixels
    private val bitmapHeight = bitmapWidth * bitmapDog.height / bitmapDog.width
    private val bitmapFinger =
        Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
    private var fingerCanvas: Canvas
    private val path = Path()
    private var preX: Float = 0f
    private var preY: Float = 0f

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        paint.isAntiAlias = true

        paintCover.isAntiAlias = true
        paintCover.style = Paint.Style.STROKE
        paintCover.alpha = 0
        paintCover.strokeCap = Paint.Cap.ROUND
        paintCover.strokeJoin = Paint.Join.ROUND
        paintCover.strokeWidth = 45f
        paintCover.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)

        //双缓冲装载画布
        fingerCanvas = Canvas(bitmapFinger)
        fingerCanvas.drawBitmap(
            bitmapDog,
            null,
            RectF(0f, 0f, bitmapWidth.toFloat(), bitmapHeight.toFloat()),
            null
        )
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
        fingerCanvas.drawPath(path, paintCover)

        //画出计算后的区域
        canvas?.drawBitmap(
            bitmapFinger,
            null,
            RectF(0f, 0f, bitmapWidth.toFloat(), bitmapHeight.toFloat()),
            paint
        )

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