package com.lyf.customcontrol.part2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lyf.customcontrol.R
import com.lyf.customcontrol.part2.bitmapshadow17.bitmapshadow.ExtractAlphaActivity
import com.lyf.customcontrol.part2.bitmapshadow17.encapsulation.ShadowControlActivity
import com.lyf.customcontrol.part2.bitmapshader18.bitmapshader.BitmapShaderActivity
import com.lyf.customcontrol.part2.bitmapshader18.circleimage.CircleImageActivity
import com.lyf.customcontrol.part2.bitmapshader18.encapsulation.AvatarActivity
import com.lyf.customcontrol.part2.bitmapshader18.telescope.TelescopeActivity
import com.lyf.customcontrol.part2.canvas13.ondraw.BitmapCanvasActivity
import com.lyf.customcontrol.part2.colorfilter09.colormatrix.ColorMatrixActivity
import com.lyf.customcontrol.part2.colorfilter09.lighting.LightingActivity
import com.lyf.customcontrol.part2.colorfilter09.porterduff.PorterDuffActivity
import com.lyf.customcontrol.part2.colormatrix08.multichannel.MultiChannelActivity
import com.lyf.customcontrol.part2.colormatrix08.officialfunction.saturation.SaturationActivity
import com.lyf.customcontrol.part2.colormatrix08.projection.blackwhite.BlackWhiteActivity
import com.lyf.customcontrol.part2.colormatrix08.projection.inverse.InverseActivity
import com.lyf.customcontrol.part2.colormatrix08.projection.old.OldActivity
import com.lyf.customcontrol.part2.colormatrix08.reverse.ReverseChannelActivity
import com.lyf.customcontrol.part2.colormatrix08.rotate.blue.RotateBlueActivity
import com.lyf.customcontrol.part2.colormatrix08.rotate.green.RotateGreenActivity
import com.lyf.customcontrol.part2.colormatrix08.rotate.red.RotateRedActivity
import com.lyf.customcontrol.part2.colormatrix08.scale.ScaleChannelActivity
import com.lyf.customcontrol.part2.colormatrix08.singlechannel.SingleChannelActivity
import com.lyf.customcontrol.part2.colormatrix08.translate.TranslateChannelActivity
import com.lyf.customcontrol.part2.draw01.arc.ArcActivity
import com.lyf.customcontrol.part2.draw01.circle.CircleActivity
import com.lyf.customcontrol.part2.draw01.line.LineActivity
import com.lyf.customcontrol.part2.draw01.oval.OvalActivity
import com.lyf.customcontrol.part2.draw01.point.PointActivity
import com.lyf.customcontrol.part2.draw01.rect.RectActivity
import com.lyf.customcontrol.part2.lineargradient19.flashstring.FlashStringActivity
import com.lyf.customcontrol.part2.lineargradient19.multiplegradient.MultipleLinearGradientActivity
import com.lyf.customcontrol.part2.lineargradient19.twocolorgradient.LinearGradientActivity
import com.lyf.customcontrol.part2.paint07.patheffect.composesumpath.ComposeSumPathActivity
import com.lyf.customcontrol.part2.paint07.patheffect.cornerpath.CornerPathActivity
import com.lyf.customcontrol.part2.paint07.patheffect.dashpath.DashPathActivity
import com.lyf.customcontrol.part2.paint07.patheffect.discretepath.DiscretePathActivity
import com.lyf.customcontrol.part2.paint07.patheffect.pathdashpath.PathDashPathActivity
import com.lyf.customcontrol.part2.paint07.strokecap.StrokeCapActivity
import com.lyf.customcontrol.part2.paint07.strokejoin.StrokeJoinActivity
import com.lyf.customcontrol.part2.pathquadto06.gesture.lineto.GestureLineToActivity
import com.lyf.customcontrol.part2.pathquadto06.gesture.quadto.GestureQuadToActivity
import com.lyf.customcontrol.part2.pathquadto06.quadratic.QuadraticActivity
import com.lyf.customcontrol.part2.pathquadto06.rquadto.RQuadraticActivity
import com.lyf.customcontrol.part2.pathquadto06.wave.WaveActivity
import com.lyf.customcontrol.part2.pathtext02.path.arc.ArcPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.circle.CirclePathActivity
import com.lyf.customcontrol.part2.pathtext02.path.line.LinePathActivity
import com.lyf.customcontrol.part2.pathtext02.path.oval.OvalPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.quad.QuadPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.rect.RectPathActivity
import com.lyf.customcontrol.part2.pathtext02.path.roundrect.RoundRectPathActivity
import com.lyf.customcontrol.part2.pathtext02.text.example01.TextExample01Activity
import com.lyf.customcontrol.part2.pathtext02.text.example02.TextExample02Activity
import com.lyf.customcontrol.part2.pathtext02.text.example03.TextExample03Activity
import com.lyf.customcontrol.part2.pathtext02.text.path.TextPathActivity
import com.lyf.customcontrol.part2.pathtext02.text.pos.TextPosActivity
import com.lyf.customcontrol.part2.pathtext02.text.typeface.custom.TextTypefaceCustomActivity
import com.lyf.customcontrol.part2.pathtext02.text.typeface.system.TextTypefaceSystemActivity
import com.lyf.customcontrol.part2.qqredpoint15.QqRedPointActivity
import com.lyf.customcontrol.part2.radialgradient20.multiplecolorgradient.MultipleRadialGradientActivity
import com.lyf.customcontrol.part2.radialgradient20.twocolorgradient.RadialGradientActivity
import com.lyf.customcontrol.part2.radialgradient20.waterripple.WaterRippleActivity
import com.lyf.customcontrol.part2.region03.construct.RegionConstructActivity
import com.lyf.customcontrol.part2.region03.op.RegionOpActivity
import com.lyf.customcontrol.part2.region03.setpath.RegionSetPathActivity
import com.lyf.customcontrol.part2.region04.clip.ClipActivity
import com.lyf.customcontrol.part2.region04.rotate.RotateActivity
import com.lyf.customcontrol.part2.region04.saverestore.SaveRestoreActivity
import com.lyf.customcontrol.part2.region04.scale.ScaleActivity
import com.lyf.customcontrol.part2.region04.skew.SkewActivity
import com.lyf.customcontrol.part2.region04.translate.TranslateActivity
import com.lyf.customcontrol.part2.setxfermode10.PorterDuffXfermodeActivity
import com.lyf.customcontrol.part2.setxfermode10.PorterDuffXfermodeActivity2
import com.lyf.customcontrol.part2.setxfermode11.srcin.invertedimage.InvertedImageActivity
import com.lyf.customcontrol.part2.setxfermode11.srcin.roundcorner.RoundCornerActivity
import com.lyf.customcontrol.part2.setxfermode11.srcout.eraser.EraserActivity
import com.lyf.customcontrol.part2.setxfermode11.srcout.scratchcard.ScratchCardActivity
import com.lyf.customcontrol.part2.setxfermode11.twitter.TwitterActivity
import com.lyf.customcontrol.part2.setxfermode12.dstin.circlewave.CircleWaveActivity
import com.lyf.customcontrol.part2.setxfermode12.dstin.heartmap.HeartMapActivity
import com.lyf.customcontrol.part2.setxfermode12.dstin.invertedimage.MyInvertedImageActivity
import com.lyf.customcontrol.part2.setxfermode12.dstin.irregularitywave.IrregularityWaveActivity
import com.lyf.customcontrol.part2.setxfermode12.dstin.roundcorner.MyRoundCornerActivity
import com.lyf.customcontrol.part2.shadowglow16.layerlist.ShadowGlowActivity
import com.lyf.customcontrol.part2.shadowglow16.setmaskfilter.BlurMaskFilterActivity
import com.lyf.customcontrol.part2.shadowglow16.setshadowlayer.ShadowLayerActivity
import com.lyf.customcontrol.part2.text05.fixedpointwrite.center.MyCenterActivity
import com.lyf.customcontrol.part2.text05.fixedpointwrite.top.MyTopTextActivity
import com.lyf.customcontrol.part2.text05.fontmetrics.FontMetricsActivity
import com.lyf.customcontrol.part2.text05.fourlineandbase.BlogDrawActivity
import com.lyf.customcontrol.part2.text05.widthheightrect.WidthHeightActivity

