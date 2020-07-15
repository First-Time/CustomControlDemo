package com.lyf.customcontrol.part2.pathtext02.text.example02

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyTextView02(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色

        paint.strokeWidth = 5f //设置画笔宽度
        paint.isAntiAlias = true //设置画笔是否抗锯齿
        paint.textSize = 80f //设置字体大小
        paint.style = Paint.Style.FILL //绘图样式，设置为填充

        //样式设置
        paint.isFakeBoldText = true //设置是否为粗体文字
        paint.isUnderlineText = true //设置下划线
        paint.isStrikeThruText = true //设置带有删除线效果

        //设置字体水平倾斜度，普通斜字体是-0.25，可见往右斜
        paint.textSkewX = -0.25f
        canvas?.drawText("昨夜西风凋碧树", 0f, 100f, paint)

        //设置字体水平倾斜度：0.25，往左斜
        paint.textSkewX = 0.25f
        canvas?.drawText("昨夜西风凋碧树", 0f, 200f, paint)
    }
}