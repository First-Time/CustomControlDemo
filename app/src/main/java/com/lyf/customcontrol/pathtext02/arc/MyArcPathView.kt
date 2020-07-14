package com.lyf.customcontrol.pathtext02.arc

import android.content.Context
import android.graphics.*
import android.view.View

class MyArcPathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        val ccwArcPath = Path()
        val rectF1 = RectF(50f, 50f, 240f, 200f)
        ccwArcPath.addArc(rectF1, 0f, 100f)
        canvas?.drawPath(ccwArcPath, paint)

        val cwArcPath = Path()
        val rectF2 = RectF(290f, 50f, 480f, 200f)
        cwArcPath.addArc(rectF2, 100f, -100f)
        canvas?.drawPath(cwArcPath, paint)

        val text = "第一时间"
        paint.color = Color.GRAY
        paint.textSize = 35f
        canvas?.drawTextOnPath(text, ccwArcPath, 0f, 15f, paint)
        canvas?.drawTextOnPath(text, cwArcPath, 0f, 15f, paint)
    }
}