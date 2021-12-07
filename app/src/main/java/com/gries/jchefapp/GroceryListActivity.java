package com.gries.jchefapp;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jchefapp.R;

import java.util.ArrayList;

public class GroceryListActivity extends AppCompatActivity {

//    private Button addIngredientButton2;
//    private Button removeIngredientButton2;
//    EditText mEdit;
    ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        listView2 = (ListView) findViewById(R.id.listview2);
        ArrayList<String> arrayList2 = new ArrayList<>();

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList2);
        listView2.setAdapter(arrayAdapter2);

        arrayList2.add("Banana");

    }
}