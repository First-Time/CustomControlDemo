package com.lyf.customcontrol.part2.pathtext02.path.rect

import android.content.Context
import android.graphics.*
import android.view.View

class MyRectPathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        //先创建两个大小一样的路径
        //第一个逆时针生成
        val ccwRectPath = Path()
        val rectF1 = RectF(50f, 50f, 240f, 200f)
        ccwRectPath.addRect(rectF1, Path.Direction.CCW)
        canvas?.drawPath(ccwRectPath, paint)

        //第二个顺时针生成
        val cwRectPath = Path()
        val rectF2 = RectF(290f, 50f, 480f, 200f)
        cwRectPath.addRect(rectF2, Path.Direction.CW)
        canvas?.drawPath(cwRectPath, paint)

        val text = "第一时间"
        paint.color = Color.GRAY
        paint.textSize = 35f
        canvas?.drawTextOnPath(text, ccwRectPath, 0f, 15f, paint)
        canvas?.drawTextOnPath(text, cwRectPath, 0f, 15f, paint)
    }
}