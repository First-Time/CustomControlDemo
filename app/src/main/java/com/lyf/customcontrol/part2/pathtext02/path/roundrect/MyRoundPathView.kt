package com.lyf.customcontrol.part2.pathtext02.path.roundrect

import android.content.Context
import android.graphics.*
import android.view.View

class MyRoundPathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        val ccwPath = Path()
        val rectF1 = RectF(50f, 50f, 240f, 200f)
        ccwPath.addRoundRect(rectF1, 15f, 15f, Path.Direction.CCW)
        canvas?.drawPath(ccwPath, paint)

        val cwPath = Path()
        val rectF2 = RectF(290f, 50f, 480f, 200f)
        cwPath.addRoundRect(
            rectF2,
            floatArrayOf(10f, 15f, 20f, 25f, 30f, 35f, 40f, 45f),
            Path.Direction.CW
        )
        canvas?.drawPath(cwPath, paint)

        val text = "第一时间"
        paint.color = Color.GRAY
        paint.textSize = 35f
        canvas?.drawTextOnPath(text, ccwPath, 0f, 15f, paint)
        canvas?.drawTextOnPath(text, cwPath, 0f, 15f, paint)
    }
}