package com.example.nurshat.runumberplateview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Nurshat on 17.05.2017.
 */

public class EditTextListener implements TextWatcher {
    private ETFilter etFilter;
    private EditText number;
    private EditText region;
    private String result;
    private int symbolCount;

    public EditTextListener(String filterTemp, EditText number, EditText region) {
        etFilter = new ETFilter(filterTemp);
        this.number = number;
        this.region = region;
        this.symbolCount = filterTemp.length();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String text = etFilter.filter(s);
        number.removeTextChangedListener(this);
        number.setText(text);
        number.setSelection(number.getText().length());
        number.addTextChangedListener(this);

        if (number.getText().length() == symbolCount) {
            region.requestFocus();
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
