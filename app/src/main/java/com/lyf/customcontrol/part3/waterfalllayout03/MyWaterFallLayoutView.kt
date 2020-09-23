package com.lyf.customcontrol.part3.waterfalllayout03

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class MyWaterFallLayoutView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    ViewGroup(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val columns = 3
    private val hSpace = 20
    private val vSpace = 20
    private val top = IntArray(3) { 0 }
    private var columnWidth = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        measureChildren(widthMeasureSpec, heightMeasureSpec)

        columnWidth = (measureWidth - hSpace * (columns - 1)) / columns

        var wrapWidth: Int
        wrapWidth = if (childCount < columns) {
            columnWidth * childCount + hSpace * (columns - 1)
        } else {
            measureWidth
        }

        clearTop()
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val childHeight =
                (child.measuredHeight * columnWidth.toFloat() / child.measuredWidth).toInt()
            val minHeightColumn = getMinHeightColumn()

            val waterFallLayoutParams: MyWaterFallLayoutParams =
                child.layoutParams as MyWaterFallLayoutParams
            waterFallLayoutParams.left = (columnWidth + hSpace) * minHeightColumn
            waterFallLayoutParams.top = top[minHeightColumn]
            waterFallLayoutParams.right = waterFallLayoutParams.left + columnWidth
            waterFallLayoutParams.bottom = waterFallLayoutParams.top + childHeight

            top[minHeightColumn] += childHeight + vSpace
        }
        var wrapHeight = getMaxHeight()
        setMeasuredDimension(
            if (measureWidthMode == MeasureSpec.AT_MOST) wrapWidth else measureWidth,
            wrapHeight
        )
    }

    private fun clearTop() {
        for (i in top.indices) {
            top[i] = 0
        }
    }

    private fun getMinHeightColumn(): Int {
        var minHeightColumn = 0
        for (i in top.indices) {
            minHeightColumn = if (top[i] < top[minHeightColumn]) i else minHeightColumn
        }
        return minHeightColumn
    }

    private fun getMaxHeight(): Int {
        var maxHeight = 0
        for (i in top.indices) {
            maxHeight = if (top[i] > top[maxHeight]) i else maxHeight
        }
        return top[maxHeight]
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        clearTop()
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val childHeight =
                (columnWidth * child.measuredHeight.toFloat() / child.measuredWidth).toInt()
            val minHeightColumn = getMinHeightColumn()
            /*val lc = (columnWidth + hSpace) * minHeightColumn
            val tc = top[minHeightColumn]
            val rc = lc + columnWidth
            val bc = tc + childHeight*/

            val waterFallLayoutParams: MyWaterFallLayoutParams =
                child.layoutParams as MyWaterFallLayoutParams

            top[minHeightColumn] += childHeight + vSpace
            child.layout(
                waterFallLayoutParams.left,
                waterFallLayoutParams.top,
                waterFallLayoutParams.right,
                waterFallLayoutParams.bottom
            )
        }
    }

    override fun checkLayoutParams(p: LayoutParams?): Boolean {
        return p is MyWaterFallLayoutParams
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MyWaterFallLayoutParams(p)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MyWaterFallLayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MyWaterFallLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.setOnClickListener { listener.onItemClick(child, i) }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, index: Int)
    }
}