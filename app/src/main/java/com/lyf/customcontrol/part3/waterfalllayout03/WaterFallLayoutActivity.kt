package com.lyf.customcontrol.part3.waterfalllayout03

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_water_fall_layout.*
import kotlin.random.Random

class WaterFallLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_fall_layout)

        btn_add_image.setOnClickListener {
            val imageView = AppCompatImageView(this@WaterFallLayoutActivity)
            when (Random.nextInt(1, 10)) {
                1 -> {
                    resetImageSize(imageView, R.drawable.img_1)
                    imageView.setBackgroundResource(R.drawable.img_1)
                }
                2 -> {
                    resetImageSize(imageView, R.drawable.img_2)
                    imageView.setBackgroundResource(R.drawable.img_2)
                }
                3 -> {
                    resetImageSize(imageView, R.drawable.img_3)
                    imageView.setBackgroundResource(R.drawable.img_3)
                }
                4 -> {
                    resetImageSize(imageView, R.drawable.img_4)
                    imageView.setBackgroundResource(R.drawable.img_4)
                }
                5 -> {
                    resetImageSize(imageView, R.drawable.img_5)
                    imageView.setBackgroundResource(R.drawable.img_5)
                }
                6 -> {
                    resetImageSize(imageView, R.drawable.img_6)
                    imageView.setBackgroundResource(R.drawable.img_6)
                }
                7 -> {
                    resetImageSize(imageView, R.drawable.img_7)
                    imageView.setBackgroundResource(R.drawable.img_7)
                }
                8 -> {
                    resetImageSize(imageView, R.drawable.img_8)
                    imageView.setBackgroundResource(R.drawable.img_8)
                }
                9 -> {
                    resetImageSize(imageView, R.drawable.img_9)
                    imageView.setBackgroundResource(R.drawable.img_9)
                }
            }
            water_fall_layout.addView(imageView)
        }
        water_fall_layout.setOnItemClickListener(object :
            MyWaterFallLayoutView.OnItemClickListener {
            override fun onItemClick(view: View, index: Int) {
                Toast.makeText(this@WaterFallLayoutActivity, "item = $index", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    private fun resetImageSize(imageView: AppCompatImageView, drawableId: Int) {
        val drawable = resources.getDrawable(drawableId)
        val drawableWidth = drawable.minimumWidth
        val drawableHeight = drawable.minimumHeight
        if (drawableWidth > resources.displayMetrics.widthPixels) {
            val layoutParams = ViewGroup.LayoutParams(
                resources.displayMetrics.widthPixels,
                (drawableHeight.toFloat() * resources.displayMetrics.widthPixels / drawableWidth).toInt()
            )
            imageView.layoutParams = layoutParams
        }
    }

}