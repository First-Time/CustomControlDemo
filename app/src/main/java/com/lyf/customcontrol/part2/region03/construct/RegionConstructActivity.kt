package com.lyf.customcontrol.part2.region03.construct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_region_construct.*

class RegionConstructActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_construct)

        root.addView(MyRegionView(this))
    }
}
