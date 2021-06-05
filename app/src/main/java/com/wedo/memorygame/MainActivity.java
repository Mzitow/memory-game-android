package com.wedo.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements MemoryGameAdapater.CardOnClickListener {

    RecyclerView recyclerView;
    MemoryGameAdapater myAdapter;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<String> moves;
    List<MemoryCard> selectedCards;
    int userId  = 999, gameId = 764,  moveId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         database = FirebaseDatabase.getInstance();
         myRef = database.getReference();
         moves = new ArrayList<>();



        recyclerView = findViewById(R.id.recycler_view);
        MemoryLevel currentLevel = MemoryLevel.HARD;
        List<Integer> chosenImages = Constants.myImages;
        Collections.shuffle(chosenImages);

       List<Integer> sublist = (List<Integer>) chosenImages.subList(0, currentLevel.getPieces()/2 );
       boolean finalList = sublist.addAll(sublist);

       if (finalList) Collections.shuffle(sublist);

       mapListToArrayOfMemoryClass(sublist);

        myAdapter = new MemoryGameAdapater(this, currentLevel, selectedCards, this );

        recyclerView.setLayoutManager(new GridLayoutManager(this, currentLevel.getWidh()));
        recyclerView.setAdapter(myAdapter);






    }

    private void mapListToArrayOfMemoryClass(List<Integer> sublist) {

        selectedCards = new ArrayList<>();
        for ( Integer x :sublist) {
            MemoryCard currentCard = new MemoryCard(x);
            selectedCards.add(currentCard);
            Log.i("Missing", "mapListToArrayOfMemoryClass: " + x);
        }

    }

    @Override
    public void onCardClick(int cardPosition, MemoryCard memoryCard) {
        //ClickDataModel currentClickData = new ClickDataModel( moveId++, cardPosition);

         memoryCard.setFaceUp(!memoryCard.isFaceUp());

        myRef.child( "Mohamad-IUA")
                .child(Integer.toString(gameId)).push()
                .setValue(Integer.toString(cardPosition));
    }
}