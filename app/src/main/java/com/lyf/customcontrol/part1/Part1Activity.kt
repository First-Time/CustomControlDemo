package com.lyf.customcontrol.part1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lyf.customcontrol.R
import com.lyf.customcontrol.main.DividerGridItemDecoration
import kotlinx.android.synthetic.main.activity_part1.*

class Part1Activity : AppCompatActivity() {

    private lateinit var itemList: ArrayList<String>

    private lateinit var myAdapter: Part1Adapter
    private lateinit var myLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part1)

        itemList = arrayListOf(
            "AnimationActivity",
            "InterpolatorActivity",
            "AnimationCodeActivity",
            "ValueAnimatorBasicActivity",
            "ValueAnimatorInterpolatorActivity",
            "ValueAnimatorOfObjectActivity",
            "PointObjectActivity",
            "ObjectAnimatorActivity",
            "PointObjectAnimatorActivity",
            "PropertyValuesHolderActivity",
            "PropertyValuesHolderOfObjectActivity",
            "KeyFrameActivity",
            "UnitAnimatorCodeActivity",
            "ValueAnimatorTransitionXmlActivity",
            "ValueAnimatorColorXmlActivity",
            "ObjectAnimatorTranslationXmlActivity",
            "ObjectAnimatorColorXmlActivity",
            "AnimatorSetTransitionXmlActivity",
            "AnimatorMenuActivity",
            "ListViewAnimationActivity",
            "ListViewAnimationCodeActivity",
            "GridViewAnimationXmlActivity",
            "GridViewAnimationCodeActivity",
            "AnimateLayoutChangesActivity",
            "ListViewItemEnterAnimatorActivity"
        )

        myAdapter = Part1Adapter(itemList)
//        myLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        myLayoutManager = GridLayoutManager(this, 3)
//        myLayoutManager = LinearLayoutManager(this)
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
