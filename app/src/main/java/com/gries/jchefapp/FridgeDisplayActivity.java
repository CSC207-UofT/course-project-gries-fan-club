package com.gries.jchefapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

        listView = (ListView) findViewById(R.id.listview1);

        ArrayList<String> arrayList = new ArrayList<>();

//        arrayList.add("Banana");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        // Add ingredient
        addIngredientButton = (Button) findViewById(R.id.button6);
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.gries.jchefapp.FridgeDisplayActivity.this, "IngredientAdded", Toast.LENGTH_LONG).show();
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
                Toast.makeText(com.gries.jchefapp.FridgeDisplayActivity.this, "IngredientRemoved", Toast.LENGTH_LONG).show();
                mEdit = (EditText) findViewById(R.id.editTextTextPersonName2);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                arrayList.remove(mEdit.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                System.out.println(mEdit.getText().toString());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                new AlertDialog.Builder(FridgeDisplayActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this ingredient?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(which_item);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }
}