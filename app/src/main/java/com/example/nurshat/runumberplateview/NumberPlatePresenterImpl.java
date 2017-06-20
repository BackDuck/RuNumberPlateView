package com.example.nurshat.runumberplateview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.nurshat.runumberplateview.Entity.Config;
import com.example.nurshat.runumberplateview.Interfaces.NumberPlatePresenter;
import com.example.nurshat.runumberplateview.Interfaces.NumberPlateView;

/**
 * Created by Nurshat on 04.06.2017.
 */

public class NumberPlatePresenterImpl implements NumberPlatePresenter {

    private Context context;
    private ETFilter filter;
    private NumberPlateView view;

    public NumberPlatePresenterImpl(int plateType, Context context, NumberPlateView view) {
        this.context = context;
        this.view = view;
        int resId;
        int backgroundImage;
        int hint;

        switch (plateType) {
            case 1:
                resId = R.string.filter_1;
                backgroundImage = R.drawable.plate1;
                hint = R.string.hint_1;
                break;
            case 2:
                resId = R.string.filter_2;
                backgroundImage = R.drawable.plate2;
                hint = R.string.hint_2;
                break;
            case 3:
                resId = R.string.filter_3;
                backgroundImage = R.drawable.plate3;
                hint = R.string.hint_3;
                break;
            case 4:
                resId = R.string.filter_4;
                backgroundImage = R.drawable.plate4;
                hint = R.string.hint_4;
                break;
            case 5:
                resId = R.string.filter_5;
                backgroundImage = R.drawable.plate5;
                hint = R.string.hint_5;
                break;
            case 6:
                resId = R.string.filter_6;
                backgroundImage = R.drawable.plate6;
                hint = R.string.hint_6;
                break;
            default:
                resId = R.string.filter_1;
                backgroundImage = R.drawable.plate1;
                hint = R.string.hint_1;
        }

        filter = new ETFilter(context.getResources().getString(resId));
        view.setBackground(backgroundImage);
        view.setHint(hint);

        if(plateType >=3 && plateType<=5){
            view.setTextColor(R.color.whitePlateText);
            view.setHintColor(R.color.lightHintColor);
        }else{
            view.setTextColor(R.color.blackPlateText);
            view.setHintColor(R.color.darkHintColor);
        }
    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        view.setNumber(filter.filter(s));
    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec, int width) {
        Config config = new Config();

        int newHeight = width * 287 / 1280;

        //set root view params
        config.setHeight(newHeight);
        config.setWidth(width);
        view.setContainerConfig(config);

        // set number view params
        config.setHeight(newHeight * convertDpToPixel(60) / convertDpToPixel(67));
        config.setWidth(width * convertDpToPixel(200) / convertDpToPixel(300));
        config.setTextSize(newHeight * 40 / 201);
        view.setNumberConfig(config);

        //set region view params
        config.setHeight(newHeight * convertDpToPixel(50) / convertDpToPixel(67));
        config.setWidth(width * convertDpToPixel(68) / convertDpToPixel(300));
        config.setTextSize(newHeight * 30 / 201);
        view.setRegionConfig(config);
    }


    private int convertDpToPixel(int dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT;
    }
}
