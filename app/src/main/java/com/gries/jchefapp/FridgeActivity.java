package com.gries.jchefapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jchefapp.R;

public class FridgeActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    EditText mEdit;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit   = (EditText)findViewById(R.id.editTextTextPersonName);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                System.out.println(mEdit.getText().toString());
            }
        });

        button2 = (Button)findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit   = (EditText)findViewById(R.id.editTextTextPersonName);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                System.out.println(mEdit.getText().toString());
            }
        });

        button3 = (Button)findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FridgeActivity.this, FridgeDisplayActivity.class));

            }
        });


    }
}
