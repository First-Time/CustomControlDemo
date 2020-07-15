package com.lyf.customcontrol.part2.pathtext02.text.pos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyTextPosView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色

        paint.strokeWidth = 5f //设置画笔宽度
        paint.isAntiAlias = true //设置画笔是否抗锯齿，如果使用：会使绘图速度变慢
        paint.textSize = 100f //设置字体大小
        paint.style = Paint.Style.FILL //绘图样式，设置为填充

        val pos = floatArrayOf(80f, 100f, 80f, 200f, 80f, 300f, 80f, 400f)

        canvas?.drawPosText("天龙八部", pos, paint)
    }
}