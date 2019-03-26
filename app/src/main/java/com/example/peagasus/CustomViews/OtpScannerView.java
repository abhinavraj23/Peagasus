package com.example.peagasus.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class OtpScannerView extends RelativeLayout {
    public OtpScannerView(Context context) {
        super(context);
    }

    public OtpScannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OtpScannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OtpScannerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
