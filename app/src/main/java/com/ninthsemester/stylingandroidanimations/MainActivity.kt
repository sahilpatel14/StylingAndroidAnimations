package com.ninthsemester.stylingandroidanimations

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.graphics.drawable.Animatable2Compat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
         * todo 6
         * getting reference to drawable from layout and
         * starting the animation. It is really important that
         * we only start the animation if drawable is of type Animatable.
         */
        val drawable = imageView.drawable
        if (drawable is Animatable) {
            drawable.start()
        }
    }
}
