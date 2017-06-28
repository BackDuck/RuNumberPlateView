package com.example.nurshat.numberplateview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nurshat.runumberplateview.NumberPlate;

public class MainActivity extends AppCompatActivity {
    NumberPlate np;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        np = (NumberPlate) findViewById(R.id.numberPlateView);
        btn = (Button) findViewById(R.id.button);
    }

    public void onClick(View v){
        System.out.println(np.getFullNumber());
        System.out.println(np.getNumber());
        System.out.println(np.getRegion());
        System.out.println(np.toString());
    }
}
