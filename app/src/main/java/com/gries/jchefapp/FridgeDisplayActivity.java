package com.gries.jchefapp;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jchefapp.R;

public class FridgeDisplayActivity extends AppCompatActivity {
    private Button addIngredientButton;
    private Button removeIngredientButton;

    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_display);

        // Add ingredient
        addIngredientButton = (Button)findViewById(R.id.button6);
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FridgeDisplayActivity.this, "Ingredient Added", Toast.LENGTH_LONG).show();
                mEdit   = (EditText)findViewById(R.id.editTextTextPersonName2);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                System.out.println(mEdit.getText().toString());

            }
        });

        // Remove Ingredient
        removeIngredientButton = (Button)findViewById(R.id.button9);
        removeIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FridgeDisplayActivity.this, "Ingredient Removed", Toast.LENGTH_LONG).show();
                mEdit   = (EditText)findViewById(R.id.editTextTextPersonName2);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                System.out.println(mEdit.getText().toString());
            }
        });
    }
}