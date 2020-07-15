package com.lyf.customcontrol.part2.pathtext02.text.example03

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyTextView03(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色

        paint.strokeWidth = 5f //设置画笔宽度
        paint.isAntiAlias = true //设置画笔是否抗锯齿，如果使用：会使绘图速度变慢
        paint.textSize = 100f //设置字体大小
        paint.style = Paint.Style.FILL //绘图样式，设置为填充

        //普通样式字体
        canvas?.drawText("指点江山，激扬文字，粪土当年万户侯", 0f, 100f, paint)

        //水平方向拉伸两倍
        paint.textScaleX = 2f
        canvas?.drawText("指点江山，激扬文字，粪土当年万户侯", 0f, 200f, paint)

        //在同一位置，使用不同颜色写普通和水平方向拉伸两倍文字，观察高度是否变化
        paint.textScaleX = 1f
        canvas?.drawText("指点江山，激扬文字，粪土当年万户侯", 0f, 300f, paint)

        paint.color = Color.GREEN
        paint.textScaleX = 2f
        canvas?.drawText("指点江山，激扬文字，粪土当年万户侯", 0f, 300f, paint)
    }
}