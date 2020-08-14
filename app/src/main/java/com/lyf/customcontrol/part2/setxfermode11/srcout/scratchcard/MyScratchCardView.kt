package com.lyf.customcontrol.part2.setxfermode11.srcout.scratchcard

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.lyf.customcontrol.R

class MyScratchCardView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paintLottery = Paint()
    private val paintCover = Paint()
    private val bitmapLottery = BitmapFactory.decodeResource(resources, R.drawable.img_lottery)
    private val bitmapCover = BitmapFactory.decodeResource(resources, R.drawable.img_cover)
    private val bitmapWidth = resources.displayMetrics.widthPixels
    private val bitmapHeight = bitmapWidth * bitmapLottery.height / bitmapLottery.width
    private val bitmapFinger =
        Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
    private var fingerCanvas: Canvas
    private val path = Path()
    private var preX = 0f
    private var preY = 0f
    private val wipeCompletePercent = 50
    private var isCompleted = false

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        paintLottery.isAntiAlias = true

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
            bitmapCover,
            null,
            RectF(0f, 0f, bitmapWidth.toFloat(), bitmapHeight.toFloat()),
            null
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //先把中奖背景画到canvas上
        canvas?.drawBitmap(
            bitmapLottery,
            null,
            RectF(0f, 0f, bitmapWidth.toFloat(), bitmapHeight.toFloat()),
            paintLottery
        )

        //先把手指轨迹画到目标Bitmap上
        fingerCanvas.drawPath(path, paintCover)

        if (!isCompleted) {
            canvas?.drawBitmap(
                bitmapFinger,
                null,
                RectF(0f, 0f, bitmapWidth.toFloat(), bitmapHeight.toFloat()),
                null
            )
        } else {
            Toast.makeText(context, "恭喜你，中奖啦~~~", Toast.LENGTH_LONG).show()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                preX = event.x
                preY = event.y
                path.moveTo(preX, preY)
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = (preX + event.x) / 2
                val endY = (preY + event.y) / 2
                path.quadTo(preX, preY, endX, endY)
                preX = event.x
                preY = event.y
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                post(mTask)
            }
        }
        return true
    }

    private val mTask = Runnable {
        val totalArea = bitmapWidth * bitmapHeight
        var wipeArea = 0
        val mPixels = IntArray(bitmapWidth * bitmapHeight)
        bitmapFinger.getPixels(mPixels, 0, bitmapWidth, 0, 0, bitmapWidth, bitmapHeight)
        for (i in 0 until bitmapWidth) {
            for (j in 0 until bitmapHeight) {
                val index = i + j * bitmapWidth
                if (mPixels[index] == 0) {
                    wipeArea++
                }
            }
        }
        println("wipeArea = $wipeArea")
        //计算刮开区域所占的比例
        if ((wipeArea > 0) and (totalArea > 0)) {
            val wipePercent = wipeArea * 100 / totalArea
            if (wipePercent > wipeCompletePercent) {
                isCompleted = true
                postInvalidate()
            }
        }
    }
}