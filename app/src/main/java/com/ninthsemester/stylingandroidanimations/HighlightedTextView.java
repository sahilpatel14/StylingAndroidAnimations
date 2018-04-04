package com.ninthsemester.stylingandroidanimations;

import android.content.Context;
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

    public void setHighlightStyle() {
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