package com.lyf.customcontrol.part3.recyclercoverflow09.overlay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_reuse_animator_custom.*

class OverlayFlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overlay_flow)

        val dataList = getData()

        //线性布局
        val layoutManager = CoverFlowLayoutManager()

        recyclerView.layoutManager = layoutManager

        val myAdapter = CoverFlowAdapter(this, dataList)
        recyclerView.adapter = myAdapter
    }

    private fun getData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (j in 0..100) {
            list.add("第${j}个item")
        }
        return list
    }
}