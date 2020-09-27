package com.lyf.customcontrol.part3.layoutmanager06

import androidx.recyclerview.widget.RecyclerView
import kotlin.math.max

class CustomLayoutManager : RecyclerView.LayoutManager() {
    private var mSumDy = 0
    private var mTotalHeight = 0

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        var offsetY = 0
        for (i in 0 until itemCount) {
            val view = recycler?.getViewForPosition(i)
            addView(view)
            measureChildWithMargins(view!!, 0, 0)
            val width = getDecoratedMeasuredWidth(view)
            val height = getDecoratedMeasuredHeight(view)
            layoutDecorated(view, 0, offsetY, width, height + offsetY)
            offsetY += height
        }
        mTotalHeight = max(offsetY, getVerticalSpace())
    }

    override fun canScrollVertically(): Boolean {
        return true
    }

    private fun getVerticalSpace(): Int {
        return height - paddingTop - paddingBottom
    }

    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        var travel = dy
        if (mSumDy + dy < 0) {
            travel = -mSumDy
        } else if (mSumDy + travel > mTotalHeight - getVerticalSpace()) {
            travel = mTotalHeight - getVerticalSpace() - mSumDy
        }
        mSumDy += travel

        offsetChildrenVertical(-travel)
        return dy
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }
}