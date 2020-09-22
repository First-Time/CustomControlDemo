package com.lyf.customcontrol.part3.flowlayout02

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.max

class MyFlowLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    ViewGroup(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        var lineWidth = 0 //记录每一行的宽度
        var lineHeight = 0 //记录每一行的高度
        var width = 0 //记录整个FlowLayout所占宽度
        var height = 0 //记录整个FlowLayout所占高度
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)

            val marginLayoutParams: MarginLayoutParams = child.layoutParams as MarginLayoutParams
            val childWidth =
                child.measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin
            val childHeight =
                child.measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin

            if (lineWidth + childWidth > measureWidth) {
                width = max(lineWidth, childWidth)
                height += lineHeight

                lineWidth = childWidth
                lineHeight = childHeight
            } else {
                lineWidth += childWidth
                lineHeight = max(lineHeight, childHeight)
            }
            //最后再加上最后一行的高度，最后一行是不会超出width范围的，所以要单独处理
            if (i == childCount - 1) {
                height += lineHeight;
                width = max(width, lineWidth);
            }
        }
        setMeasuredDimension(
            if (measureWidthMode == MeasureSpec.EXACTLY) measureWidth else width,
            if (measureHeightMode == MeasureSpec.EXACTLY) measureHeight else height
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var lineWidth = 0
        var lineHeight = 0
        var top = 0
        var left = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val marginLayoutParams: MarginLayoutParams = child.layoutParams as MarginLayoutParams

            val childWidth =
                child.measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin
            val childHeight =
                child.measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin

            if (lineWidth + childWidth > measuredWidth) {
                top += lineHeight
                left = 0

                lineWidth = childWidth
                lineHeight = childHeight
            } else {
                lineHeight = max(lineHeight, childHeight)
                lineWidth += childWidth
            }

            val lc = left + marginLayoutParams.leftMargin
            val tc = top + marginLayoutParams.topMargin
            val rc = lc + child.measuredWidth
            val bc = tc + child.measuredHeight

            child.layout(lc, tc, rc, bc)
            //将left置为下一子控件的起始点
            left += childWidth
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