class Part2Adapter(private var activities: ArrayList<String>) :
    RecyclerView.Adapter<Part2Adapter.JumpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JumpViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_part2_activity, parent, false)
        return JumpViewHolder(view)
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    override fun onBindViewHolder(holder: JumpViewHolder, position: Int) {
        val itemStr = activities[position]
        holder.tvNameJump.text = itemStr
//        val random = Random
//        holder.tvNameJump.height = random.nextInt(500, 2000)

        holder.tvNameJump.setOnClickListener {
            when (position) {
                0 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            CircleActivity::class.java
                        )
                    )
                }
                1 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            LineActivity::class.java
                        )
                    )
                }
                2 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PointActivity::class.java
                        )
                    )
                }
                3 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RectActivity::class.java
                        )
                    )
                }
                4 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            OvalActivity::class.java
                        )
                    )
                }
                5 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ArcActivity::class.java
                        )
                    )
                }
                6 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            LinePathActivity::class.java
                        )
                    )
                }
                7 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RectPathActivity::class.java
                        )
                    )
                }
                8 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RoundRectPathActivity::class.java
                        )
                    )
                }
                9 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            CirclePathActivity::class.java
                        )
                    )
                }
                10 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            OvalPathActivity::class.java
                        )
                    )
                }
                11 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ArcPathActivity::class.java
                        )
                    )
                }
                12 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            QuadPathActivity::class.java
                        )
                    )
                }
                13 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextExample01Activity::class.java
                        )
                    )
                }
                14 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextExample02Activity::class.java
                        )
                    )
                }
                15 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextExample03Activity::class.java
                        )
                    )
                }
                16 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextPosActivity::class.java
                        )
                    )
                }
                17 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextPathActivity::class.java
                        )
                    )
                }
                18 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextTypefaceSystemActivity::class.java
                        )
                    )
                }
                19 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TextTypefaceCustomActivity::class.java
                        )
                    )
                }
                20 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RegionConstructActivity::class.java
                        )
                    )
                }
                21 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RegionSetPathActivity::class.java
                        )
                    )
                }
                22 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RegionOpActivity::class.java
                        )
                    )
                }
                23 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TranslateActivity::class.java
                        )
                    )
                }
                24 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RotateActivity::class.java
                        )
                    )
                }
                25 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ScaleActivity::class.java
                        )
                    )
                }
                26 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ClipActivity::class.java
                        )
                    )
                }
                27 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            SkewActivity::class.java
                        )
                    )
                }
                28 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            SaveRestoreActivity::class.java
                        )
                    )
                }
                29 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            BlogDrawActivity::class.java
                        )
                    )
                }
                30 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            FontMetricsActivity::class.java
                        )
                    )
                }
                31 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            WidthHeightActivity::class.java
                        )
                    )
                }
                32 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MyTopTextActivity::class.java
                        )
                    )
                }
                33 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MyCenterActivity::class.java
                        )
                    )
                }
                34 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            QuadraticActivity::class.java
                        )
                    )
                }
                35 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            GestureLineToActivity::class.java
                        )
                    )
                }
                36 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            GestureQuadToActivity::class.java
                        )
                    )
                }
                37 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RQuadraticActivity::class.java
                        )
                    )
                }
                38 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            WaveActivity::class.java
                        )
                    )
                }
                39 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            StrokeCapActivity::class.java
                        )
                    )
                }
                40 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            StrokeJoinActivity::class.java
                        )
                    )
                }
                41 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            CornerPathActivity::class.java
                        )
                    )
                }
                42 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            DashPathActivity::class.java
                        )
                    )
                }
                43 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            DiscretePathActivity::class.java
                        )
                    )
                }
                44 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PathDashPathActivity::class.java
                        )
                    )
                }
                45 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ComposeSumPathActivity::class.java
                        )
                    )
                }
                46 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            SingleChannelActivity::class.java
                        )
                    )
                }
                47 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MultiChannelActivity::class.java
                        )
                    )
                }
                48 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TranslateChannelActivity::class.java
                        )
                    )
                }
                49 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ReverseChannelActivity::class.java
                        )
                    )
                }
                50 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ScaleChannelActivity::class.java
                        )
                    )
                }
                51 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RotateRedActivity::class.java
                        )
                    )
                }
                52 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RotateGreenActivity::class.java
                        )
                    )
                }
                53 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RotateBlueActivity::class.java
                        )
                    )
                }
                54 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            BlackWhiteActivity::class.java
                        )
                    )
                }
                55 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            InverseActivity::class.java
                        )
                    )
                }
                56 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            OldActivity::class.java
                        )
                    )
                }
                57 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            SaturationActivity::class.java
                        )
                    )
                }
                58 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            com.lyf.customcontrol.part2.colormatrix08.officialfunction.scale.ScaleActivity::class.java
                        )
                    )
                }
                59 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            com.lyf.customcontrol.part2.colormatrix08.officialfunction.rotate.RotateActivity::class.java
                        )
                    )
                }
                60 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ColorMatrixActivity::class.java
                        )
                    )
                }
                61 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            LightingActivity::class.java
                        )
                    )
                }
                62 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PorterDuffActivity::class.java
                        )
                    )
                }
                63 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PorterDuffXfermodeActivity::class.java
                        )
                    )
                }
                64 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            PorterDuffXfermodeActivity2::class.java
                        )
                    )
                }
                65 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TwitterActivity::class.java
                        )
                    )
                }
                66 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RoundCornerActivity::class.java
                        )
                    )
                }
                67 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            InvertedImageActivity::class.java
                        )
                    )
                }
                68 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            EraserActivity::class.java
                        )
                    )
                }
                69 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ScratchCardActivity::class.java
                        )
                    )
                }
                70 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MyRoundCornerActivity::class.java
                        )
                    )
                }
                71 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MyInvertedImageActivity::class.java
                        )
                    )
                }
                72 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            CircleWaveActivity::class.java
                        )
                    )
                }
                73 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            HeartMapActivity::class.java
                        )
                    )
                }
                74 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            IrregularityWaveActivity::class.java
                        )
                    )
                }
                75 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            BitmapCanvasActivity::class.java
                        )
                    )
                }
                76 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            QqRedPointActivity::class.java
                        )
                    )
                }
                77 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ShadowGlowActivity::class.java
                        )
                    )
                }
                78 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ShadowLayerActivity::class.java
                        )
                    )
                }
                79 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            BlurMaskFilterActivity::class.java
                        )
                    )
                }
                80 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ExtractAlphaActivity::class.java
                        )
                    )
                }
                81 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            ShadowControlActivity::class.java
                        )
                    )
                }
                82 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            BitmapShaderActivity::class.java
                        )
                    )
                }
                83 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            TelescopeActivity::class.java
                        )
                    )
                }
                84 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            CircleImageActivity::class.java
                        )
                    )
                }
                85 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            AvatarActivity::class.java
                        )
                    )
                }
                86 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            LinearGradientActivity::class.java
                        )
                    )
                }
                87 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MultipleLinearGradientActivity::class.java
                        )
                    )
                }
                88 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            FlashStringActivity::class.java
                        )
                    )
                }
                89 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            RadialGradientActivity::class.java
                        )
                    )
                }
                90 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            MultipleRadialGradientActivity::class.java
                        )
                    )
                }
                91 -> {
                    holder.tvNameJump.context.startActivity(
                        Intent(
                            holder.tvNameJump.context,
                            WaterRippleActivity::class.java
                        )
                    )
                }
            }
        }
    }

    class JumpViewHolder(itemView: View) : ViewHolder(itemView) {
        var tvNameJump: AppCompatTextView = itemView.findViewById(R.id.tv_main_jump)
    }
}