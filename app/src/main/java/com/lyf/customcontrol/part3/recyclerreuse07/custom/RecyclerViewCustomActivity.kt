package com.lyf.customcontrol.part3.recyclerreuse07.custom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_recycler_view_custom.*

class RecyclerViewCustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_custom)

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