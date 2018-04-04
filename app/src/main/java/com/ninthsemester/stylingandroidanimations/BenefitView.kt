package com.ninthsemester.stylingandroidanimations

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by sahil-mac on 04/04/18.
 */
class BenefitView(context: Context, attrs : AttributeSet) : LinearLayout(context, attrs) {

    init {
        inflate(context, R.layout.benifit_view, this)

        val imageView : ImageView = findViewById(R.id.image)
        val textView : TextView = findViewById(R.id.caption)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BenefitView)

        imageView.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
        textView.text = attributes.getString(R.styleable.BenefitView_caption)
        attributes.recycle()
    }

}