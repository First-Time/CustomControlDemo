package com.lyf.customcontrol.part2.region03.setpath

import android.content.Context
import android.graphics.*
import android.view.View

class MyRegionSetPathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        //初始化Paint
        val paint = Paint()
        paint.color = Color.RED
//        paint.style = Paint.Style.FILL
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f

        //构造一个椭圆路径
        val ovalPath = Path()
        val rectF = RectF(50f, 50f, 200f, 500f)
        ovalPath.addOval(rectF, Path.Direction.CCW)

        val region = Region()
        region.setPath(ovalPath, Region(50, 50, 200, 200))

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