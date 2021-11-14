package com.example.jchef;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FridgeActivity extends AppCompatActivity {

    private Button add_btn;
    private Button remove_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        add_btn = (Button)findViewById(R.id.button);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code goes here
                // take input box text, and every time add btn is clicked a new textview is created
            }
        });

        remove_btn = (Button)findViewById(R.id.button3);
        remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code goes here
                // removes the earliest created textview
            }
        });
    }
}