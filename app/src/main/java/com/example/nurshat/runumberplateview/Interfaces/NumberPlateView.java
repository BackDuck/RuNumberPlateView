package com.example.nurshat.runumberplateview.Interfaces;

import com.example.nurshat.runumberplateview.Entity.Config;

/**
 * Created by Nurshat on 04.06.2017.
 */

public interface NumberPlateView {
    void setNumberConfig(Config config);
    void setRegionConfig(Config config);
    void setContainerConfig(Config config);
    void setNumber(String number);
    void setHint(int hint);
    void setBackground(int resId);
    void setTextColor(int color);
    void setHintColor(int color);
}
