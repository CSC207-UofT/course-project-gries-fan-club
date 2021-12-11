package com.gries.jchefapp;

import Controllers.FrontEnd;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jchefapp.R;

import java.io.InputStream;
import java.util.ArrayList;

public class FridgeDisplayActivity extends AppCompatActivity {

    private Button addIngredientButton;

    EditText mEdit;
    ListView listView;
    FrontEnd frontend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_display);

        listView = (ListView) findViewById(R.id.listview1);

        ArrayList<String> arrayList = new ArrayList<>();

//        arrayList.add("Banana");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        Context context = this;
        // Add ingredient
        try {
            AssetManager manager = context.getAssets();
            InputStream ingredientStream = manager.open("Ingredients.json");
            InputStream tagStream = manager.open("tags.json");
            InputStream recipeStream = manager.open("recipes.json");
            InputStream recipeItemStream = manager.open("recipeItems.json");

            this.frontend = new FrontEnd(ingredientStream, tagStream, recipeItemStream, recipeStream);
            System.out.println(this.frontend.fridge().size());

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                frontend.addToFridge(mEdit.getText().toString());


//                System.out.println(mEdit.getText().toString());
                System.out.println(frontend.fridge().ingredientString());

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
                                Toast.makeText(com.gries.jchefapp.FridgeDisplayActivity.this, "IngredientRemoved", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }
}