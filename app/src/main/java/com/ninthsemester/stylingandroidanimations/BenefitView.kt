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

    /**
     *  todo 4
     *
     *  This is our benefit view class. First we use the inflater to inflate
     *  out custom view. Firstly, we inflate the layout [res/layout/benefit_view.xml]
     *
     *  Then we initialize both the child components and initialize the styleable
     *  attribute defined for BenefitView.
     *
     *  After that we set the image on imageView and text on textView based on the
     *  input set from styleable attribute.
     *
     *  Lastly we call attributes.recycle() to render those changes.
     */

    init {
        inflate(context, R.layout.benefit_view, this)

        val imageView : ImageView = findViewById(R.id.image)
        val textView : TextView = findViewById(R.id.caption)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BenefitView)

        imageView.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
        textView.text = attributes.getString(R.styleable.BenefitView_caption)
        attributes.recycle()
    }

}