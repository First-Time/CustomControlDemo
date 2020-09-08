package com.lyf.customcontrol.part2.lineargradient19.multiplegradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyLinearGradientView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //从左变中间到右边中间
        /*mPaint.shader = LinearGradient(
            0f,
            height.toFloat() / 2,
            width.toFloat(),
            height.toFloat() / 2,
            colors,
            pos,
            Shader.TileMode.REPEAT
        )*/

        //从左上角到右下角
        /*val colors = intArrayOf(
            0xffff0000.toInt(),
            0xff00ff00.toInt(), 0xff0000ff.toInt(), 0xffffff00.toInt(), 0xff00ffff.toInt()
        )
        val pos = floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 1.0f)

        mPaint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            colors,
            pos,
            Shader.TileMode.REPEAT
        )*/

        //从左上到中间  CLAMP
        /*val colors = intArrayOf(
            0xffff0000.toInt(),
            0xff00ff00.toInt(), 0xff0000ff.toInt(), 0xffffff00.toInt(), 0xff00ffff.toInt()
        )
        val pos = floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 1.0f)

        mPaint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat() / 2,
            height.toFloat() / 2,
            colors,
            pos,
            Shader.TileMode.CLAMP
        )*/

        //从左上到中间  REPEAT
        /*val colors = intArrayOf(
            0xffff0000.toInt(),
            0xff00ff00.toInt(), 0xff0000ff.toInt(), 0xffffff00.toInt(), 0xff00ffff.toInt()
        )
        val pos = floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 1.0f)

        mPaint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat() / 2,
            height.toFloat() / 2,
            colors,
            pos,
            Shader.TileMode.REPEAT
        )*/

        //从左上到中间  MIRROR
        /*val colors = intArrayOf(
            0xffff0000.toInt(),
            0xff00ff00.toInt(), 0xff0000ff.toInt(), 0xffffff00.toInt(), 0xff00ffff.toInt()
        )
        val pos = floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 1.0f)

        mPaint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat() / 2,
            height.toFloat() / 2,
            colors,
            pos,
            Shader.TileMode.MIRROR
        )*/

//        canvas?.drawRect(Rect(0, 0, width, height), mPaint)

        //填充方式：从控件左上角开始填充  MIRROR  绘制一小块
        /*val colors = intArrayOf(
            0xffff0000.toInt(),
            0xff00ff00.toInt(), 0xff0000ff.toInt(), 0xffffff00.toInt(), 0xff00ffff.toInt()
        )
        val pos = floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 1.0f)

        mPaint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat() / 2,
            height.toFloat() / 2,
            colors,
            pos,
            Shader.TileMode.MIRROR
        )

        canvas?.drawRect(Rect(100, 100, 200, 200), mPaint)*/

        //绘制渐变文本
        val colors = intArrayOf(
            0xffff0000.toInt(),
            0xff00ff00.toInt(), 0xff0000ff.toInt(), 0xffffff00.toInt(), 0xff00ffff.toInt()
        )
        val pos = floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 1.0f)

        mPaint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat() / 2,
            height.toFloat() / 2,
            colors,
            pos,
            Shader.TileMode.MIRROR
        )
        mPaint.textSize = 100f
        canvas?.drawText("梦里花落知多少梦里花落知多少", 0f, 200f, mPaint)
    }
}