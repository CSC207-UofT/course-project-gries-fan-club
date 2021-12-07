package com.gries.jchefapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jchefapp.R;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        listView2 = (ListView) findViewById(R.id.listview2);

        ArrayList<String> arrayList2 = new ArrayList<>();

        arrayList2.add("Lasagna");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList2);
        listView2.setAdapter(arrayAdapter);
    }
}
