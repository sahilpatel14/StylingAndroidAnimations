package com.ninthsemester.stylingandroidanimations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * todo 3
         * We set a pattern on which the style will be applied.
         */
        HighlightedText.pattern = ("[Hh]ighlight")
    }
}
