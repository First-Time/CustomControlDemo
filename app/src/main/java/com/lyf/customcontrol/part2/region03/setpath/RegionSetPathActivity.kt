package com.lyf.customcontrol.part2.region03.setpath

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_region_set_path.*

class RegionSetPathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_set_path)

        root.addView(MyRegionSetPathView(this))
    }
}
