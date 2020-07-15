package com.lyf.customcontrol.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lyf.customcontrol.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var itemList: ArrayList<String>

    lateinit var myAdapter: MainAdapter
    lateinit var myLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemList = arrayListOf(
            "跳转CircleActivity",
            "跳转LineActivity",
            "跳转PointActivity",
            "跳转RectActivity",
            "跳转OvalActivity",
            "跳转ArcActivity",
            "跳转LinePathActivity",
            "跳转RectPathActivity",
            "跳转RoundRectPathActivity",
            "跳转CirclePathActivity",
            "跳转OvalPathActivity",
            "跳转ArcPathActivity",
            "跳转QuadPathActivity",
            "跳转TextExample01Activity",
            "跳转TextExample02Activity",
            "跳转TextExample03Activity",
            "跳转TextPosActivity",
            "跳转TextPathActivity",
            "跳转TextTypefaceSystemActivity",
            "跳转TextTypefaceCustomActivity",
            "跳转RegionConstructActivity",
            "跳转RegionSetPathActivity",
            "跳转RegionOpActivity"
        )

        myAdapter = MainAdapter(itemList)
//        myLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        myLayoutManager = GridLayoutManager(this, 2)
        myLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = myLayoutManager

//        var gridItemDecoration = GridDividerItemDecoration(5, Color.RED)
//        recyclerView.addItemDecoration(gridItemDecoration)

        var dividerGridItemDecoration = DividerGridItemDecoration(this)
        recyclerView.addItemDecoration(dividerGridItemDecoration)

//        var verticalItemDecoration =
//            DividerItemDecoration(this, (myLayoutManager as LinearLayoutManager).orientation)
//        verticalItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_main_vertical))
//        recyclerView.addItemDecoration(verticalItemDecoration)

//        var horizontalItemDecoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
//        horizontalItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_main_horizontal))
//        recyclerView.addItemDecoration(horizontalItemDecoration)

        recyclerView.itemAnimator = DefaultItemAnimator()


        recyclerView.adapter = myAdapter
    }
}
