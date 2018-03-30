package com.ninthsemester.stylingandroidanimations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        BackButton.setOnClickListener { view ->

            AnimationUtils.loadAnimation(SecondActivity@ this, R.anim.grow_spin)
                    .apply {
                        setAnimationListener(object : Animation.AnimationListener {

                            override fun onAnimationEnd(animation: Animation?) {
                                view.visibility = View.INVISIBLE
                                goBack()
                            }

                            override fun onAnimationStart(animation: Animation?) {}
                            override fun onAnimationRepeat(animation: Animation?) {}
                        })
                        view.startAnimation(this)
                    }

        }
    }

    private fun goBack() {
        finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onResume() {
        super.onResume()
        BackButton.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        BackButton.performClick()
    }
}
