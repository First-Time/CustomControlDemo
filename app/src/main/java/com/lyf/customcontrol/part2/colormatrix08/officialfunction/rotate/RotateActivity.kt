package com.lyf.customcontrol.part2.colormatrix08.officialfunction.rotate

import android.graphics.*
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_scale2.*

class RotateActivity : AppCompatActivity() {
    private lateinit var originalBitmap: Bitmap
    private lateinit var tempBitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate2)

        originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
        tempBitmap = Bitmap.createBitmap(
            originalBitmap.width,
            originalBitmap.height,
            Bitmap.Config.ARGB_8888
        )

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@RotateActivity, "当前值：$progress", Toast.LENGTH_LONG).show()
                val bitmap = handleColorMatrixBitmap(progress)
                imageView.setImageBitmap(bitmap)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        seekBar.progress = 180
    }

    private fun handleColorMatrixBitmap(progress: Int): Bitmap {
        val canvas = Canvas(tempBitmap)
        val paint = Paint()
        paint.isAntiAlias = true
        val colorMatrix = ColorMatrix()
        colorMatrix.setRotate(0, (progress - 180).toFloat())
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(originalBitmap, 0f, 0f, paint)
        return tempBitmap
    }
}