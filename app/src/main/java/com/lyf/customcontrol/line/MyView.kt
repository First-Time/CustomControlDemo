package com.lyf.customcontrol.line

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyView(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.isAntiAlias = true //设置抗锯齿
        paint.color = Color.RED //设置画笔颜色
        paint.style = Paint.Style.FILL //设置填充样式
        paint.strokeWidth = 5f //设置画笔宽度
        paint.setShadowLayer(10f, -30f, 15f, Color.GREEN) //设置阴影

        //设置画布背景颜色
        canvas?.drawRGB(0, 0, 0)

        //画图
        canvas?.drawCircle(190f, 200f, 150f, paint)
    }
}