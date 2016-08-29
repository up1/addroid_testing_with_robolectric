package com.workshop.customviewdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.workshop.customviewdemo.R;

public class LoadingView extends RelativeLayout {
    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void stopLoadingAndSetText(int resourceId) {
        TextView textView = (TextView) findViewById(R.id.loading_text_view);
        textView.setText(resourceId);
        textView.setVisibility(View.VISIBLE);

        findViewById(R.id.loading_view_spinner).setVisibility(View.GONE);
    }
}
