package com.lyf.customcontrol.part2.region04.saverestore

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.View

class MySaveRestoreView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        /*canvas?.drawColor(Color.RED)

        //保存当前画布大小，即整屏
        canvas?.save()

        canvas?.clipRect(Rect(100, 100, 800, 800))
        canvas?.drawColor(Color.GREEN)

        //恢复整屏画布
        canvas?.restore()

        canvas?.drawColor(Color.BLUE)*/


        canvas?.drawColor(Color.RED)

        //保存当前画布大小，即整屏
        canvas?.save()

        canvas?.clipRect(Rect(100, 100, 800, 800))
        canvas?.drawColor(Color.GREEN)
        canvas?.save()

        canvas?.clipRect(Rect(200, 200, 700, 700))
        canvas?.drawColor(Color.BLUE)
        canvas?.save()

        canvas?.clipRect(Rect(300, 300, 600, 600))
        canvas?.drawColor(Color.BLACK)
        canvas?.save()

        canvas?.clipRect(Rect(400, 400, 500, 500))
        canvas?.drawColor(Color.WHITE)

        //将栈顶的画布状态取出来，作为当前画布，并画成黄色背景
        canvas?.restore()
        canvas?.restore()
        canvas?.restore()
        canvas?.drawColor(Color.YELLOW)
    }
}