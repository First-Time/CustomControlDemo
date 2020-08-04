package com.lyf.customcontrol.part2.colormatrix08.rotate.red

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_rotate_red.*

class RotateRedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate_red)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@RotateRedActivity, "当前值：$progress", Toast.LENGTH_LONG).show()
                myRotateRedView.postInvalidate(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                seekBar?.setBackgroundColor(Color.YELLOW)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.setBackgroundColor(Color.TRANSPARENT)
            }

        })

        seekBar.progress = 1
    }
}