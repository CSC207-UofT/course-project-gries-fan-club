package com.gries.jchefapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jchefapp.R;

public class FridgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);
    }

    public void Add(View view) {
        Toast.makeText(this, "Hello world", Toast.LENGTH_LONG).show();
    }
}
