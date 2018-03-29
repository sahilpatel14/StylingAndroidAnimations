package com.ninthsemester.stylingandroidanimations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        BackButton.setOnClickListener(goBack())
    }

    private fun goBack() : (View)->Unit = {
        finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onBackPressed() {
        BackButton.performClick()
    }
}
