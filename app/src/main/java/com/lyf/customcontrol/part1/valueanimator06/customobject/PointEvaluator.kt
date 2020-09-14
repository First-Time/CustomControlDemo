package com.lyf.customcontrol.part1.valueanimator06.customobject

import android.animation.TypeEvaluator

class PointEvaluator : TypeEvaluator<Point> {
    override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {
        return Point(((startValue.radius + (endValue.radius - startValue.radius)) * fraction).toInt())
    }
}