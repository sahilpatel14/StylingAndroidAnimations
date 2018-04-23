package com.ninthsemester.stylingandroidanimations;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sahil-mac on 04/04/18.
 */

public class HighlightedTextView extends AppCompatTextView {

    private Pattern pattern;
    private int highlightStyle = Typeface.BOLD;

    public HighlightedTextView(Context context) {
        this(context, null);
    }

    public HighlightedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HighlightedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        /*
         * todo 3
         * here we are going to initialise the styleable defined and read the input from the
         * xml layout view.
         */

        //  Initialising the styleable
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HighlightedTextView, defStyle, 0);

        //  Getting the text for the textview.
        CharSequence text = ta.getString(R.styleable.HighlightedTextView_android_text);

        //  IF a text ws set, we update it.
        if (text != null) {
            updateText(text);
        }

        //  Reading the user entered pattern.
        String pattern = ta.getString(R.styleable.HighlightedTextView_pattern);
        if (pattern != null) {
            setPattern(pattern);
        }

        //  Reading the user entered style.
        int style = ta.getInteger(R.styleable.HighlightedTextView_highlightStyle, -1);
        if (style >= 0) {
            setHighlightStyle(style);
        }

        //  Very important to call recycle. This would force the GPU to redraw the whole view.
        ta.recycle();
    }

    public String getPattern() {
        return pattern.pattern();
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : Pattern.compile(pattern);
        updateText(getText());
    }

    public int getHighlightStyle() {
        return highlightStyle;
    }

    public void setHighlightStyle(int highlightStyle) {
        this.highlightStyle = highlightStyle;
        updateText(getText());
    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        updateText(text);
    }

    public void updateText(CharSequence text) {

        Spannable spannable = new SpannableString(text);
        if (pattern != null) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                StyleSpan span = new StyleSpan(highlightStyle);
                spannable.setSpan(span, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }
        super.setText(spannable, BufferType.SPANNABLE);
    }
}
