package com.lyf.customcontrol.pathtext02.oval

import android.content.Context
import android.graphics.*
import android.view.View

class MyOvalPathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        val ccwOvalPath = Path()
        val rectF1 = RectF(50f, 50f, 240f, 200f)
        ccwOvalPath.addOval(rectF1, Path.Direction.CCW)
        canvas?.drawPath(ccwOvalPath, paint)

        val cwOvalPath = Path()
        val rectF2 = RectF(290f, 50f, 480f, 200f)
        cwOvalPath.addOval(rectF2, Path.Direction.CW)
        canvas?.drawPath(cwOvalPath, paint)

        val text = "第一时间"
        paint.color = Color.GRAY
        paint.textSize = 35f
        canvas?.drawTextOnPath(text, ccwOvalPath, 0f, 15f, paint)
        canvas?.drawTextOnPath(text, cwOvalPath, 0f, 15f, paint)
    }
}