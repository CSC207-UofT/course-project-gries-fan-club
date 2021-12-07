package com.gries.jchefapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jchefapp.R;

import java.util.ArrayList;

public class GroceryListActivity extends AppCompatActivity {

    private Button addIngredientButton;
    private Button importToFridgeButton;

    EditText mEdit;
    ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        listView2 = (ListView) findViewById(R.id.listview2);
        ArrayList<String> arrayList = new ArrayList<>();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView2.setAdapter(arrayAdapter);

//        arrayList2.add("Banana");
        addIngredientButton = (Button) findViewById(R.id.button2);
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GroceryListActivity.this, "IngredientAdded", Toast.LENGTH_LONG).show();
                mEdit = (EditText) findViewById(R.id.editTextTextPersonName2);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                arrayList.add(mEdit.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                System.out.println(mEdit.getText().toString());

            }
        });

        // ADD BUTTON FOR THIS
        importToFridgeButton = (Button) findViewById(R.id.button2);
        importToFridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GroceryListActivity.this, "Ingredient Imported to Fridge", Toast.LENGTH_LONG).show();
                mEdit = (EditText) findViewById(R.id.editTextTextPersonName2);
                // this is the input given to us that we will pass onto the controller
                mEdit.getText().toString();
                // ADD TO FRIDGE
                arrayList.remove(mEdit.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                System.out.println(mEdit.getText().toString());

            }
        });

        listView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                new AlertDialog.Builder(GroceryListActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this ingredient?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(which_item);
                                // !!!!!!!!!WHEN REMOVED FROM GROCERY. ITEM GETS ADDED TO FRIDGE!!!!!!!!
                                arrayAdapter.notifyDataSetChanged();
                                Toast.makeText(GroceryListActivity.this, "Ingredient Removed", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }
}