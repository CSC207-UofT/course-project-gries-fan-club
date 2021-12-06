package com.gries.jchefapp;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jchefapp.R;

import java.util.ArrayList;

public class FridgeDisplayActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_display);

        listView = (ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Example 1");
        arrayList.add("Example 2");
        arrayList.add("Example 3");
        arrayList.add("Example 4");
        arrayList.add("Example 5");
        arrayList.add("Example 6");
        arrayList.add("Example 7");
        arrayList.add("Example 8");
        arrayList.add("Example 9");
        arrayList.add("Example 10");
        arrayList.add("Example 11");
        arrayList.add("Example 12");

//        final SwipeToDismissTouchListener<ListViewAdapter> touchListener =
//                new SwipeToDismissTouchListener<>(
//                        new ListViewAdapter(listView),
//                        new SwipeToDismissTouchListener.DismissCallbacks<ListViewAdapter>() {
//                            @Override
//                            public boolean canDismiss(int position) {
//                                return true;
//                            }
//
//                            @Override
//                            public void onPendingDismiss(ListViewAdapter recyclerView, int position) {
//
//                            }
//
//                            @Override
//                            public void onDismiss(ListViewAdapter view, int position) {
//                                adapter.remove(position);
//                            }
//                        });
//        // Dismiss the item automatically after 3 seconds
//        touchListener.setDismissDelay(3000);

//        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
//
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(FridgeDisplayActivity.this,
//                        "clicked item:"+i+" "+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}