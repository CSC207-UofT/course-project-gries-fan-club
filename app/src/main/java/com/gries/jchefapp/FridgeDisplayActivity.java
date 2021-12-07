package com.gries.jchefapp;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jchefapp.R;

import java.util.ArrayList;

public class FridgeDisplayActivity extends AppCompatActivity {

    private Button addIngredientButton;
    private Button removeIngredientButton;

    EditText mEdit;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_display);

        listView = (ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

//        arrayList.add("Banana");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        // Add ingredient
        addIngredientButton = (Button) findViewById(R.id.button6);
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.gries.jchefapp.FridgeDisplayActivity.this, "Ingredient Added", Toast.LENGTH_LONG).show();
                mEdit = (EditText) findViewById(R.id.editTextTextPersonName2);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                arrayList.add(mEdit.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                System.out.println(mEdit.getText().toString());

            }
        });

        // Remove Ingredient
        removeIngredientButton = (Button) findViewById(R.id.button9);
        removeIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.gries.jchefapp.FridgeDisplayActivity.this, "Ingredient Removed", Toast.LENGTH_LONG).show();
                mEdit = (EditText) findViewById(R.id.editTextTextPersonName2);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                arrayList.remove(mEdit.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                System.out.println(mEdit.getText().toString());
            }
        });

    }
}