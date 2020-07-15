package com.lyf.customcontrol.part2.region04.saverestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_save_restore.*

class SaveRestoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_restore)

        root.addView(MySaveRestoreView(this))
    }
}
