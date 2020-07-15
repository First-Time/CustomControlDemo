package com.lyf.customcontrol.part2.pathtext02.path.oval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_oval_path.*

class OvalPathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oval_path)

        root.addView(MyOvalPathView(this))
    }
}
