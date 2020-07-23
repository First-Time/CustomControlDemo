package com.lyf.customcontrol.part2.paint07.patheffect.pathdashpath

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_path_dash_path.*

class PathDashPathActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_dash_path)

        btn_start.setOnClickListener { myPathDashPathView.startAnim() }

        btn_end.setOnClickListener { myPathDashPathView.endAnim() }

        btn_cancel.setOnClickListener { myPathDashPathView.cancelAnim() }

        btn_pause.setOnClickListener { myPathDashPathView.pauseAnim() }

        btn_resume.setOnClickListener { myPathDashPathView.resumeAnim() }
    }
}