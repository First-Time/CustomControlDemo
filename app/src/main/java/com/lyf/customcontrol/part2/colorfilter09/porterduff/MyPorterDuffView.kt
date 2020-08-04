package com.lyf.customcontrol.part2.colorfilter09.porterduff

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyPorterDuffView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val paint = Paint()
    private lateinit var bitmap: Bitmap

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.isAntiAlias = true
        paint.colorFilter = null
        paint.color = Color.CYAN
        paint.textSize = 40f

//        bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_we_chat_pay)
        val width = resources.displayMetrics.widthPixels / 2 - 100
        val height = width * bitmap.height / bitmap.width

        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        var fontMetrics = paint.fontMetrics
        var textWidth1 = paint.measureText("原图")
        var textWidth2 = paint.measureText("饱和度相加")
        var textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "原图",
            (width - textWidth1) / 2,
            height - (textHeight + 15),
            paint
        )


        canvas?.translate(0f, height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.ADD")
        textWidth2 = paint.measureText("饱和度相加")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.ADD",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("饱和度相加", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.DARKEN")
        textWidth2 = paint.measureText("变暗")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.DARKEN",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("变暗", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.LIGHTEN)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.LIGHTEN")
        textWidth2 = paint.measureText("变亮")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.LIGHTEN",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("变亮", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.MULTIPLY")
        textWidth2 = paint.measureText("正片叠底")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.MULTIPLY",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("正片叠底", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.OVERLAY)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        fontMetrics = paint.fontMetrics
        textWidth1 = paint.measureText("Mode.OVERLAY")
        textWidth2 = paint.measureText("叠加")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.OVERLAY",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("叠加", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SCREEN)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.SCREEN")
        textWidth2 = paint.measureText("滤色")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.SCREEN",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("滤色", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.CLEAR)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.CLEAR")
        textWidth2 = paint.measureText("清空")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.CLEAR",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("清空", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.XOR)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.XOR")
        textWidth2 = paint.measureText("清空")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.XOR",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("清空", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("原图")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "原图",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.DST")
        textWidth2 = paint.measureText("目标")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.DST",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("目标", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_IN)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.DST_IN")
        textWidth2 = paint.measureText("覆盖源的目标")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.DST_IN",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("覆盖源的目标", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_OUT)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.DST_OUT")
        textWidth2 = paint.measureText("未被源覆盖的目标")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.DST_OUT",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("未被源覆盖的目标", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_OVER)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.DST_OVER")
        textWidth2 = paint.measureText("目标覆盖在源上")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.DST_OVER",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("目标覆盖在源上", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_ATOP)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.DST_ATOP")
        textWidth2 = paint.measureText("未被源覆盖的目标覆盖在源上")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.DST_ATOP",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("未被源覆盖的目标覆盖在源上", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("原图")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "原图",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.SRC")
        textWidth2 = paint.measureText("原图")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.SRC",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("原图", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.SRC_IN")
        textWidth2 = paint.measureText("覆盖目标的源")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.SRC_IN",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("覆盖目标的源", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_OUT)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.SRC_OUT")
        textWidth2 = paint.measureText("未覆盖目标的源")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.SRC_OUT",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("未覆盖目标的源", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(-(width + 50f), height + 50f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_OVER)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.SRC_OVER")
        textWidth2 = paint.measureText("源覆盖在目标上")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.SRC_OVER",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("源覆盖在目标上", (width - textWidth2) / 2, height - textHeight - 15, paint)


        canvas?.translate(width + 50f, 0f)
        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP)
        canvas?.drawBitmap(bitmap, null, Rect(0, 0, width, height), paint)

        textWidth1 = paint.measureText("Mode.SRC_ATOP")
        textWidth2 = paint.measureText("未覆盖目标的源覆盖在目标上")
        textHeight = fontMetrics.bottom - fontMetrics.top

        canvas?.drawText(
            "Mode.SRC_ATOP",
            (width - textWidth1) / 2,
            height - (textHeight + 15) * 2,
            paint
        )
        canvas?.drawText("未覆盖目标的源覆盖在目标上", (width - textWidth2) / 2, height - textHeight - 15, paint)
    }
}