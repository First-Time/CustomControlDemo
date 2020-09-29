package com.lyf.customcontrol.part3.recyclerreuse07.reusecustom

import android.graphics.Rect
import android.util.SparseArray
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.ceil
import kotlin.math.max

class CustomLayoutManager : RecyclerView.LayoutManager() {
    private var mSumDy = 0
    private var mTotalHeight = 0
    private var mItemWidth = 0
    private var mItemHeight = 0
    private val mItemRectArray = SparseArray<Rect>()

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        detachAndScrapAttachedViews(recycler!!)
        if (itemCount == 0) {
            return
        }
        //将item的位置存储起来
        val childView = recycler?.getViewForPosition(0)
        measureChildWithMargins(childView, 0, 0)
        mItemWidth = getDecoratedMeasuredWidth(childView)
        mItemHeight = getDecoratedMeasuredHeight(childView)
        val visibleCount = ceil(getVerticalSpace() / mItemHeight.toFloat()).toInt()

        var offsetY = paddingTop //offsetY首先便宜paddingTop的距离

        for (i in 0 until itemCount) {
            //需要考虑paddingLeft
            val rect = Rect(paddingLeft, offsetY, mItemWidth + paddingLeft, mItemHeight + offsetY)
            mItemRectArray.put(i, rect)
            offsetY += mItemHeight
        }

        for (i in 0 until visibleCount) {
            val rect = mItemRectArray.get(i)
            val view = recycler?.getViewForPosition(i)
            addView(view)
            //addView后一定要measure，先measure再layout
            measureChildWithMargins(view!!, 0, 0)
            layoutDecorated(view, rect.left, rect.top, rect.right, rect.bottom)
        }
        //如果所有子View的高度和没有填满RecyclerView的高度，
        //则将高度设置为RecyclerView的高度
        mTotalHeight = max(offsetY, getVerticalSpace())
    }

    override fun canScrollVertically(): Boolean {
        return true
    }

    private fun getVerticalSpace(): Int {
        return height - paddingTop - paddingBottom
    }

    /**
     * 获取当前屏幕的位置
     */
    private fun getVisibleArea(travel: Int): Rect {
        return Rect(
            paddingLeft,
            paddingTop + mSumDy + travel,
            width - paddingRight,
            getVerticalSpace() + paddingTop + mSumDy + travel //需要加上paddingTop
        )
    }

    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        if (childCount <= 0) return dy

        var travel = dy
        //如果滑动到最顶部
        if (mSumDy + dy < 0) {
            travel = -mSumDy
        } else if (mSumDy + travel > mTotalHeight - getVerticalSpace()) {
            //如果滑动到最底部
            travel = mTotalHeight - getVerticalSpace() - mSumDy
        }

        //从下向上滑动时回收越界子View
        for (i in childCount - 1 downTo 0) {
            val child = getChildAt(i)
            if (travel > 0) { //需要回收当前屏幕，上越界的View
                if (getDecoratedBottom(child!!) - travel < 0) {
                    removeAndRecycleView(child, recycler!!)
                    continue
                }
            } else { //需要回收当前屏幕，下越界的View
                if (getDecoratedTop(child!!) - travel > height - paddingBottom) {
                    removeAndRecycleView(child, recycler!!)
                    continue
                }
            }
        }

        val visibleRect = getVisibleArea(travel)
        //布局子View阶段
        if (travel >= 0) {
            val lastView = getChildAt(childCount - 1)
            val minPos = getPosition(lastView!!) + 1 //从最后一个View + 1开始吧

            //顺序addChildView
            for (i in minPos until itemCount) {
                val rect = mItemRectArray.get(i)
                if (visibleRect.intersect(rect)) {
                    val child = recycler?.getViewForPosition(i)
                    addView(child)
                    measureChildWithMargins(child!!, 0, 0)
                    layoutDecorated(
                        child!!,
                        rect.left,
                        rect.top - mSumDy,
                        rect.right,
                        rect.bottom - mSumDy
                    )
                } else {
                    break
                }
            }
        } else {
            val firstView = getChildAt(0)
            val maxPos = getPosition(firstView!!) - 1 //从第一个View + 1开始

            //顺序addChildView
            for (i in maxPos downTo 0) {
                val rect = mItemRectArray.get(i)
                if (visibleRect.intersect(rect)) {
                    val child = recycler?.getViewForPosition(i)
                    addView(child, 0)
                    measureChildWithMargins(child!!, 0, 0)
                    layoutDecorated(
                        child!!,
                        rect.left,
                        rect.top - mSumDy,
                        rect.right,
                        rect.bottom - mSumDy
                    )
                } else {
                    break
                }
            }
        }

        mSumDy += travel
        // 平移容器内的item
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