package com.example.nurshat.runumberplateview.Interfaces;


/**
 * Created by Nurshat on 04.06.2017.
 */

public interface NumberPlatePresenter {
    void onTextChanged(CharSequence s, int start, int before, int count);

    void onMeasure(int widthMeasureSpec, int heightMeasureSpec, int width);
}