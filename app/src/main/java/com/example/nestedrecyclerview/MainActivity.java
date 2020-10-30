package com.example.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            ArrayList<String> name = new ArrayList<>();
            name.add("SOumo");
            name.add("SOumo");
            name.add("SOumo");


            InventoryItemRecyclerView inventoryItemRecyclerView = new InventoryItemRecyclerView(MainActivity.this, name);
            recyclerView.setAdapter(inventoryItemRecyclerView);
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }



    }
}