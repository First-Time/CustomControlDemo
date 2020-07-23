package com.lyf.customcontrol.part2.paint07.patheffect.dashpath

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_dash_path.*

class DashPathActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_path)

        btn_start.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                myDashPathView.startAnim()
            }
        })

        btn_end.setOnClickListener { myDashPathView.endAnim() }

        btn_cancel.setOnClickListener { myDashPathView.cancelAnim() }

        btn_pause.setOnClickListener { myDashPathView.pauseAnim() }

        btn_resume.setOnClickListener { myDashPathView.resumeAnim() }
    }
}