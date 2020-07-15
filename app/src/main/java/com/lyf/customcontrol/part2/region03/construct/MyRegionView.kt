package com.lyf.customcontrol.part2.region03.construct

import android.content.Context
import android.graphics.*
import android.view.View

class MyRegionView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 2f

        val region = Region(10, 10, 100, 100)

        //注释或不注释下一行代码查看效果
        region.set(100, 100, 200, 200)
        drawRegion(canvas, region, paint)
    }

    private fun drawRegion(canvas: Canvas?, region: Region, paint: Paint) {
        val regionIterator = RegionIterator(region)
        val rect = Rect()
        while (regionIterator.next(rect)) {
            canvas?.drawRect(rect, paint)
        }
    }
}