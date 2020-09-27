package com.lyf.customcontrol.part3.layoutmanager06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_custom_layout_manager.*

class CustomLayoutManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_layout_manager)

        val dataList = getData()

        //线性布局
        val layoutManager = CustomLayoutManager()
        recyclerView.layoutManager = layoutManager

        val myAdapter = RecyclerViewAdapter(dataList)
        recyclerView.adapter = myAdapter
    }

    private fun getData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0..50) {
            list.add("第${i}组")
            for (j in 1..9) {
                list.add("第${i}${j}个item")
            }
        }
        return list
    }
}