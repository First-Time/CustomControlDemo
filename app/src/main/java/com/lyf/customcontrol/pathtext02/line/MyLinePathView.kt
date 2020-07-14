package com.lyf.customcontrol.pathtext02.line

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class MyLinePathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        val ccwLinePath = Path()
        ccwLinePath.moveTo(10f, 10f)
        ccwLinePath.lineTo(10f, 100f)
        ccwLinePath.lineTo(300f, 100f)
        ccwLinePath.lineTo(500f, 100f)
        ccwLinePath.close()
        canvas?.drawPath(ccwLinePath, paint)

        val cwLinePath = Path()
        cwLinePath.moveTo(500f, 300f)
        cwLinePath.lineTo(300f, 300f)
        cwLinePath.lineTo(10f, 300f)
        cwLinePath.lineTo(10f, 210f)
        cwLinePath.close()
        canvas?.drawPath(cwLinePath, paint)

        val text = "第一时间"
        paint.color = Color.GRAY
        paint.textSize = 35f
        canvas?.drawTextOnPath(text, ccwLinePath, 0f, 0f, paint)
        canvas?.drawTextOnPath(text, cwLinePath, 0f, 0f, paint)
    }
}