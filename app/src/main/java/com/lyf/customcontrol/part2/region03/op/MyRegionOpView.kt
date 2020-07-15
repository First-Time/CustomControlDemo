package com.lyf.customcontrol.part2.region03.op

import android.content.Context
import android.graphics.*
import android.view.View

class MyRegionOpView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        //region 画出两个矩形
        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f

        val rect1 = Rect(100, 100, 400, 200)
        val rect2 = Rect(200, 0, 300, 300)

        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)
        //endregion

        //region 画出两个矩形的交集
        canvas?.translate(500f, 0f)

        val region1 = Region(rect1)
        val region2 = Region(rect2)

        region1.op(region2, Region.Op.INTERSECT)
        drawRegion(canvas, region1, paint)
        //endregion

        //region 填充两个矩形的交集
        canvas?.translate(-500f, 300f)

        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)

        val region5 = Region(rect1)
        val region6 = Region(rect2)

        region5.op(region6, Region.Op.INTERSECT)

        val paintFill5 = Paint()
        paintFill5.color = Color.GREEN
        paintFill5.style = Paint.Style.FILL
        drawRegion(canvas, region5, paintFill5)
        //endregion

        //region 填充第一个矩形不与第二个矩形相交的区域（第一个矩形与第二个矩形的差集）
        canvas?.translate(500f, 0f)

        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)

        val region7 = Region(rect1)
        val region8 = Region(rect2)

        region7.op(region8, Region.Op.DIFFERENCE)

        val paintFill7 = Paint()
        paintFill7.color = Color.GREEN
        paintFill7.style = Paint.Style.FILL
        drawRegion(canvas, region7, paintFill7)
        //endregion

        //region 填充第二个矩形替换第一个矩形的区域（即第二个矩形的区域）
        canvas?.translate(-500f, 300f)

        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)

        val region9 = Region(rect1)
        val region10 = Region(rect2)

        region9.op(region10, Region.Op.REPLACE)

        val paintFill9 = Paint()
        paintFill9.color = Color.GREEN
        paintFill9.style = Paint.Style.FILL
        drawRegion(canvas, region9, paintFill9)
        //endregion

        //region 填充第二个矩形不与第一个矩形相交的区域（第二个矩形与第一个矩形的差集）
        canvas?.translate(500f, 0f)

        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)

        val region11 = Region(rect1)
        val region12 = Region(rect2)

        region11.op(region12, Region.Op.REVERSE_DIFFERENCE)

        val paintFill11 = Paint()
        paintFill11.color = Color.GREEN
        paintFill11.style = Paint.Style.FILL
        drawRegion(canvas, region11, paintFill11)
        //endregion

        //region 填充第一个矩形与第二个矩形的并集
        canvas?.translate(-500f, 300f)

        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)

        val region13 = Region(rect1)
        val region14 = Region(rect2)

        region13.op(region14, Region.Op.UNION)

        val paintFill13 = Paint()
        paintFill13.color = Color.GREEN
        paintFill13.style = Paint.Style.FILL
        drawRegion(canvas, region13, paintFill13)
        //endregion

        //region 填充第一个矩形与第二个矩形不相交的区域（并集减去交集）
        canvas?.translate(500f, 0f)

        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)

        val region15 = Region(rect1)
        val region16 = Region(rect2)

        region15.op(region16, Region.Op.XOR)

        val paintFill15 = Paint()
        paintFill15.color = Color.GREEN
        paintFill15.style = Paint.Style.FILL
        drawRegion(canvas, region15, paintFill15)
        //endregion
    }

    private fun drawRegion(canvas: Canvas?, region: Region, paint: Paint) {
        val regionIterator = RegionIterator(region)
        val rect = Rect()
        while (regionIterator.next(rect)) {
            canvas?.drawRect(rect, paint)
        }
    }
}