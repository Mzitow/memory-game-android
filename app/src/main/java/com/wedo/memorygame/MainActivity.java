package com.wedo.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MemoryGameAdapater myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        MemoryLevel currentLevel = MemoryLevel.HARD;

      List<Integer> chosenImages = Constants.myImages;
       Collections.shuffle(chosenImages);

       List<Integer> sublist = (List<Integer>) chosenImages.subList(0, currentLevel.getPieces()/2 );
       boolean finalList = sublist.addAll(sublist);

       if (finalList) Collections.shuffle(sublist);

        myAdapter = new MemoryGameAdapater(this,currentLevel, sublist );

        recyclerView.setLayoutManager(new GridLayoutManager(this, currentLevel.getWidh()));
        recyclerView.setAdapter(myAdapter);


    }
}