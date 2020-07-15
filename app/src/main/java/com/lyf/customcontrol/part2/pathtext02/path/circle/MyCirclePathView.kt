package com.lyf.customcontrol.part2.pathtext02.path.circle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class MyCirclePathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        val ccwCirclePath = Path()
        ccwCirclePath.addCircle(200f, 200f, 100f, Path.Direction.CCW)
        canvas?.drawPath(ccwCirclePath, paint)

        val cwCirclePath = Path()
        cwCirclePath.addCircle(500f, 200f, 100f, Path.Direction.CW)
        canvas?.drawPath(cwCirclePath, paint)

        val text = "第一时间"
        paint.color = Color.GRAY
        paint.textSize = 35f
        canvas?.drawTextOnPath(text, ccwCirclePath, 0f, 15f, paint)
        canvas?.drawTextOnPath(text, cwCirclePath, 0f, 15f, paint)
    }
}