package com.example.nurshat.runumberplateview;

/**
 * Created by Nurshat on 04.06.2017.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.nurshat.runumberplateview.Entity.Config;
import com.example.nurshat.runumberplateview.Interfaces.NumberPlatePresenter;
import com.example.nurshat.runumberplateview.Interfaces.NumberPlateView;

/**
 * Created by Nurshat on 08.05.2017.
 */

public class NumberPlate extends RelativeLayout implements TextWatcher, NumberPlateView {
    private View rootView;
    private EditText number, region;
    private Context context;
    private NumberPlatePresenter presenter;
    private int plateType;
    private boolean useHint;


    public NumberPlate(Context context) {
        super(context);
        init(context);
    }

    public NumberPlate(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NumberPlate);
        plateType = a.getInt(R.styleable.NumberPlate_template, 1);
        useHint = a.getBoolean(R.styleable.NumberPlate_use_hint, true);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        rootView = inflate(context, R.layout.number_plate_layout, this);
        number = (EditText) rootView.findViewById(R.id.number);
        region = (EditText) rootView.findViewById(R.id.region);
        presenter = new NumberPlatePresenterImpl(plateType, context, this);
        number.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        number.addTextChangedListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        presenter.onMeasure(widthMeasureSpec, heightMeasureSpec, getMeasuredWidth());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        presenter.onTextChanged(s, start, before, count);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void setNumberConfig(Config config) {
        number.getLayoutParams().height = config.getHeight();
        number.getLayoutParams().width = config.getWidth();
        number.setTextSize(TypedValue.COMPLEX_UNIT_SP, config.getTextSize());
    }

    @Override
    public void setRegionConfig(Config config) {
        region.getLayoutParams().height = config.getHeight();
        region.getLayoutParams().width = config.getWidth();
        region.setTextSize(TypedValue.COMPLEX_UNIT_SP, config.getTextSize());

    }

    @Override
    public void setContainerConfig(Config config) {
        setMeasuredDimension(config.getWidth(), config.getHeight());
    }

    @Override
    public void setNumber(String number) {
        this.number.removeTextChangedListener(this);
        this.number.setText(number);
        this.number.setSelection(this.number.getText().length());
        this.number.addTextChangedListener(this);

        if (this.number.getText().length() == ETFilter.symbolCount) {
            region.requestFocus();
        }
    }

    @Override
    public void setHint(int hint) {
        if(useHint) {
            number.setHint(context.getResources().getString(hint));
            region.setHint(context.getResources().getString(R.string.hint_region));
        }
    }


    @Override
    public void setBackground(int resId) {
        this.setBackgroundResource(resId);
    }

    @Override
    public void setTextColor(int color) {
        number.setTextColor(ContextCompat.getColor(context, color));
        region.setTextColor(ContextCompat.getColor(context, color));

    }

    @Override
    public void setHintColor(int color) {
        number.setHintTextColor(ContextCompat.getColor(context, color));
        region.setHintTextColor(ContextCompat.getColor(context, color));
    }


}
