package com.lyf.customcontrol.part3.measurelayout01

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class MyLinLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    ViewGroup(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)
        var width = 0
        var height = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            val marginLayoutParams: MarginLayoutParams = child.layoutParams as MarginLayoutParams
            width =
                child.measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin
            height += child.measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin
        }
        setMeasuredDimension(
            if (measureWidthMode == MeasureSpec.EXACTLY) measureWidth else width,
            if (measureHeightMode == MeasureSpec.EXACTLY) measureHeight else height
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var width: Int
        var height: Int
        var top = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val marginLayoutParams: MarginLayoutParams = child.layoutParams as MarginLayoutParams
            width =
                child.measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin
            height =
                child.measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin
            child.layout(0, top, width, height + top)
            top += height
        }
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MarginLayoutParams(p)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }
}