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


/**
 * todo 1
 *
 * This is our custom TextView which bolds the text at certain
 * places based on the pattern.
 */

public class HighlightedTextView extends AppCompatTextView {

    //  The pattern based on which we will style the text.
    private Pattern pattern;

    //  The style which will be applied on the pattern.
    private int highlightStyle = Typeface.BOLD;

    /*
     * There are three constructors for three very specific purposes.
     * Generally we can do with just the first one. The other two are
     * used if we want the flexibility to update the TextView from styles.
     *
     */
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


    /**
     * Saves the pattern if it is valid and the calls updateText.
     * UpdateText would style the text based on pattern and then
     * call setText with this new text.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : Pattern.compile(pattern);
        updateText(getText());
    }

    public int getHighlightStyle() {
        return highlightStyle;
    }

    /**
     * Add a new style and calling updateText.
     */
    public void setHighlightStyle(int highlightStyle) {
        this.highlightStyle = highlightStyle;
        updateText(getText());
    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        updateText(text);
    }

    /**
     * Here we use the spannable String to span styled text in String
     * based on the pattern.
     */
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
