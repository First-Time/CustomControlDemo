package com.lyf.customcontrol.main

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class GridDividerItemDecoration() : RecyclerView.ItemDecoration() {
    private var mPaint: Paint = Paint()
    private var mDividerWidth = 0
    private var mDividerHeight: Int = 0

    constructor(height: Int) : this() {
        mDividerWidth = height
        mDividerHeight = height
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = Color.TRANSPARENT
        mPaint.style = Paint.Style.FILL
    }

    constructor(height: Int, @ColorInt color: Int) : this() {
        mDividerWidth = height
        mDividerHeight = height
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = color
        mPaint.style = Paint.Style.FILL
    }

    constructor(width: Int, height: Int, @ColorInt color: Int) : this() {
        mDividerWidth = width
        mDividerHeight = height
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = color
        mPaint.style = Paint.Style.FILL
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state!!)
        val itemPosition =
            (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
        val spanCount = getSpanCount(parent)
        val childCount = parent.adapter!!.itemCount
        val isLastRow = isLastRow(parent, itemPosition, spanCount, childCount)
        val top = 0
        val left: Int
        val right: Int
        var bottom: Int
        val eachWidth = (spanCount - 1) * mDividerWidth / spanCount
        val dl = mDividerWidth - eachWidth
        left = itemPosition % spanCount * dl
        right = eachWidth - left
        bottom = mDividerHeight
        if (isLastRow) {
            bottom = 0
        }
        outRect.set(left, top, right, bottom)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state!!)
        draw(c, parent)
    }

    //绘制item分割线
    private fun draw(canvas: Canvas, parent: RecyclerView) {
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child: View = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val isLastRow = isLastRow(parent, i, getSpanCount(parent), childCount)
            //画水平分隔线
            var left: Int = child.left
            var right: Int = child.right
            var top: Int = child.bottom + layoutParams.bottomMargin
            var bottom: Int = top + mDividerHeight
            if (isLastRow) bottom = top
            if (mPaint != null) {
                canvas.drawRect(
                    left.toFloat(),
                    top.toFloat(),
                    right.toFloat(),
                    bottom.toFloat(),
                    mPaint
                )
            }
            //画垂直分割线
            top = child.top
            bottom = child.bottom + mDividerHeight
            left = child.right + layoutParams.rightMargin
            right = left + mDividerWidth
            if (isLastRow) bottom = child.bottom
            if (mPaint != null) {
                canvas.drawRect(
                    left.toFloat(),
                    top.toFloat(),
                    right.toFloat(),
                    bottom.toFloat(),
                    mPaint
                )
            }
        }
    }

    private fun isLastColumn(
        parent: RecyclerView, pos: Int, spanCount: Int,
        childCount: Int
    ): Boolean {
        var childCount = childCount
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            if ((pos + 1) % spanCount == 0) { // 如果是最后一列，则不需要绘制右边
                return true
            }
        } else if (layoutManager is StaggeredGridLayoutManager) {
            val orientation = layoutManager
                .orientation
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                if ((pos + 1) % spanCount == 0) // 如果是最后一列，则不需要绘制右边
                {
                    return true
                }
            } else {
                childCount -= childCount % spanCount
                if (pos >= childCount) // 如果是最后一列，则不需要绘制右边
                    return true
            }
        }
        return false
    }

    private fun isLastRow(
        parent: RecyclerView, pos: Int, spanCount: Int,
        childCount: Int
    ): Boolean {
        var childCount = childCount
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            val lines =
                if (childCount % spanCount == 0) childCount / spanCount else childCount / spanCount + 1
            return lines == pos / spanCount + 1
        } else if (layoutManager is StaggeredGridLayoutManager) {
            val orientation = layoutManager
                .orientation
            // StaggeredGridLayoutManager 且纵向滚动
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                childCount -= childCount % spanCount
                // 如果是最后一行，则不需要绘制底部
                if (pos >= childCount) return true
            } else {
                // 如果是最后一行，则不需要绘制底部
                if ((pos + 1) % spanCount == 0) {
                    return true
                }
            }
        }
        return false
    }

    private fun isFirstRow(
        parent: RecyclerView, pos: Int, spanCount: Int,
        childCount: Int
    ): Boolean {
        var childCount = childCount
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            return pos / spanCount + 1 == 1
        } else if (layoutManager is StaggeredGridLayoutManager) {
            val orientation = layoutManager
                .orientation
            // StaggeredGridLayoutManager 且纵向滚动
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                childCount -= childCount % spanCount
                // 如果是最后一行，则不需要绘制底部
                if (pos >= childCount) return true
            } else {
                // 如果是最后一行，则不需要绘制底部
                if ((pos + 1) % spanCount == 0) {
                    return true
                }
            }
        }
        return false
    }

    //获取列数
    private fun getSpanCount(parent: RecyclerView): Int {
        var spanCount = -1
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            spanCount = layoutManager.spanCount
        } else if (layoutManager is StaggeredGridLayoutManager) {
            spanCount = layoutManager
                .spanCount
        }
        return spanCount
    }
}