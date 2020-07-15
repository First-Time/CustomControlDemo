package com.lyf.customcontrol.part2.pathtext02.text.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class MyTextPathView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED //设置画笔颜色

        paint.strokeWidth = 5f //设置画笔宽度
        paint.isAntiAlias = true //设置是否抗锯齿，如果使用：会使换图速度变慢
        paint.textSize = 45f //设置字体大小
        paint.style = Paint.Style.STROKE //绘图样式，设置为填充

        //先创建两个相同的圆形路径，并先画出两个路径原型
        val ccwCirclePath = Path()
        ccwCirclePath.addCircle(220f, 200f, 180f, Path.Direction.CCW)
        canvas?.drawPath(ccwCirclePath, paint) //绘制出路径原型

        val cwCirclePath = Path()
        cwCirclePath.addCircle(750f, 200f, 180f, Path.Direction.CCW)
        canvas?.drawPath(cwCirclePath, paint) //绘制出路径原型

        paint.color = Color.GREEN

        val text = "山川异域，风月同天"

        //hOffset、vOffset参数值全部设为0，看原始状态是怎么样的
        canvas?.drawTextOnPath(text, ccwCirclePath, 0f, 0f, paint)

        //第二个路径，改变hOffset、vOffset参数值
        canvas?.drawTextOnPath(text, cwCirclePath, 80f, 30f, paint)
    }
}