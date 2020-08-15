package com.lyf.customcontrol.part2.canvas13.ondraw

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyBitmapCanvasView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private var mBitmap: Bitmap = Bitmap.createBitmap(
        resources.displayMetrics.widthPixels,
        resources.displayMetrics.heightPixels,
        Bitmap.Config.ARGB_8888
    )
    private var mPaint: Paint = Paint()
    private var mCanvas: Canvas

    init {
        mPaint.color = Color.RED
        mCanvas = Canvas(mBitmap)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.textSize = 100f
        mCanvas.drawText("朱门酒肉臭路有冻死骨", 0f, 100f, mPaint) //仅仅到这里是不会显示任何界面的

        canvas?.drawBitmap(mBitmap, 0f, 0f, mPaint)

        canvas?.drawRect(300f, 300f, 500f, 500f, mPaint)

        val layerId = canvas?.saveLayerAlpha(0f, 0f, 600f, 600f, 0x88, Canvas.ALL_SAVE_FLAG)!!
        mPaint.color = Color.GREEN
        canvas?.drawRect(400f, 400f, 600f, 600f, mPaint)
        canvas?.restoreToCount(layerId)
    }
}