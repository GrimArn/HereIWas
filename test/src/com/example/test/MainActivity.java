package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewBillabong = (TextView) findViewById(R.id.Title);
        TextView textViewBillabong2 = (TextView) findViewById(R.id.Title2);
        Typeface fontBillabong = Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        textViewBillabong.setTypeface(fontBillabong);
        textViewBillabong2.setTypeface(fontBillabong);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
