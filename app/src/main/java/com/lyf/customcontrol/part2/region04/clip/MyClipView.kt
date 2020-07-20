package com.lyf.customcontrol.part2.region04.clip

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import com.lyf.customcontrol.main.generatePaint

class MyClipView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        canvas?.drawColor(Color.RED)

        val clipRect = Rect(200, 100, 300, 200)
        canvas?.clipRect(clipRect)
        canvas?.drawColor(Color.GREEN)
    }
}