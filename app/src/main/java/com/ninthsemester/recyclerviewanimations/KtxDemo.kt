package com.ninthsemester.recyclerviewanimations

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.animation.addListener

/**
 * Created by sahil-mac on 29/03/18.
 */


class Tundra : Activity(){

    val animator : ValueAnimator by lazy {
        ObjectAnimator.ofFloat(12f)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        animator.addListener(
                onEnd = {

                },
                onStart = {},
                onCancel = {}
        )
    }

}
