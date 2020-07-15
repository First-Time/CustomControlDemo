package com.lyf.customcontrol.part2.draw01.line

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.view.View
import com.lyf.customcontrol.R

class MyLineView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色
        paint.style = Paint.Style.FILL //设置填充样式
        paint.strokeWidth = 5f //设置画笔宽度

        canvas?.drawColor(resources.getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_OVER)

//        canvas?.drawLine(100f, 100f, 200f, 200f, paint)

        val pts = floatArrayOf(10f, 10f, 100f, 100f, 200f, 200f, 400f, 400f)
        canvas?.drawLines(pts, paint)
    }
}