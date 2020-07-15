package com.lyf.customcontrol.part2.pathtext02.text.example01

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyTextView01(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色

        paint.strokeWidth = 5f //设置画笔宽度
        paint.isAntiAlias = true //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.textSize = 100f //设置字体大小

        //绘图样式，设置为填充
        paint.style = Paint.Style.FILL
        canvas?.drawText("风萧萧兮逆水寒，壮士一去兮不复还", 10f, 100f, paint)

        //绘图样式，设置为描边
        paint.style = Paint.Style.STROKE
        canvas?.drawText("风萧萧兮逆水寒，壮士一去兮不复还", 10f, 200f, paint)

        //绘图样式，设置为填充且描边
        paint.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawText("风萧萧兮逆水寒，壮士一去兮不复还", 10f, 300f, paint)
    }
}