package com.example.mylynx.constraintlayoutprogrammatically

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.util.Log
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var MA_view = findViewById<ConstraintLayout>(R.id.Ma_constraintLayoutId)
        var MA_relLayout = findViewById<RelativeLayout>(R.id.Ma_relLayoutId)


        var relativeLayout = RelativeLayout(this)
        relativeLayout.setBackgroundColor(Color.parseColor("#d2d2d2"))
        relativeLayout.id = R.id.addedRelLayout

        var layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                200
        )



        MA_view.addView(relativeLayout, layoutParams)



        var constrLayoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
        )
       // constrLayoutParams.setMargins(8,8,8,8);
//        set.clear(R.id.bottomText, ConstraintSet.TOP);
        MA_relLayout.layoutParams = constrLayoutParams

    //    MA_view.removeView(MA_relLayout)


        Log.d("ilość view w CLayout" , "${MA_view.childCount}")
        var constraintSet = ConstraintSet()
        constraintSet.clone(MA_view)
        constraintSet.connect(relativeLayout.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)


     //   constraintSet.clear(MA_relLayout.id,ConstraintSet.BOTTOM)

        constraintSet.connect(MA_relLayout.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
        constraintSet.connect(MA_relLayout.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
        constraintSet.connect(MA_relLayout.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
    //    constraintSet.connect(MA_relLayout.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet.connect(MA_relLayout.id, ConstraintSet.BOTTOM, relativeLayout.id, ConstraintSet.TOP)
        constraintSet.applyTo(MA_view)

       // MA_view.addView(MA_relLayout, constrLayoutParams)




    }
}
