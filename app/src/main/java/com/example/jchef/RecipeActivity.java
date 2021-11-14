package com.example.jchef;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RecipeActivity extends AppCompatActivity {

    private Button recipe_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipe_btn = (Button)findViewById(R.id.button2);
        recipe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code goes here
                // display recipes as a listview which on click create and open
                // a new activity that contain standardized textviews
            }
        });
    }
}