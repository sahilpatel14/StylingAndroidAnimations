package com.ninthsemester.stylingandroidanimations

import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        NextButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(FirstActivity@this, R.anim.fade_out)
            it.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener {

                override fun onAnimationEnd(animation: Animation?) {
                    it.visibility = View.INVISIBLE
                    openActivity(SecondActivity::class.java)
                }

                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationRepeat(animation: Animation?) {}

            })
        }
    }

    override fun onResume() {
        super.onResume()
        NextButton.visibility = View.VISIBLE
    }

    private fun <T> openActivity(activity: Class<T>) {
        startActivity(Intent(MainActivity@this, activity))
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
    }


}
