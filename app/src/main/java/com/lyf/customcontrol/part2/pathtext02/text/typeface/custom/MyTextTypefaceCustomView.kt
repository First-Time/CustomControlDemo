package com.lyf.customcontrol.part2.pathtext02.text.typeface.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyTextTypefaceCustomView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色

        paint.strokeWidth = 5f //设置画笔宽度
        paint.isAntiAlias = true //设置是否抗锯齿，如果使用：会使绘图速度变慢
        paint.textSize = 60f //设置字体大小
        paint.style = Paint.Style.STROKE //绘图样式，设置为描边

//        var font = Typeface.createFromAsset(resources.assets, "fonts/jian_luobo.ttf")
//        paint.typeface = font
        canvas?.drawText("暂无其他字体", 10f, 100f, paint)
    }
}