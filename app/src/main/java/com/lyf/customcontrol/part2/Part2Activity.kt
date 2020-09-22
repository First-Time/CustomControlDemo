package com.lyf.customcontrol.part2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lyf.customcontrol.R
import com.lyf.customcontrol.main.DividerGridItemDecoration
import kotlinx.android.synthetic.main.activity_part2.*

class Part2Activity : AppCompatActivity() {

    private lateinit var itemList: ArrayList<String>

    private lateinit var myAdapter: Part2Adapter
    private lateinit var myLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part2)

        itemList = arrayListOf(
            "CircleActivity",
            "LineActivity",
            "PointActivity",
            "RectActivity",
            "OvalActivity",
            "ArcActivity",
            "LinePathActivity",
            "RectPathActivity",
            "RoundRectPathActivity",
            "CirclePathActivity",
            "OvalPathActivity",
            "ArcPathActivity",
            "QuadPathActivity",
            "TextExample01Activity",
            "TextExample02Activity",
            "TextExample03Activity",
            "TextPosActivity",
            "TextPathActivity",
            "TextTypefaceSystemActivity",
            "TextTypefaceCustomActivity",
            "RegionConstructActivity",
            "RegionSetPathActivity",
            "RegionOpActivity",
            "TranslateActivity",
            "RotateActivity",
            "ScaleActivity",
            "ClipActivity",
            "SkewActivity",
            "SaveRestoreActivity",
            "BlogDrawActivity",
            "FontMetricsActivity",
            "WidthHeightActivity",
            "MyTopActivity",
            "MyCenterActivity",
            "QuadraticActivity",
            "GestureLineToActivity",
            "GestureQuadToActivity",
            "RQuadraticActivity",
            "WaveActivity",
            "StrokeCapActivity",
            "StrokeJoinActivity",
            "CornerPathActivity",
            "DashPathActivity",
            "DiscretePathActivity",
            "PathDashPathActivity",
            "ComposeSumPathActivity",
            "SingleChannelActivity",
            "MultiChannelActivity",
            "TranslateChannelActivity",
            "ReverseChannelActivity",
            "ScaleChannelActivity",
            "RotateRedActivity",
            "RotateGreenActivity",
            "RotateBlueActivity",
            "BlackWhiteActivity",
            "InverseActivity",
            "OldActivity",
            "SaturationActivity",
            "ScaleActivity",
            "RotateActivity",
            "ColorMatrixActivity",
            "LightingActivity",
            "MultiplyActivity",
            "PorterDuffXfermodeActivity",
            "PorterDuffXfermodeActivity2",
            "TwitterActivity",
            "RoundCornerActivity",
            "InvertedImageActivity",
            "EraserActivity",
            "ScratchCardActivity",
            "MyRoundCornerActivity",
            "MyInvertedImageActivity",
            "CircleWaveActivity",
            "HeartMapActivity",
            "IrregularityWaveActivity",
            "BitmapCanvasActivity",
            "QqRedPointActivity",
            "ShadowGlowActivity",
            "ShadowLayerActivity",
            "BlurMaskFilterActivity",
            "ExtractAlphaActivity",
            "ShadowControlActivity",
            "BitmapShaderActivity",
            "TelescopeActivity",
            "CircleImageActivity",
            "AvatarActivity",
            "LinearGradientActivity",
            "MultipleLinearGradientActivity",
            "FlashStringActivity",
            "RadialGradientActivity",
            "MultipleRadialGradientActivity",
            "WaterRippleActivity"
        )

        myAdapter = Part2Adapter(itemList)
//        myLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        myLayoutManager = GridLayoutManager(this, 2)
        myLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = myLayoutManager

//        var gridItemDecoration = GridDividerItemDecoration(5, Color.RED)
//        recyclerView.addItemDecoration(gridItemDecoration)

        var dividerGridItemDecoration =
            DividerGridItemDecoration(this)
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
