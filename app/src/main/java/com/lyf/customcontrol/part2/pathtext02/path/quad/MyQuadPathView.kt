package com.lyf.customcontrol.part2.pathtext02.path.quad

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class MyQuadPathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        val ccwQuadPath = Path()
        ccwQuadPath.moveTo(10f, 10f)
        ccwQuadPath.quadTo(20f, 20f, 200f, 20f)
        canvas?.drawPath(ccwQuadPath, paint)
    }
}