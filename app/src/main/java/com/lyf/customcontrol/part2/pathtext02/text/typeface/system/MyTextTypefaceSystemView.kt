package com.lyf.customcontrol.part2.pathtext02.text.typeface.system

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View

class MyTextTypefaceSystemView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色

        paint.strokeWidth = 5f //设置画笔宽度
        paint.isAntiAlias = true //设置是否抗锯齿，如果使用：会使绘图速度变慢
        paint.textSize = 60f //设置字体大小
        paint.style = Paint.Style.STROKE //绘图样式，设置为描边

        var familyName1 = "sans"
        var font1 = Typeface.create(familyName1, Typeface.NORMAL)
        paint.typeface = font1
        canvas?.drawText("男女平等", 10f, 100f, paint)

        val familyName2 = "serif"
        val font2 = Typeface.create(familyName2, Typeface.NORMAL)
        paint.typeface = font2
        canvas?.drawText("男女平等", 10f, 200f, paint)

        val familyName3 = "monospace"
        val font3 = Typeface.create(familyName3, Typeface.NORMAL)
        paint.typeface = font3
        canvas?.drawText("男女平等", 10f, 300f, paint)
    }
}